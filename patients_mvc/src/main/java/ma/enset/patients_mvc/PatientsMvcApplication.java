package ma.enset.patients_mvc;

import ma.enset.patients_mvc.entities.Patient;
import ma.enset.patients_mvc.repositories.PatientRepository;
import ma.enset.patients_mvc.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
   // @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"amal",new Date(),false,1000));
            patientRepository.save(new Patient(null,"ikram",new Date(),true,590));
            patientRepository.save(new Patient(null,"kawtar",new Date(),false,199));
            patientRepository.save(new Patient(null,"soumia",new Date(),true,339));


            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });


        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
   @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
//            securityService.saveNewUser("amnawwwl" ,"1234","1234");
//            securityService.saveNewUser("kawmtyyar" ,"1234","1234");
//            securityService.saveNewUser("ikramssm" ,"1234","1234");
//
//
//
////            securityService.saveNewRole("USER","");
////            securityService.saveNewRole("ADMIN","");
//
            securityService.addRoleToUser("amnawwwl","USER");
            securityService.addRoleToUser("kawmtyyar","ADMIN");
            securityService.addRoleToUser("kawmtyyar","USER");
            securityService.addRoleToUser("ikramssm","USER");

        };
    }

}
