package tn.enicar.groupb.hospitalmanager.Patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient) {
       patientRepository.save(patient);
    }

    public void deletePatient(long id) {
        boolean exists =patientRepository.existsById(id);
        if (!exists) throw new IllegalStateException("Patient not found");
        patientRepository.deleteById(id);
    }
}


