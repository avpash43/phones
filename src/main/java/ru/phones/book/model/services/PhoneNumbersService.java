package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.PhoneNumbers;

import java.util.List;

public interface PhoneNumbersService {
    List<PhoneNumbers> findAll();
    ResponseEntity<PhoneNumbers> findById(Long employeeId);
    PhoneNumbers addEmployee(PhoneNumbers employee);
    void deleteEmployeeById(Long employeeId);
    void updateEmployee(PhoneNumbers employee);
}
