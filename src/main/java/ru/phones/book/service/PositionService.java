package ru.phones.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Position;
import ru.phones.book.repository.PositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public  List<Position> findAll() {
        return positionRepository.findAll();
    }

    public ResponseEntity<Position> findById(Long positionId) {
        Optional<Position> optPosition = positionRepository.findById(positionId);
        if(optPosition.isPresent()) {
            return new ResponseEntity<>(optPosition.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public Position addPosition(Position position) {
        return positionRepository.saveAndFlush(position);
    }

    public void deletePositionById(Long positionId){
        positionRepository.deleteById(positionId);
    }

    public void updatePosition(Position position) {
        positionRepository.saveAndFlush(position);
    }
}
