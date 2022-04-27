package tn.enicar.groupb.hospitalmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication

public class HospitalManagerApplication {
    @GetMapping(path="/")
    public String hello (){
        return "Hello World!";
    }
    public static void main(String[] args) {
        SpringApplication.run(HospitalManagerApplication.class, args);
    }



}
