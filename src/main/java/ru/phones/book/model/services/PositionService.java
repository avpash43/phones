package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    ResponseEntity<Position> findById(Long employeeId);
    Position addEmployee(Position employee);
    void deleteEmployeeById(Long employeeId);
    void updateEmployee(Position employee);
}
