package ma.enset.use_case1_jpa_hospital.repositories;

import ma.enset.use_case1_jpa_hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
