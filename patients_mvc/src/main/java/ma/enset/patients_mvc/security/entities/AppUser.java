package ma.enset.patients_mvc.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.patients_mvc.security.entities.AppRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id
    private String userId;
    @Column(unique = true)
    private String username ;
    private String password ;
    private Boolean active ;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> appRoleList = new ArrayList<>();
}