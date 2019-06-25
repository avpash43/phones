package ru.phones.book.model.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Employee;
import ru.phones.book.model.repositories.EmployeeRepository;
import ru.phones.book.model.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public  List<Employee> findAll() {
        List<Employee> epmloyees = (List<Employee>) employeeRepository.findAll();
        return epmloyees;
    }

    public Employee findById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(new Employee());
    }
}
