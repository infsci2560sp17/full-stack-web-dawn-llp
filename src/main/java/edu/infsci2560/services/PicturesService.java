/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.services;

import edu.infsci2560.models.LipicUsersPictures;
import edu.infsci2560.repositories.UsersPicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;
import edu.infsci2560.storage.StorageFileNotFoundException;
import edu.infsci2560.storage.StorageService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lili8
 */
@RestController
@RequestMapping("/public/api/pictures")
public class PicturesService {

    @Autowired
    private UsersPicturesRepository repository;    
    
    private final StorageService storageService;

    @Autowired
    public PicturesService(StorageService storageService) {
        this.storageService = storageService;
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<LipicUsersPictures>> list() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LipicUsersPictures> list(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findOne(id), headers, HttpStatus.OK);
    }

    // upload a picture
    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<LipicUsersPictures> create(@RequestParam("image") MultipartFile image) {
        
        // add userspictureinfo
        String uuidFile = UUID.randomUUID().toString() +"-" + image.getOriginalFilename();
        storageService.store(image, uuidFile);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LipicUsersPictures picInfo = new LipicUsersPictures(null, 						//create picutre info - id
														formatter.format(new Date()),	//dateCreated
														new Long(0),					//palette Id
														uuidFile,						//file 
														new String[1]);				  //colors detected from picture        
        
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.save(picInfo), headers, HttpStatus.OK);
    }
}
