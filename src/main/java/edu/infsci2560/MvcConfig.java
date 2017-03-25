package edu.infsci2560;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.beans.annotation.AnnotationBeanUtils;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.ViewResolver;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
//@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
       // registry.addViewController("/dvds").setViewName("dvds");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/pictures").setViewName("pictures");
        registry.addViewController("/picupload").setViewName("picupload");
        registry.addViewController("/PicataResult").setViewName("PicataResult");
        //add 3-24 
        registry.addViewController("/updatelikes").setViewName("updatelikes");
        registry.addViewController("/updatedislikes").setViewName("updatedislikes");

    }
    
//    @Bean
//   @Override
//    public ViewResolver viewResolver() {
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setTemplateMode("HTML5");
 //       templateResolver.setPrefix("/templates/");
//        templateResolver.setSuffix(".html");
 //       SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver);
//
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        return viewResolver;
 //   }

}