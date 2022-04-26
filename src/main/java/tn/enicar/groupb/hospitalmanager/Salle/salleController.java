package tn.enicar.groupb.hospitalmanager.Salle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/salle")
public class salleController {

    private final SalleService salleService;
    @Autowired
    public salleController(SalleService salleService) {
        this.salleService = salleService;
    }
    @GetMapping
    public List<Salle> getSalleService() {
        return salleService.getSalles();
    }
}
