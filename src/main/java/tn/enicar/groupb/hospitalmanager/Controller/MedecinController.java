package tn.enicar.groupb.hospitalmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enicar.groupb.hospitalmanager.Entity.Medecin;
import tn.enicar.groupb.hospitalmanager.Service.MedecinService;

import java.util.List;

public class MedecinController {
    private final MedecinService medecinser;
    @Autowired
    public MedecinController(MedecinService medecinser) {
        this.medecinser = medecinser;
    }
    @GetMapping
    public List<Medecin> getMedecins(){
        return this.medecinser.getMedecins();
    }
    @PostMapping("/add")
    public void registerMedecin(@RequestBody Medecin med){
        this.medecinser.addMedecin(med);
    }
    @DeleteMapping("/delete/{medecinId}")
    public void deleteMedecin(@PathVariable("medecinId") Long id){
        this.medecinser.deleteMedecin(id);
    }
    @PutMapping("/update/{medecinId}")
    public void updateMedecin(@PathVariable("medecinId")Long id,
                              @RequestBody Medecin med){
        this.medecinser.updatemedecin(id,med);
    }

}
