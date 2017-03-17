package edu.infsci2560.controllers;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.io.ByteArrayOutputStream; 
//import java.io.IOException; 
//import java.io.InputStream; 
import java.net.URLEncoder; 

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import org.apache.http.HttpEntity;
import org.apache.http.conn.ConnectTimeoutException;



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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//public class PicataAPI {
///}

@Controller
public class PicataAPI {
    @RequestMapping(value = "PicataAPI")
    public ModelAndView PictaResult( String imagefile){
        //API 返回
        String PicataResult = null;
        
        HttpClient client = new DefaultHttpClient(); 
        List<NameValuePair> list = new ArrayList<NameValuePair>(); 
        
        NameValuePair pair1 = new BasicNameValuePair("image", imagefile); 
        list.add(pair1); 
        
        try {
            
        HttpEntity entity = new UrlEncodedFormEntity(list,"UTF-8"); 
        
        HttpPost post = new HttpPost("http://pictaculous.com/api/1.0/"); 
        post.setEntity(entity); 
        //连接超时
        //client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
        //请求超时
        //client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
        
        HttpResponse response = client.execute(post); 
        
        if(response.getStatusLine().getStatusCode()==200){
            PicataResult = EntityUtils.toString(response.getEntity(), "UTF-8");
        } else {
            //请求失败
            PicataResult = "HTTP POST ERROR";
        }

    //        InputStream in = response.getEntity().getContent();//接收服务器的数据，并在Toast上显示 
    //        String str = readString(in);
    
        } catch (Exception e){
           PicataResult = "ERROR";
        }
        
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("PicataResult");
        mv.addObject("Picata", PicataResult);
        
        return mv;
    } 
}