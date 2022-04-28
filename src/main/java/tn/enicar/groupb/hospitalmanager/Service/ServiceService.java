package tn.enicar.groupb.hospitalmanager.Service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
@Log4j2
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getServices(){
        boolean empty= serviceRepository.findAll().isEmpty();
        if(empty) {
            log.warn("No services found");
            log.warn("attemtpted to get empty list of services");
            throw new IllegalStateException("No services found");
        }
        else{
            log.info("Services found and retrieved");
        return
                serviceRepository.findAll();}
    }

    public void addService(Service service) {
        boolean exists= serviceRepository.existsById(service.getId());
        log.info("Attempting to add service with id: " + service.getId());
        if(exists) {
            log.warn("Service already exists");
            throw new IllegalStateException("Service already exists");

        }
        serviceRepository.save(service);
        log.info("Service added");
    }

    public void deleteService(long id) {
        boolean exists = serviceRepository.existsById(id);
        log.info("Attempting to delete service with id: " + id);
        if(!exists) {
            log.warn(String.format("Service with id %s does not exist"),id);
            throw new IllegalStateException("Service does not exist");
        }
        serviceRepository.deleteById(id);
        log.info(String.format("Service with id %s deleted",id));
    }

    public void updateService(Service service, long id) {
        boolean exists = serviceRepository.existsById(id);
        log.info("Attempting to update service with id: " + id);
        if(!exists) {
            log.warn(String.format("Service with id %s does not exist"),id);
            throw new IllegalStateException("Service does not exist");}
        serviceRepository.deleteById(id);
        service.setId(id);
        service.setNom(service.getNom());
        service.setNbLits(service.getNbLits());
        serviceRepository.save(service);
    }

    public Service getService(long id) {
        boolean exists = serviceRepository.existsById(id);
        log.info("Attempting to fetch service with id: " + id);
        if(!exists) {
            log.warn(String.format("Service with id %s does not exist"),id);
            throw new IllegalStateException("Service does not exist");
        }
        log.info(String.format("Service %s found",id));
        log.info(String.format("Service %s fetched",id));
        return serviceRepository.findById(id).get();
    }
}
