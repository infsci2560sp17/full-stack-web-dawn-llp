package edu.infsci2560.controllers;


import edu.infsci2560.storage.StorageFileNotFoundException;
import edu.infsci2560.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;
import org.springframework.web.servlet.ModelAndView;
import java.util.UUID;
import edu.infsci2560.models.LipicUsersPictures;

import java.util.Date;
import java.text.SimpleDateFormat;
import edu.infsci2560.repositories.UsersPicturesRepository;


@Controller
public class FileUploadController {
	@Autowired
	private UsersPicturesRepository userspicturerepository;

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }
   
    @RequestMapping(value = "files", method = RequestMethod.GET)
    public ModelAndView listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));
        return new ModelAndView("uploadForm");
    }

    @RequestMapping(value = "files/{filename:.+}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
    
    @RequestMapping(value = "files", method = RequestMethod.POST, consumes="multipart/form-data")
    public String handleFileUpload(@RequestParam("image") MultipartFile image,
                                   RedirectAttributes redirectAttributes) {
									   
        // add userspictureinfo
        String uuidFile = UUID.randomUUID().toString() +"-" + image.getOriginalFilename();
        storageService.store(image, uuidFile);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LipicUsersPictures picInfo = new LipicUsersPictures(null, 						//create picutre info - id
														formatter.format(new Date()),	//dateCreated
														new Long(0),					//palette Id
														uuidFile,						//file 
														new String[1]);				  //colors detected from picture
		userspicturerepository.save(picInfo);		//save picture info									
		
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + uuidFile + "!");

        return "redirect:/files";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}