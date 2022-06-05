package ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.service;

import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.Role;
import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.User;

public interface IUserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleNmae(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String userName  , String password);
}
