package edu.infsci2560.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.infsci2560.coordinator.PictaCoordinator;
import edu.infsci2560.models.TpictaResp;
import edu.infsci2560.models.LiColors;

import java.util.ArrayList;

@Controller
public class MatchServiceController {
    
    @RequestMapping(value="/match", method=RequestMethod.POST)   //post match with image param return Page Result
    public ModelAndView Pictaupload(@RequestParam("image") MultipartFile image) throws Exception {
        if (!image.isEmpty()){
            PictaCoordinator pc = new PictaCoordinator();
            TpictaResp pictaResp = pc.PostBinaryImage(image);
            
            int colorslength = pictaResp.getKuler_themes().get(0).getColors().length;
            ArrayList liColors = new ArrayList();
        
            for ( int i =0; i<colorslength;i++){
                LiColors aColor = new LiColors(pictaResp.getKuler_themes().get(0).getColors()[i]);
                liColors.add(aColor);
            }
            
        //------------------Show Result Page----------------------------
            ModelAndView mv = new ModelAndView();
            mv.setViewName("PicataResult");  //
            mv.addObject("liColors",liColors);
 //       mv.addObject("liColors1", pictaResp.getInfo().getColors()[0]);
 //       mv.addObject("liColors2", pictaResp.getInfo().getColors()[1]);
//        mv.addObject("Picata", pictaResp.info.colors[0]);
        
        return mv;
        } else {
            //if no file submitted
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/error");  //temp, not created yet
            return mv;
        } 

    }
    
    //@RequestMapping(value="/match", method=RequestMethod.GET)           //get match with image param return JSON Result
    //public ModelAndView Pictaupload(@RequestParam("image") MultipartFile image) throws Exception {
    //}

    
}
