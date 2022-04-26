package tn.enicar.groupb.hospitalmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicar.groupb.hospitalmanager.Entity.Operation;
import tn.enicar.groupb.hospitalmanager.Service.OperationService;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {
    OperationService operationSer;
    @Autowired
    public OperationController(OperationService operationSer){
        this.operationSer=operationSer;
    }
    @GetMapping
    public ResponseEntity<List<Operation>> getOperations(){
        return new ResponseEntity<List<Operation>>(this.operationSer.findAllOp(), HttpStatus.OK);
    }
    @GetMapping("/{idOp}")
    public ResponseEntity<Operation> getConsutation(@PathVariable("idOp")Long id){
        return new ResponseEntity<Operation>(this.operationSer.chercherOp(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Operation> addCons(@RequestBody Operation opr){
        return new ResponseEntity<>(this.operationSer.addOp(opr),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Operation> addCons(@RequestBody Operation opr,@PathVariable("id") Long id){
        return  new ResponseEntity<>(this.operationSer.updateOp(opr,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCons(@PathVariable("id") Long id){
        this.operationSer.deleteOp(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }}

