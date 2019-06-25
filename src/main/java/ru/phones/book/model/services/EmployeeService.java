package ru.phones.book.model.services;

import ru.phones.book.model.entites.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long employeeId);
}
