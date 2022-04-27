package tn.enicar.groupb.hospitalmanager.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.enicar.groupb.hospitalmanager.Entity.Operation;

import java.util.Optional;

@Repository
public interface OperationRepositry extends JpaRepository<Operation,Long> {

    @Query(value = "SELECT * FROM operation t WHERE t.id_op = ?1",nativeQuery = true)
    Optional<Operation> findOpById(Long id);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM operation t WHERE t.op.id_op = :ido")
    void deleteOpById(@Param("ido") Long id);

}
