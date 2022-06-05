package ma.enset.use_case1_jpa_hospital.repositories;

import ma.enset.use_case1_jpa_hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
