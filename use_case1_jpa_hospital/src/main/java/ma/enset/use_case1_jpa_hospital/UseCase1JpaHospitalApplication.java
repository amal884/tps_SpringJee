package ma.enset.use_case1_jpa_hospital;

import ma.enset.use_case1_jpa_hospital.entities.*;
import ma.enset.use_case1_jpa_hospital.repositories.ConsultationRepository;
import ma.enset.use_case1_jpa_hospital.repositories.MedecinRepository;
import ma.enset.use_case1_jpa_hospital.repositories.PatientRepository;
import ma.enset.use_case1_jpa_hospital.repositories.RendezVousRepository;
import ma.enset.use_case1_jpa_hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class UseCase1JpaHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(UseCase1JpaHospitalApplication.class, args);
    }
    // au demmarage executer cette methode , et il va retourner un objet que spring va le mettre dans son context

    @Bean
    CommandLineRunner start(IHospitalService hospitalService ,
                            PatientRepository patientRepository,RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository,MedecinRepository medecinRepository){
        return args->{
            Stream.of("amal","kawtar","ikram")
                    .forEach(name->{
                        Patient patient =new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });

            Stream.of("aymane","hanane","ilham")
                    .forEach(name->{
                        Medecin medecin =new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");

                        hospitalService.saveMedecin(medecin);
                    });
            Patient patient =patientRepository.findById(1L).orElse(null);
            Patient patient1 =patientRepository.findByNom("amal");
            Medecin medecin =medecinRepository.findByNom("ilham");

            RendezVous rendezVous  = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);

            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());

            consultation.setRendezVous(rendezVous1);
            consultation.setRapport(" Rapport dee la consultation  .........");
            hospitalService.saveConsultation(consultation);

        };
    }

}
