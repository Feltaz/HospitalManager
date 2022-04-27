package tn.enicar.groupb.hospitalmanager.Patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {


    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService=patientService;
    }
    @GetMapping
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }
    @PostMapping
    public void addPatient(@RequestBody  Patient patient){
        patientService.addPatient(patient);
    }
    @DeleteMapping(path="{patient_id}")
    public void deletePatient(@PathVariable long patient_id){
        patientService.deletePatient(patient_id);
    }
}
