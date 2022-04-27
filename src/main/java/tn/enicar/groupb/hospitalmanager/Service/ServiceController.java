package tn.enicar.groupb.hospitalmanager.Service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;
import tn.enicar.groupb.hospitalmanager.Salle.Salle;

import java.util.List;

@RestController
@RequestMapping(path="/api/service")
@Log4j2
public class ServiceController {
private final ServiceService serviceService;


@Autowired
    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }


    @GetMapping
    public List<Service> getService(){

    return serviceService.getServices();
    }

    @PostMapping
    public void addService(@RequestBody  Service service){

    serviceService.addService(service);
    log.info(String.format("Service %s added",service.getNom()));
    }
    @DeleteMapping(path="/{id}")
    public void deleteService(@PathVariable("id") long id){
        serviceService.deleteService(id);
        log.info(String.format("Service %s deleted",id));
    }
    @PutMapping(path="/{id}")
    public void updateService(@RequestBody Service service, @PathVariable("id") long id){
        serviceService.updateService(service,id);
        log.info(String.format("Service %s updated",service.getNom()));
    }
    @GetMapping(path="/{id}")
    public Service getService(@PathVariable("id") long id){

        return serviceService.getService(id);

    }


}
