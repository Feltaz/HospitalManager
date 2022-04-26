package tn.enicar.groupb.hospitalmanager.Rdv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/rdv")
public class RdvController {
    private final RdvService rdvService;
    @Autowired
    public RdvController(RdvService rdvService) {
        this.rdvService = rdvService;
    }

 @GetMapping
    public List<Rdv> getAllRdv(){
        return rdvService.getRdv();
    }

 @PostMapping
    public Rdv createRdv(@RequestBody  Rdv rdv){
        return rdvService.createRdv(rdv);
    }

 @DeleteMapping(path="/{id}")
    public void deleteRdv(@PathVariable("id") Long id){
        rdvService.deleteRdv(id);
    }

}
