package edu.infsci2560.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.infsci2560.models.LipicUsers;
import edu.infsci2560.repositories.UsersRepository;
import edu.infsci2560.repositories.ReqActionsRepository;

//import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ActionsController {
    
    @Autowired
    UsersRepository userRepository;
    @Autowired
    ReqActionsRepository actionRepository;
    
    @RequestMapping(value = "actions", method = RequestMethod.GET)
    public ModelAndView List() {
//    public Iterable<LipicPalettes> List() {
//        return repository.findAll();
        return new ModelAndView("actions", "actions", actionRepository.findAll());
    }
    
    @RequestMapping(value = "/actions/ownerid/{id}", method = RequestMethod.GET)
    public ModelAndView Palette(@PathVariable("id") Long id) {
        return new ModelAndView("actions","actions",actionRepository.findByOwnerId(id));
    }
    
    @RequestMapping(value = "/actions/name/{name}", method = RequestMethod.GET)
    public ModelAndView Palette(@PathVariable("name") String name) {
        
        Long userId = userRepository.findByName(name).get(0).getId();
        return new ModelAndView("actions","actions",actionRepository.findByOwnerId(userId));
    }
    
    @RequestMapping(value = "/actions/delete/{id}")
    public ModelAndView DeleteById(@PathVariable("id") Long id) {
        actionRepository.delete(id);
        return new ModelAndView("actions","actions",actionRepository.findAll());
    }    
    
}
