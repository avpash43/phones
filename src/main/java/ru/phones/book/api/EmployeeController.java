package ru.phones.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.Employee;
import ru.phones.book.model.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path="/api/employee", produces="application/json")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<Employee> getById(@PathVariable(name="employeeId")Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping("/get/{lastname}")
    public ResponseEntity<Employee> getByLastname(@PathVariable(name="lastname")String lastname) {
        return employeeService.findByLastname(lastname);
    }

    @PostMapping(path="/post", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployeeById(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @PutMapping(path="/update/{employeeId}", consumes="application/json")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable(name="employeeId")Long employeeId) {
        Employee emp = employeeService.findById(employeeId).getBody();
        if (emp != null && employee.getId() != null) {
            employeeService.updateEmployee(employee);
        }
    }
}
