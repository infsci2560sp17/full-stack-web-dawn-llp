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

import edu.infsci2560.models.LipicPalettes;
import edu.infsci2560.repositories.PalettesRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PalettesController {
    @Autowired
    private PalettesRepository repository;
    
       //method = RequestMethod.GET
    @RequestMapping(value = "palettes", method = RequestMethod.GET)
    public ModelAndView List() {
//    public Iterable<LipicPalettes> List() {
//        return repository.findAll();
        return new ModelAndView("palettes", "palettes", repository.findAll());
    }
    
    @RequestMapping(value = "/palettes/{id}", method = RequestMethod.GET)
    public ModelAndView Palette(@PathVariable("id") Long id) {
        return new ModelAndView("palettes","palettes",repository.findOne(id));
    }
    
    @RequestMapping(value = "/palettes/delete/{id}")
    public ModelAndView DeleteById(@PathVariable("id") Long id) {
        repository.delete(id);
        return new ModelAndView("palettes","palettes",repository.findAll());
    }
    
    //http://stackoverflow.com/questions/15313290/spring-mvc-how-do-i-update-a-model-objects-attributes-using-a-controller-meth
    @RequestMapping(value = "/updatelikes/{id}", method = RequestMethod.POST)
    public String updateMember(@PathVariable int id,
    HttpServletRequest request,@ModelAttribute("LipicPalettes") LipicPalettes member) {
      public void editlike(LipicPalettes member){
logger.debug("Editing existing palette likes");

// Retrieve session from Hibernate, if you are using hibernate
Session session = sessionFactory.getCurrentSession();

// Retrieve existing member via id
LipicPalettes existingMember = (LipicPalettes) session.get(LipicPalettes.class, member.getId());

// Assign updated values to this member
existingMember.setKuler_id(member.getKuler_id());
existingMember.setCl_id(member.getCl_id());
existingMember.setColors(member.getColors());
existingMember.setNumLikes(member.like());
existingMember.setNumDislikes(member.getNumDislikes());
existingMember.setKuler_rating(member.getKuler_rating());
existingMember.setCl_rating(member.getCl_rating());
existingMember.setAuthor(member.getAuthor());
existingMember.setDateCreated(member.getDateCreated());
existingMember.setUserFirst(member.getUserFirst());
// Save updates
session.save(existingMember);
}
}

@RequestMapping(value = "/updatedislikes/{id}", method = RequestMethod.POST)
public String updateMember(@PathVariable int id,
HttpServletRequest request,@ModelAttribute("LipicPalettes") LipicPalettes member) {
  public void editdislike(LipicPalettes member){
logger.debug("Editing existing palette dislikes");

// Retrieve session from Hibernate, if you are using hibernate
Session session = sessionFactory.getCurrentSession();

// Retrieve existing member via id
LipicPalettes existingMember = (LipicPalettes) session.get(LipicPalettes.class, member.getId());

// Assign updated values to this member
existingMember.setKuler_id(member.getKuler_id());
existingMember.setCl_id(member.getCl_id());
existingMember.setColors(member.getColors());
existingMember.setNumLikes(member.getNumLikes());
existingMember.setNumDislikes(member.dislike());
existingMember.setKuler_rating(member.getKuler_rating());
existingMember.setCl_rating(member.getCl_rating());
existingMember.setAuthor(member.getAuthor());
existingMember.setDateCreated(member.getDateCreated());
existingMember.setUserFirst(member.getUserFirst());
// Save updates
session.save(existingMember);
}
}

}
