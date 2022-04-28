package tn.enicar.groupb.hospitalmanager.Salle;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;

import java.util.List;

@Configuration
public class SalleConfig {
    @Bean(name = "salle")
    CommandLineRunner commandLineRunner(SalleRepository salleRepository){
        return args -> {
            Salle salle1 =new Salle(1L,List.of(new Patient("taz")));
            Salle salle2 =new Salle(2L,List.of(new Patient("toza")));
            salleRepository.saveAll(List.of(salle1,salle2));
        };

    }
}
