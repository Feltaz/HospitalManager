package tn.enicar.groupb.hospitalmanager.Service;


import tn.enicar.groupb.hospitalmanager.Entity.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/patients")
public class PatientServiceImpl {
    private final PatientService patientService;

    public PatientServiceImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);

    }

    @CrossOrigin
    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) {
        Patient patient = patientService.findPatientById(id) ;
        return  new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient = patientService.addPatient(patient) ;
        return new ResponseEntity<>(newPatient,HttpStatus.CREATED) ;
    }

    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        Patient updatePatient = patientService.updatePatient(patient) ;
        return new ResponseEntity<>(updatePatient,HttpStatus.OK) ;
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable ("id") Long id){
        patientService.deletePatient(id) ;
        return new ResponseEntity<>(HttpStatus.OK) ;
    }
}

