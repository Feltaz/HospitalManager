package tn.enicar.groupb.hospitalmanager.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getService(){
        return serviceRepository.findAll();
    }

    public void addService(Service service) {
        System.out.println(service);
    }
}
