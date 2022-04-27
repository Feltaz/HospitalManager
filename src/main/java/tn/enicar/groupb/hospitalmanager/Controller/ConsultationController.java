package tn.enicar.groupb.hospitalmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicar.groupb.hospitalmanager.Entity.Consultation;
import tn.enicar.groupb.hospitalmanager.Service.ConsultaionService;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    ConsultaionService consultaionSer;
    @Autowired
    public ConsultationController(ConsultaionService consultaionSer){
        this.consultaionSer=consultaionSer;
    }
    @GetMapping
    public ResponseEntity<List<Consultation>> getConsutations(){
        return new ResponseEntity<List<Consultation>>(this.consultaionSer.findAllCons(), HttpStatus.OK);
    }
    @GetMapping("/{idCons}")
    public ResponseEntity<Consultation> getConsutation(@PathVariable("idCons")Long id){
        return new ResponseEntity<Consultation>(this.consultaionSer.chercherCons(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Consultation> addCons(@RequestBody Consultation cons){
        return new ResponseEntity<>(this.consultaionSer.addCons(cons),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Consultation> addCons(@RequestBody Consultation cons,@PathVariable("id") Long id){
        return  new ResponseEntity<>(this.consultaionSer.updateCons(cons,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCons(@PathVariable("id") Long id){
        this.consultaionSer.deleteCons(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
