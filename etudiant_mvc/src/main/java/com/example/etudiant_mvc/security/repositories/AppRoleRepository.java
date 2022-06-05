package com.example.etudiant_mvc.security.repositories;

import com.example.etudiant_mvc.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRole(String rolname );
}
