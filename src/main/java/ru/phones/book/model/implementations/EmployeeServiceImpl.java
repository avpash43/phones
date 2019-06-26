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
        List<Employee> epmloyees = (List<Employee>) employeeRepository.findAll();
        return epmloyees;
    }

    public ResponseEntity<Employee> findById(Long employeeId) {
        Optional<Employee> optEmployee = employeeRepository.findById(employeeId);
        if(optEmployee.isPresent()) {
            return new ResponseEntity<>(optEmployee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
