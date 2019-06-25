package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    ResponseEntity<Employee> findById(Long employeeId);
}
