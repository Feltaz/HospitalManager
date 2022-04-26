package tn.enicar.groupb.hospitalmanager.Salle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService {

    private final SalleRepository salleRepository;
    @Autowired
    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }
    public List<Salle> getSalles() {
        return salleRepository.findAll();
    }
}
