package ma.enset.use_case1_jpa_hospital.service;

import ma.enset.use_case1_jpa_hospital.entities.Consultation;
import ma.enset.use_case1_jpa_hospital.entities.Medecin;
import ma.enset.use_case1_jpa_hospital.entities.Patient;
import ma.enset.use_case1_jpa_hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
