package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Departament;

import java.util.List;

public interface DepartamentService {
    List<Departament> findAll();
    ResponseEntity<Departament> findById(Long employeeId);
    Departament addEmployee(Departament employee);
    void deleteEmployeeById(Long employeeId);
    void updateEmployee(Departament employee);
}
