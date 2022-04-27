package tn.enicar.groupb.hospitalmanager.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enicar.groupb.hospitalmanager.Entity.Patient;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    void deletePatientById (Long id ) ;
    Optional<Patient> findPatientById(Long id) ;
}
