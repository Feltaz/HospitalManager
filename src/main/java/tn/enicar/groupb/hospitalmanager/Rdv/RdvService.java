package tn.enicar.groupb.hospitalmanager.Rdv;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RdvService {

private final RdvRepository rdvRepository;

@Autowired
public RdvService(RdvRepository rdvRepository) {
    this.rdvRepository = rdvRepository;
}
    public List<Rdv> getRdv(){
        return rdvRepository.findAll();
    }


    public Rdv createRdv(Rdv rdv) {
    boolean exist = rdvRepository.existsById(rdv.getId());
    if(exist) {
        log.warn("Rdv already exist");
        throw new IllegalArgumentException("Rdv already exist");}
    log.info(String.format("Rdv with id %s created",rdv.getId()));
    return rdvRepository.save(rdv);
    }

    public void deleteRdv(Long id) {
         boolean exist = rdvRepository.existsById(id);
        if(!exist) {
            log.warn("Rdv with id "+id+" doesn't exist");
            throw new IllegalArgumentException("Rdv not found");}
        log.info(String.format("Rdv with id %s deleted",id));
        rdvRepository.deleteById(id);
    }

    public Rdv updateRdv(Long id, Rdv rdv) {
        boolean exist = rdvRepository.existsById(id);
        if(!exist) {
            log.warn("Rdv with id "+id+" doesn't exist");
            throw new IllegalArgumentException("Rdv not found");}
        log.info(String.format("Rdv with id %s updated",id));
        return rdvRepository.save(rdv);
    }
}
