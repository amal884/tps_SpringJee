package ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.repositeries;

import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

   // Role findByRoleName(String roleName);
    Role findByRoleName(String roleName);
}
