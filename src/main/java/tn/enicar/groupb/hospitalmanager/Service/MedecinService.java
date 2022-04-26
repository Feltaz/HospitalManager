package tn.enicar.groupb.hospitalmanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicar.groupb.hospitalmanager.Entity.Medecin;
import tn.enicar.groupb.hospitalmanager.Repo.MedecinRepositry;

import java.util.List;

@Service
public class MedecinService {
    private final MedecinRepositry medecinrep;
    private  final ConsultaionService consultationService;
    @Autowired
    public MedecinService(MedecinRepositry medecinrep, ConsultaionService consultaionService) {
        this.medecinrep = medecinrep;
        this.consultationService=consultaionService;
    }

    public List<Medecin> getMedecins(){
        return this.medecinrep.findAll();
    }
    public void addMedecin(Medecin med){
        System.out.println(med);
        this.medecinrep.save(med);
    }
    public void deleteMedecin(Long id){
        if(!this.medecinrep.existsById(id)){
            throw new IllegalStateException("Aucun medecin ayant cet Id");
        }
        else {
            this.medecinrep.deleteById(id);
        }
    }

    public void updatemedecin(Long id, Medecin med){
            this.medecinrep.findById(id)
                    .orElseThrow(()->new IllegalStateException("Aucun medecin ayant cet Id"));
            this.medecinrep.save(med);
    }
}
