package ma.enset.patients_mvc.security.repositories;

import ma.enset.patients_mvc.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRole(String rolname );
}
