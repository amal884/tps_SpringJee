package com.example.etudiant_mvc;

import com.example.etudiant_mvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtudiantMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantMvcApplication.class, args);
    }





    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("amal" ,"1234","1234");
            securityService.saveNewUser("kawtar" ,"1234","1234");
            securityService.saveNewUser("ikram" ,"1234","1234");



            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("amal","USER");
            securityService.addRoleToUser("kawtar","ADMIN");
            securityService.addRoleToUser("ikram","USER");

        };
    }
}
