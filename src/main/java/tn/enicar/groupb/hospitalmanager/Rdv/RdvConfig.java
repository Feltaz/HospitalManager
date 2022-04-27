package tn.enicar.groupb.hospitalmanager.Rdv;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class RdvConfig {

@Bean(name="rdv")
    CommandLineRunner commandLineRunner(RdvRepository rdvRepository) {
    return args -> {
        Rdv rdv = new Rdv(LocalDate.of(2002,1,12));
        rdvRepository.save(rdv);
    };
    }


}
