package ma.enset.use_case1_jpa_hospital.repositories;

import ma.enset.use_case1_jpa_hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
