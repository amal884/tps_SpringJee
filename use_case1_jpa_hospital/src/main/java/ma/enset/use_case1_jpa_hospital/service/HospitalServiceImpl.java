package ma.enset.use_case1_jpa_hospital.service;

import ma.enset.use_case1_jpa_hospital.entities.Consultation;
import ma.enset.use_case1_jpa_hospital.entities.Medecin;
import ma.enset.use_case1_jpa_hospital.entities.Patient;
import ma.enset.use_case1_jpa_hospital.entities.RendezVous;
import ma.enset.use_case1_jpa_hospital.repositories.ConsultationRepository;
import ma.enset.use_case1_jpa_hospital.repositories.MedecinRepository;
import ma.enset.use_case1_jpa_hospital.repositories.PatientRepository;
import ma.enset.use_case1_jpa_hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service

@Transactional
public class HospitalServiceImpl implements  IHospitalService{

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        // generer un string unique .  il depend de la date du systeme
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
