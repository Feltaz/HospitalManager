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

    public List<Service> getServices(){

        return
                serviceRepository.findAll();
    }

    public void addService(Service service) {
        boolean exists= serviceRepository.existsById(service.getId());
        if(exists) throw new IllegalStateException("Service already exists");
        serviceRepository.save(service);
    }

    public void deleteService(long id) {
        boolean exists = serviceRepository.existsById(id);
        if(!exists) throw new IllegalStateException("Service does not exist");
        serviceRepository.deleteById(id);
    }

    public void updateService(Service service, long id) {
        boolean exists = serviceRepository.existsById(id);
        if(!exists) throw new IllegalStateException("Service does not exist");
        serviceRepository.deleteById(id);
        service.setId(id);
        service.setNom(service.getNom());
        service.setNbLits(service.getNbLits());
        serviceRepository.save(service);
    }

    public Service getService(long id) {
        boolean exists = serviceRepository.existsById(id);
        if(!exists) throw new IllegalStateException("Service does not exist");
        return serviceRepository.findById(id).get();
    }
}
