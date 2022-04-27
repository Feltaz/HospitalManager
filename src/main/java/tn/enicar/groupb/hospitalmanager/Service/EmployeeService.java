package tn.enicar.groupb.hospitalmanager.Service;

import tn.enicar.groupb.hospitalmanager.Entity.Employee;
import tn.enicar.groupb.hospitalmanager.Exception.UserNotFoundException;
import tn.enicar.groupb.hospitalmanager.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo ;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee (Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee) ;
    }

    public List<Employee> findAllEmployees() {
        return (List<Employee>)employeeRepo.findAll() ;
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee) ;
    }

    public Employee findEmployeeById(Long id ) {
        return  employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("user by id " +id +"not found ")) ;
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id) ;
    }
}
