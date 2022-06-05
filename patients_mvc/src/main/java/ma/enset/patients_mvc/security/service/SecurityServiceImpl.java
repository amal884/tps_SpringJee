package ma.enset.patients_mvc.security.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.patients_mvc.security.entities.AppRole;
import ma.enset.patients_mvc.security.entities.AppUser;
import ma.enset.patients_mvc.security.repositories.AppRoleRepository;
import ma.enset.patients_mvc.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {
    private AppUserRepository appUserRepository ;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder ;
    @Override
    public AppUser saveNewUser(String username, String password, String repassword) {
        if(!password.equals(repassword)) throw new RuntimeException(" password not match");
        String hashedPWD= passwordEncoder.encode(password);
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        AppUser savedAppUser=appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String rolename, String description) {
        AppRole appRole =appRoleRepository.findByRole(rolename);
        if(appRole!=null) throw  new RuntimeException(" Already exist ");
        appRole=new AppRole();
        appRole.setRole(rolename);
        appRole.setDescription(description);
        appRoleRepository.save(appRole);



        return appRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser =appUserRepository.findByUsername(username);
        if(appUser==null) throw  new RuntimeException(" User Not Found  ");
        AppRole appRole =appRoleRepository.findByRole(roleName);
        if(appRole==null) throw  new RuntimeException(" Role Not Found  ");
        appUser.getAppRoleList().add(appRole);
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser appUser =appUserRepository.findByUsername(username);
        if(appUser!=null) throw  new RuntimeException(" User Not Found  ");
        AppRole appRole =appRoleRepository.findByRole(roleName);
        if(appRole!=null) throw  new RuntimeException(" Role Not Found  ");

        appUser.getAppRoleList().remove(appRole);

    }

    @Override
    public AppUser loadUserByUserName(String username) {

        return appUserRepository.findByUsername(username);
    }
}
