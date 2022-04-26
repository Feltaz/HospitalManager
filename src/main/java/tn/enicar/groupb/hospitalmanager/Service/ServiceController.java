package tn.enicar.groupb.hospitalmanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;
import tn.enicar.groupb.hospitalmanager.Salle.Salle;

import java.util.List;

@RestController
@RequestMapping(path="/api/service")
public class ServiceController {
private final ServiceService serviceService;


@Autowired
    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }


    @GetMapping
    public List<Service> getService(){
        return serviceService.getService();
    }

    @PostMapping
    public void addService(@RequestBody  Service service){
        serviceService.addService(service);
    }
    @DeleteMapping(path="/{id}")
    public void deleteService(@PathVariable("id") long id){
        serviceService.deleteService(id);
    }

}
