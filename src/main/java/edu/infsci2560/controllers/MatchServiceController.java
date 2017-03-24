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

import edu.infsci2560.models.LipicPalettes;
import edu.infsci2560.repositories.PalettesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;

import edu.infsci2560.models.PictaReqResult;

import java.util.Date;
import java.text.SimpleDateFormat;

import edu.infsci2560.storage.StorageFileNotFoundException;
import edu.infsci2560.storage.StorageService;

import edu.infsci2560.models.LipicUsersPictures;
import edu.infsci2560.repositories.UsersPicturesRepository;


import java.util.ArrayList;

@Controller
public class MatchServiceController {
	
	@Autowired
	private PalettesRepository palettesrepository;
	@Autowired
	private UsersPicturesRepository userspicturesrepository;
	
	private final StorageService storageService;

    @Autowired
    public MatchServiceController(StorageService storageService) {
        this.storageService = storageService;
    }
    
    @RequestMapping(value="/match", method=RequestMethod.POST)   //post match with image param return Page Result
    public ModelAndView Pictaupload(@RequestParam("image") MultipartFile image) throws Exception {
        if (!image.isEmpty()){
			
			ModelAndView mv = new ModelAndView();
            mv.setViewName("PicataResult");  
			
            PictaCoordinator pc = new PictaCoordinator(palettesrepository);
			PictaReqResult reqResult = pc.PostBinaryImage(image, new Long(10086));
			
			mv.addObject("palettes",palettesrepository.findOne(reqResult.getPaletteId()));  //return palette info
			mv.addObject("pictureColors",reqResult.getColors());							//return colors detected from user's picture
			
			//generate an unique image file name
			//UUID uuid  =  UUID.randomUUID(); 
			String uuidFile = UUID.randomUUID().toString() + image.getOriginalFilename();
			storageService.store(image, uuidFile);                       //save image
			
			mv.addObject("imageUrl",uuidFile);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			userspicturesrepository.save( new LipicUsersPictures( null, // save picture info  - id
														formatter.format(new Date()), //dateCreated
														reqResult.getPaletteId(),
														uuidFile, 			//image file name
														reqResult.getColors()
														));
			
			
			
			//mv.addObject("image",)
			
			
//            TpictaResp pictaResp = pc.PostBinaryImage(image);
            
  //          int colorslength = pictaResp.getKuler_themes().get(0).getColors().length;
 //           ArrayList liColors = new ArrayList();
        
 //           for ( int i =0; i<colorslength;i++){
 //               LiColors aColor = new LiColors(pictaResp.getKuler_themes().get(0).getColors()[i]);
 //               liColors.add(aColor);
 //           }
            
        //------------------Show Result Page----------------------------

            
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