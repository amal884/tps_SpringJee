package ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.repositeries;

import ma.enset.use_case_jpa_hibernate_spring_data_many_to_many_case.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    // c'est spring data :0
    //User findByUserName(String userName);
    User findByUserName(String userName);
}
