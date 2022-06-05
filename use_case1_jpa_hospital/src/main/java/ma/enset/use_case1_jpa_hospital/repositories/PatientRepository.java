package ma.enset.use_case1_jpa_hospital.repositories;

import ma.enset.use_case1_jpa_hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);
}
