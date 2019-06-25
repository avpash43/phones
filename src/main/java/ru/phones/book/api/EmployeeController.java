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

    @PostMapping(path="/post", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
}
