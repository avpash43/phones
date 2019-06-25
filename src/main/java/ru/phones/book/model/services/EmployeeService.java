package ru.phones.book.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.phones.book.model.Employee;
import ru.phones.book.model.repositories.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void testEmployeesCrudRepository() {
        Employee employee = employeeRepository.findById(1L).orElse(new Employee());
    }
}
