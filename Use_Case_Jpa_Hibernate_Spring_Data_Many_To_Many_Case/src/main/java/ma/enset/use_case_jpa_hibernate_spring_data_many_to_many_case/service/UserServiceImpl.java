package ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.service;

import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.Role;
import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.User;
import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.repositeries.RoleRepository;
import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.repositeries.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service // component de la couche service
@Transactional
public class UserServiceImpl implements IUserService {


    private UserRepository userRepository ;
    private RoleRepository roleRepository ;
    // pour faire l'injection via le constructeur il faut donner a spring un seul constructeur
    // qd il va instancier il va utiliser ce constructeur

    // iinjection via le coonstruucteur.
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return  roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleNmae(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user  = findUserByUserName(username);
        Role role = findRoleByRoleNmae(roleName);
        // il s'agit d'un update  , car la methode est transactionnel
        user.getRoles().add(role);
        role.getUsers().add(user);

        userRepository.save(user);


    }

    @Override
    public User authenticate(String userName, String password) {
        User user = userRepository.findByUserName(userName);
        if(user==null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
        return user;
    }
        throw new RuntimeException("Bad credentials");
}}
