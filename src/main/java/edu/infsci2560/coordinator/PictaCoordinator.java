package edu.infsci2560.coordinator;

import com.google.gson.Gson; // json -> obj
import net.coobird.thumbnailator.Thumbnails; // image compress component 
import java.io.ByteArrayInputStream; // used in image compress process
import java.io.ByteArrayOutputStream; // used in image compress process
import edu.infsci2560.models.TpictaResp;
import org.springframework.web.multipart.MultipartFile;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;

public class PictaCoordinator {
    private String api = "http://pictaculous.com/api/1.0/";
    private int sizeMax = 200*1024;
    
    public String getApi() {return api;}
    public void setApi(String api){
        this.api = api;
    }
    public int getSizeMax() {return sizeMax;}
    public void setSizeMax(int sizeMax){
        this.sizeMax = sizeMax;
    }
    
    public PictaCoordinator(){
        this.api = "http://pictaculous.com/api/1.0/";
        this.sizeMax = 200*1024;
    }
    
    public PictaCoordinator(String api, int sizeMax ){  //full constructor
        this.api = api;
        this.sizeMax = sizeMax;
    }
    
    public TpictaResp PostBinaryImage(MultipartFile image) throws Exception {
            
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            HttpPost post = new HttpPost(api); 
            
            if (image.getSize() > sizeMax) {   // if image is too large
                //------------------image compress ---------------------------
                ByteArrayOutputStream os = new ByteArrayOutputStream();
              
                 //.outputFormat("jpeg").outputQuality(0.8)
                Thumbnails.of(image.getInputStream()).size(1200, 1200).outputFormat("jpg").outputQuality(0.8).toOutputStream(os); //1st: compress to 1200*1200 max
            
                while (os.size()>sizeMax){     // 2nd: loop to reduce size to meet the limit
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
                
                
            CloseableHttpClient client = HttpClients.createDefault();
            
            HttpEntity entity = builder.build();
            post.setEntity(entity); 
            HttpResponse response = client.execute(post); 
            
            String PictaResult = EntityUtils.toString(response.getEntity(), "UTF-8");
           
           
            client.close(); //close httpclient
            
      //      if(response.getStatusLine().getStatusCode()==200){
            Gson gson = new Gson();
            TpictaResp pictaResp = gson.fromJson(PictaResult, TpictaResp.class); //json -> obj
            
            return pictaResp;  // need to deal with error
      //      }

    }
}
