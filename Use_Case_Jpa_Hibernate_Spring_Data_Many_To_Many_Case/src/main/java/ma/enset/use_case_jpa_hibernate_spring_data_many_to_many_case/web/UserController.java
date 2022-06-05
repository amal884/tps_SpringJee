package ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.web;

import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.User;
import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable  String username){
        User user =userService.findUserByUserName(username);
        return user ;
    }
}
