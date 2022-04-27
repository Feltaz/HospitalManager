package tn.enicar.groupb.hospitalmanager.Service;

import tn.enicar.groupb.hospitalmanager.Entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService ;

    public EmployeeResource(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    /*@GetMapping("/all")
    //public List<Employee> getEmployees() {
        //List<Employee> listEmployees = employeeService.findAllEmployees();
        return listEmployees;
    }*/
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }
    @CrossOrigin
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id) ;
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee) ;
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED) ;
    }
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee) ;
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK) ;
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") Long id){
        employeeService.deleteEmployee(id) ;
        return new ResponseEntity<>(HttpStatus.OK) ;
    }
}
