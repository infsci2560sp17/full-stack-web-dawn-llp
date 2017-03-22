package edu.infsci2560.controllers;

//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.io.ByteArrayOutputStream; 
//import java.io.IOException; 
//import java.io.InputStream; 
//import java.net.URLEncoder; 

import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
//import org.apache.http.HttpVersion;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

//import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.ContentBody;
//import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.ContentType;

import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.params.CoreProtocolPNames;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

//import org.apache.http.entity.ByteArrayEntity;
//import org.apache.http.conn.ConnectTimeoutException;

import edu.infsci2560.models.Picture;
import edu.infsci2560.repositories.PictureRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import edu.infsci2560.models.PictaResp;  not bean format
import edu.infsci2560.models.TpictaResp;
import edu.infsci2560.models.LiColors;

import com.google.gson.Gson; // json -> obj
import net.coobird.thumbnailator.Thumbnails; // image compress component 
import java.io.ByteArrayInputStream; // used in image compress process
import java.io.ByteArrayOutputStream; // used in image compress process
//import com.google.gson.reflect.TypeToken;
//import java.lang.reflect.Type;



@Controller
public class pictaupload{
//    @RequestMapping(value="pictureupload", method=RequestMethod.GET)
//    public ModelAndView index() {
//        return new ModelAndView("pictureupload.html");
 //       return new ModelAndView("pictures", "pictures", repository.findAll());
 //   }
 
    
 //   public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
 //   {
 //       File convFile = new File( multipart.getOriginalFilename());
 //       multipart.transferTo(convFile);
 //       return convFile;
 //   }

    @RequestMapping(value="/pictaupload", method=RequestMethod.POST)
    public ModelAndView Pictaupload(@RequestParam("image") MultipartFile image) throws Exception {
    
    String APIUrl = new String ("http://pictaculous.com/api/1.0/"); // API location req POST {image:binarycontent}
    int sizeLimit = 200*1024;  // picta api limit = 200k
    
    if (!image.isEmpty()){
        
        String PictaResult = null;
                //------------------go to Picta-------------------------------
        
        
 // MAR.07 use namevaluepair
  //      String imagecontent = new String(image.getBytes());
  //      String imagecontent = new Integer.toBinaryString(image.getBytes());
 //       List<NameValuePair> list = new ArrayList<NameValuePair>(); 
///       NameValuePair pair1 = new BasicNameValuePair("image", imagecontent); 
//        list.add(pair1); 
    //    HttpEntity entity = new UrlEncodedFormEntity(list,"ISO-8859-1"); 
    //    HttpEntity entity = new ByteArrayEntity(image.getBytes());

//MAR.17 transfer Multipartfile to File with temp file 
        //MultipartEntity entity = new MultipartEntity();
       // ContentBody imagebody = new FileBody(multipartToFile(image), "image/jpeg");
     //   entity.addPart("image", imagebody);

    //  mar.18   without temp file
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        
        if (image.getSize() > sizeLimit) {   // if image is too large
            //------------------image compress ---------------------------
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            
            //.outputFormat("jpeg").outputQuality(0.8)
            Thumbnails.of(image.getInputStream()).size(1200, 1200).outputFormat("jpg").outputQuality(0.8).toOutputStream(os); //1st: compress to 1200*1200 max
            
            while (os.size()>sizeLimit){     // 2nd: loop to reduce size to meet the limit
                ByteArrayInputStream in = new ByteArrayInputStream(os.toByteArray());
                os.flush();
                Thumbnails.of(in).scale(0.9).toOutputStream(os);
                in.close();
            }
            
            builder.addBinaryBody("image", os.toByteArray());// compressed image stream
            
            os.close();
              
        } else {   // image src is less than 200k and okay to picta api
            builder.addBinaryBody("image", image.getInputStream());// image Stream
        }
        
        HttpEntity entity = builder.build();
        
        HttpPost post = new HttpPost(APIUrl); 
        post.setEntity(entity); 
        
        //client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        //timeout
        //client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
        //client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(post); 
        
        if(response.getStatusLine().getStatusCode()==200){
  //        InputStream in = response.getEntity().getContent();
  //        String str = readString(in);
            PictaResult = EntityUtils.toString(response.getEntity(), "UTF-8");
        } else {
            //request failed
            PictaResult = "HTTP POST ERROR";
        }
            
        client.close(); //close httpclient
        
        
        //--------------------Read Json-------------------------------------
        Gson gson = new Gson();
        TpictaResp pictaResp = gson.fromJson(PictaResult, TpictaResp.class); //json -> obj
        
    //    java.lang.reflect.Type type = new TypeToken<PictaResp>() {}.getType();
   //     PictaResp pictaResp = gson.fromJson(PictaResult, type);
   
        //--------------------Generate Result--------------------------------------------
     //   int colorslength = pictaResp.getInfo().getColors().length;
        int colorslength = pictaResp.getKuler_themes().get(0).getColors().length;
      
     //   List<LiColors> liColors = new List<LiColors>;
        ArrayList liColors = new ArrayList();
        
        for ( int i =0; i<colorslength;i++){
            LiColors aColor = new LiColors(pictaResp.getKuler_themes().get(0).getColors()[i]);
            liColors.add(aColor);
        }
        
//        String[] testS  = new String[3];
//        testS[0] = "1111";
//        testS[1] = "2222";
//        testS[2] = "3333";
        
        //------------------Show Result Page----------------------------
        ModelAndView mv = new ModelAndView();
        mv.setViewName("PicataResult");
        mv.addObject("liColors",liColors);
 //       mv.addObject("liColors1", pictaResp.getInfo().getColors()[0]);
 //       mv.addObject("liColors2", pictaResp.getInfo().getColors()[1]);
//        mv.addObject("Picata", pictaResp.info.colors[0]);
        
        return mv;
        
    } else {
        //if no file submitted
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/PictaError");  //temp, not created yet
        return mv;
    } 
        
        
    }
    
}
