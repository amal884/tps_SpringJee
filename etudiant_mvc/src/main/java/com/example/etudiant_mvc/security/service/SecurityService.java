package com.example.etudiant_mvc.security.service;

import com.example.etudiant_mvc.security.entities.AppRole;
import com.example.etudiant_mvc.security.entities.AppUser;


public interface SecurityService {
    AppUser saveNewUser(String  username , String password, String repassword) ;
    AppRole saveNewRole(String rolename , String description );
    void addRoleToUser(String username , String roleName);
    void removeRoleFromUser(String username , String roleName);
    AppUser loadUserByUserName(String username);
}
