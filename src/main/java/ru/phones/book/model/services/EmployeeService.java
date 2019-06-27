package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    ResponseEntity<Employee> findById(Long employeeId);
    ResponseEntity<Employee> findByLastname(String lastname);
    Employee addEmployee(Employee employee);
    void deleteEmployeeById(Long employeeId);
    void updateEmployee(Employee employee);
}
