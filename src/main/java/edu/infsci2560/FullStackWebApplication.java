package edu.infsci2560;

import java.util.Random;

import edu.infsci2560.models.LipicUsers;
import edu.infsci2560.repositories.UsersRepository;

import edu.infsci2560.models.LipicPalettes;
import edu.infsci2560.repositories.PalettesRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FullStackWebApplication {

    private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FullStackWebApplication.class, args);


///-----------------------------------------------fill random data START------------------------------------------
        ///  fill database
        Random r = new Random();
                
        UsersRepository URrepository = ctx.getBean(UsersRepository.class);
        Long[] historyid = {new Long(12306)};
        URrepository.save(new LipicUsers(1L, "Shaylee-Li", "pass","shalyee@gmail.com","09/20/2017",historyid,true));
        URrepository.save(new LipicUsers(null, "Shaylee-Al", "pass","shalyee@gmail.com","09/20/2017",historyid,true));
        URrepository.save(new LipicUsers(new Long(15), "Shaylee-Ba", "pass","shalyee@gmail.com","09/20/2017",historyid,false));
        URrepository.save(new LipicUsers(new Long(2), "11", "11","shalyee@gmail.com","09/20/2017",historyid,false));
        
        PalettesRepository PaRrepository = ctx.getBean(PalettesRepository.class);
        
        String[] sHex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
//        String[] Pa_colors = {"1232F1","24A7F1","761B2E","09A7D3","90A6C5","1F3D4A"};
        for(int i=0;i<25;i++){
            
            int num_colors = r.nextInt(6) + 1;  //r = 1~6
            String[] Pa_colors = new String[num_colors];
            for (int m=0;m<num_colors;m++){
                String Pa_color = "";  //generate random colorhex
                for (int n=0;n<6;n++){
                    Pa_color = Pa_color + sHex[r.nextInt(16)];
                }
                Pa_colors[m] = Pa_color;
            }

            PaRrepository.save(new LipicPalettes(null,                               //id
                                            String.valueOf(r.nextInt(99999)),     //kuler_id
                                            String.valueOf(r.nextInt(99999)),      //cl_id
                                            Pa_colors,                      //colors[]
                                            r.nextInt(99),          //numLikes
                                            r.nextInt(99),              //numDislikes
                                            String.valueOf(r.nextInt(10)),      //kuler_rating
                                            String.valueOf(r.nextInt(10)),    //cl_rating
                                            "mystery",            //author
                                            "10/11/2020",                   //dateCreated
                                            new Long(r.nextInt(9999))   //userFirst
                                            ));
        }
        
        //--------------------------------------------fill random data END---------------------------------------------
        
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
//    @Bean
//    public CommandLineRunner databaseDemo(CustomerRepository repository) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//            repository.save(new Customer("Billy", "Bean"));
//
//            // fetch all customers
//            log.info("[Database Demo] Customers found with findAll():");
//            log.info("[Database Demo] -------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info("[Database Demo] " + customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findOne(1L);
//            log.info("[Database Demo] Customer found with findOne(1L):");
//            log.info("[Database Demo] --------------------------------");
//            log.info("[Database Demo] " + customer.toString());
//
//            // fetch customers by last name
//            log.info("[Database Demo] Customer found with findByLastName('Bauer'):");
//            log.info("[Database Demo] --------------------------------------------");
//            for (Customer bauer : repository.findByLastName("Bauer")) {
//                log.info("[Database Demo] " + bauer.toString());
//            }
//        };
//    }
}