package tn.enicar.groupb.hospitalmanager.Rdv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return rdvRepository.save(rdv);
    }

    public void deleteRdv(Long id) {
         boolean exist = rdvRepository.existsById(id);
        if(!exist) throw new IllegalArgumentException("Rdv not found");
        rdvRepository.deleteById(id);
    }
}
