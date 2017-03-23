package edu.infsci2560.controllers;





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

import edu.infsci2560.models.LipicUsers;
import edu.infsci2560.repositories.UsersRepository;

//import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author kolobj lili8
 */
@Controller
public class UsersController {
    @Autowired
    private UsersRepository repository;
    /*
    @RequestMapping(value = "/users")
    public Iterable<LipicUsers> ListAll() {
        return repository.findAll();
    }
    */

    
   //method = RequestMethod.GET
    @RequestMapping(value = "users")
    public ModelAndView List() {
        return new ModelAndView("users", "users", repository.findAll());
    }
    
    @RequestMapping(value = "/users/{id}")
    public ModelAndView User(@PathVariable("id") Long id) {
        return new ModelAndView("users","users",repository.findOne(id));
    }
    
    
//    @RequestMapping(value = "users/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
//    public ModelAndView create(@ModelAttribute @Valid LipicUsers user, BindingResult result) {
//      repository.save(user);
//        return new ModelAndView("users", "users", repository.findAll());
//    }
    
}
