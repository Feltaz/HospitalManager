package tn.enicar.groupb.hospitalmanager.Salle;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class SalleService {

    private final SalleRepository salleRepository;
    @Autowired
    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }
    public List<Salle> getSalles() {
        return salleRepository.findAll();
    }

    public Salle createSalle(Salle salle) {
        boolean exist = salleRepository.existsById(salle.getId());
        if (exist) {
            log.warn("salle with id {} already exists", salle.getId());
            throw new IllegalStateException("Salle with id " + salle.getId() + " already exists");
        }
        log.info("creating salle {}", salle);
        return salleRepository.save(salle);
    }

    public Salle updateSalle(Long id, Salle salle) {
        Salle salleToUpdate = salleRepository.findById(id).orElseThrow(() -> new IllegalStateException("Salle with id " + id + " does not exist"));
        salleToUpdate.setId(salle.getId());
        salleToUpdate.setPatients(salle.getPatients());
        log.info("updating salle {}", salleToUpdate);
        return salleRepository.save(salleToUpdate);
    }

    public void deleteSalle(Long id) {
        Salle salleToDelete = salleRepository.findById(id).orElseThrow(() -> new IllegalStateException("Salle with id " + id + " does not exist"));
        log.info("deleting salle {}", salleToDelete);
        salleRepository.delete(salleToDelete);
    }
}
