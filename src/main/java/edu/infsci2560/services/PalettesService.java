/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.services;

import edu.infsci2560.models.LipicPalettes;
import edu.infsci2560.repositories.PalettesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lili8
 */
@RestController
@RequestMapping("/public/api/palettes")
public class PalettesService {
    
    public class LikeReturn{
        private int likes;
        private int dislikes;
        public int getLikes() {return likes;}
        public void setLikes(int likes){
            this.likes = likes;
        }
        public int getDislikes() {return dislikes;}
        public void setDislikes(int dislikes){
            this.dislikes = dislikes;
        }
        public LikeReturn(int likes, int dislikes) {
            this.likes = likes;
            this.dislikes = dislikes;
        }
    }

    @Autowired
    private PalettesRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<LipicPalettes>> list() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LipicPalettes> list(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findOne(id), headers, HttpStatus.OK);
    }
    
    //delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Iterable<LipicPalettes>> delete(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        repository.delete(id);
        return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
    }
    
    //put -- add numlikes
    @RequestMapping(value = "/ajax/like/{id}", produces = "application/json")
    public ResponseEntity<LikeReturn> like(@PathVariable("id") Long id, @RequestParam("numLikes") int numLikes) {
        System.out.println("Get like put");
        LikeReturn like = new LikeReturn(0,0);
        LipicPalettes palette = repository.findOne(id);
        if (palette != null) {
            if (palette.getNumLikes() == numLikes){    /// thow if likes number in  web request dont match the database in case combo
                palette.like();
                repository.save(palette);
            }
            like.setLikes(palette.getNumLikes());
            like.setDislikes(palette.getNumDislikes());
        }
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(like, headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ajax/dislike/{id}", produces = "application/json")
    public ResponseEntity<LikeReturn> dislikelike(@PathVariable("id") Long id, @RequestParam("numDislikes") int numDislikes) {
        System.out.println("Get dislike put");
        LikeReturn dislike = new LikeReturn(0,0);
        LipicPalettes palette = repository.findOne(id);
        if (palette != null) {
            if (palette.getNumDislikes() == numDislikes){    /// thow if likes number in  web request dont match the database in case combo
                palette.dislike();
                repository.save(palette);
            }
            dislike.setLikes(palette.getNumLikes());
            dislike.setDislikes(palette.getNumDislikes());
        }
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(dislike, headers, HttpStatus.OK);
    }
    
    
    //post
    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<LipicPalettes> create(@RequestBody LipicPalettes palette) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.save(palette), headers, HttpStatus.OK);
    } 
}
