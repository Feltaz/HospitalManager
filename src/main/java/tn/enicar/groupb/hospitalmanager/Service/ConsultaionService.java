package tn.enicar.groupb.hospitalmanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicar.groupb.hospitalmanager.Entity.Consultation;
import tn.enicar.groupb.hospitalmanager.Repo.ConsultationRepositry;

import java.util.List;

@Service
public class ConsultaionService {
    private ConsultationRepositry consultationRepo;
    @Autowired
    public ConsultaionService(ConsultationRepositry consultationRepo){
        this.consultationRepo=consultationRepo;
    }
    public List<Consultation> findAllCons() {
        return this.consultationRepo.findAll();
    }
    public Consultation addCons(Consultation cons){
        return this.consultationRepo.save(cons);
    }
    public void deleteCons(Long id){
         this.consultationRepo.findConsById(id).orElseThrow(()->new IllegalStateException("cette consultaion ayant cet ID " +
                 "n'existe pas"));
         this.consultationRepo.deleteConsById(id);
    }
    public Consultation updateCons(Consultation cons,Long id){
        this.consultationRepo.findConsById(id).orElseThrow(()->new IllegalStateException("cette consultaion ayant cet ID " +
                "n'existe pas"));
        return this.consultationRepo.save(cons);
    }
    public Consultation chercherCons(Long id){
        return this.consultationRepo.findConsById(id).orElseThrow(()-> new IllegalStateException("cette consultaion ayant cet ID " +
                "n'existe pas"));
    }


}
