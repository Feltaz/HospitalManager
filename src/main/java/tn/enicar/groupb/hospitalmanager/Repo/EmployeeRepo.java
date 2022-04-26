package tn.enicar.groupb.hospitalmanager.Repo;

import tn.enicar.groupb.hospitalmanager.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    void deleteEmployeeById (Long id) ;
    Optional<Employee> findEmployeeById(Long id ) ;
}
