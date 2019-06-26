package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Abonent;

import java.util.List;

public interface AbonentService {
    List<Abonent> findAll();
    ResponseEntity<Abonent> findById(Long employeeId);
    Abonent addEmployee(Abonent employee);
    void deleteEmployeeById(Long employeeId);
    void updateEmployee(Abonent employee);
}
