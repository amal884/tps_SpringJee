package ma.enset.patients_mvc.web;

import ma.enset.patients_mvc.entities.Patient;
import ma.enset.patients_mvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
     @GetMapping(path = "/user/index")
    public String patients(Model model , @RequestParam(defaultValue =  "0") int page,
                                         @RequestParam(defaultValue = "5" ) int size,
                                         @RequestParam(defaultValue = "" ) String keyword ){
         Page<Patient> patients = patientRepository.findByNomContains(keyword,PageRequest.of(page, size));
         model.addAttribute("listPatients" , patients);
         model.addAttribute("pages" , new int[patients.getTotalPages()]);
         model.addAttribute("currentPage", page);
         model.addAttribute("keyword",keyword);

        return "patients";
     }
     @GetMapping("/admin/delete")
     public String delete(Long id , String keyword , int page ){
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
     }
    @GetMapping("/")
    public String home(){

        return "home";
    }
    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> ListPatients(){
        return patientRepository.findAll();
    }
    @GetMapping("/admin/formPatients")
    public String formPatients(Model model){
        Patient patient = new Patient();
        if (patient != null) {
            model.addAttribute("p", patient);
        } else {
            model.addAttribute("p", new Patient());
        }
        return "formPatients";
    }
    @PostMapping(path = "/admin/save")
    public String save( @Valid  @ModelAttribute Patient patient, BindingResult bindingResult ,Model model ,@RequestParam(defaultValue = "0") int page ,
                        @RequestParam(defaultValue = "") String keyword){
        model.addAttribute("p", patient);
        if(bindingResult.hasErrors()) {
            return "formPatients";
        }

        patientRepository.save(patient);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editPatient")
    public String editPatient(Model model , Long id , String keyword , int page ){
        Patient patient =patientRepository.findById(id).orElse(null);
        if(patient==null) throw new RuntimeException("patient introuvable");
        model.addAttribute("p" ,patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editPatient";
    }
}
