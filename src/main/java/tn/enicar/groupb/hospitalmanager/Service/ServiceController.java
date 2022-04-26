package tn.enicar.groupb.hospitalmanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;
import tn.enicar.groupb.hospitalmanager.Salle.Salle;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
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

}
