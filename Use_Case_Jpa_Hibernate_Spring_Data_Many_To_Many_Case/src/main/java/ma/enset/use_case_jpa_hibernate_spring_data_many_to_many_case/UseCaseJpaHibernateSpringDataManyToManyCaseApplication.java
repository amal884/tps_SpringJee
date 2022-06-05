package ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case;

import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.Role;
import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.User;
import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UseCaseJpaHibernateSpringDataManyToManyCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(UseCaseJpaHibernateSpringDataManyToManyCaseApplication.class, args);
    }
    @Bean // methode qui s'execute au demmarage
    CommandLineRunner start(IUserService userService) {
        return args -> {
            User u = new User();
            u.setUserName("user1");
            u.setPassword("12345");
            userService.addNewUser(u);

            User u2 = new User();
            u2.setUserName("admin");
            u2.setPassword("12345");
            userService.addNewUser(u2);

            Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
                Role role1 = new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });
            userService.addRoleToUser("user1", "STUDENT");
            userService.addRoleToUser("user1", "USER");
            userService.addRoleToUser("admin", "USER");
            userService.addRoleToUser("admin", "ADMIN");

            try {
                User user = userService.authenticate("user1", "12345");
                System.out.println(user.getUserId());
                System.out.println(user.getUserName());
                System.out.println("Roles=>");
                user.getRoles().forEach(r->{
                    System.out.println("Role =>" +r);
                });

            } catch (Exception e) {
                e.printStackTrace();
            }


        };

    }}
