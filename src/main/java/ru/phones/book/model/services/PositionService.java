package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    ResponseEntity<Position> findById(Long eositionId);
    Position addPosition(Position eosition);
    void deletePositionById(Long eositionId);
    void updatePosition(Position eosition);
}
