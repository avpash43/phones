package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return  employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Employee> findById(Long employeeId) {
        Optional<Employee> optEmployee = employeeRepository.findById(employeeId);
        if(optEmployee.isPresent()) {
            return new ResponseEntity<>(optEmployee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Employee> findByLastname(String lastname) {
        Optional<Employee> optEmployee = employeeRepository.findByLastname(lastname);
        if(optEmployee.isPresent()) {
            return new ResponseEntity<>(optEmployee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }
}
