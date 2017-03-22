package edu.infsci2560.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.infsci2560.models.LipicResult;

@RestController
public class LipicApiController {
    
    @RequestMapping("/api")
    public LipicResult LipicAPI(@RequestParam(value="image") String imageUrl) {
    
        String[] colors = {"010101","020202","030303"};     //temp
        LipicResult result = new LipicResult(colors,80,20,imageUrl); //temp
        return result;
    }

}
