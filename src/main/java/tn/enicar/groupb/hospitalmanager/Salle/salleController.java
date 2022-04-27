package tn.enicar.groupb.hospitalmanager.Salle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //TODO: PostMapping and PutMapping and DeleteMapping
    @PostMapping
    public Salle createSalle(@RequestBody  Salle salle){
        return salleService.createSalle(salle);
    }
    @PutMapping("/{id}")
    public Salle updateSalle(@PathVariable Long id, @RequestBody Salle salle){
        return salleService.updateSalle(id, salle);
    }
    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable Long id){
        salleService.deleteSalle(id);
    }
}


