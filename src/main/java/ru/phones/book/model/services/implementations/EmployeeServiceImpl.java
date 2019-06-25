package ru.phones.book.model.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Employee;
import ru.phones.book.model.repositories.EmployeeRepository;
import ru.phones.book.model.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById() {
        return employeeRepository.findById(1L).orElse(new Employee());
    }
}
