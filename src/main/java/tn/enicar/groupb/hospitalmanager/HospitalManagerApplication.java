package tn.enicar.groupb.hospitalmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
public class HospitalManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagerApplication.class, args);
    }

}
