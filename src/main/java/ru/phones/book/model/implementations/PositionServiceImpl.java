package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Position;
import ru.phones.book.model.repositories.PositionRepository;
import ru.phones.book.model.services.PositionService;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Position> findById(Long employeeId) {
        return null;
    }

    @Override
    public Position addEmployee(Position employee) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }

    @Override
    public void updateEmployee(Position employee) {

    }
}
