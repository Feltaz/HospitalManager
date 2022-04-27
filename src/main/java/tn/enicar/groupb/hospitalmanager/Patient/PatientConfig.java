package tn.enicar.groupb.hospitalmanager.Patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfig {
@Bean(name="patient")

    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
    return arg -> {
      Patient patient =  new Patient("taz");
      patientRepository.save(patient);
    };
    }
}
