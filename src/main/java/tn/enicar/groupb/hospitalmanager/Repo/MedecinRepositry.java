package tn.enicar.groupb.hospitalmanager.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enicar.groupb.hospitalmanager.Entity.Medecin;

@Repository
public interface MedecinRepositry extends JpaRepository<Medecin, Long> {

}
