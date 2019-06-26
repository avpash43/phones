package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    ResponseEntity<Address> findById(Long employeeId);
    Address addEmployee(Address employee);
    void deleteEmployeeById(Long employeeId);
    void updateEmployee(Address employee);
}
