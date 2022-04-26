package tn.enicar.groupb.hospitalmanager.Service;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;
import tn.enicar.groupb.hospitalmanager.Patient.PatientRepository;
import tn.enicar.groupb.hospitalmanager.Salle.Salle;
import tn.enicar.groupb.hospitalmanager.Salle.SalleRepository;
import tn.enicar.groupb.hospitalmanager.Salle.SalleService;

import java.util.List;

@Configuration
public class ServiceConfig {

    @Bean(name ="service")
    CommandLineRunner commandLineRunner(ServiceRepository repository ){
        return args -> {

            Service service = new Service(
                            "service bellil",
                            3L
                            );

            repository.saveAll(List.of(service));
        };
    }
}
