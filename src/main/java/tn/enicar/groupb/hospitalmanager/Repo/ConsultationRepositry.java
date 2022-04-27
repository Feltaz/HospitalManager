package tn.enicar.groupb.hospitalmanager.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.enicar.groupb.hospitalmanager.Entity.Consultation;

import java.util.Optional;

@Repository
public interface ConsultationRepositry extends JpaRepository<Consultation,Long> {

    @Query(value = "SELECT * FROM consultation t WHERE t.id_cons = ?1",nativeQuery = true)
    Optional<Consultation> findConsById(Long id);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM consultation t WHERE t.medPat.id_cons = :idc")
    void deleteConsById(@Param("idc") Long id);



}
