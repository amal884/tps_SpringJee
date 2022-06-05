package ma.enset.use_case1_jpa_hospital.web;

import ma.enset.use_case1_jpa_hospital.entities.Patient;
import ma.enset.use_case1_jpa_hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {

    @Autowired
    private PatientRepository patientRepository ;
    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
