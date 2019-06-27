package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Position;
import ru.phones.book.model.repositories.PositionRepository;
import ru.phones.book.model.services.PositionService;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public  List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public ResponseEntity<Position> findById(Long positionId) {
        Optional<Position> optPosition = positionRepository.findById(positionId);
        if(optPosition.isPresent()) {
            return new ResponseEntity<>(optPosition.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public Position addPosition(Position position) {
        return positionRepository.saveAndFlush(position);
    }

    @Override
    public void deletePositionById(Long positionId){
        positionRepository.deleteById(positionId);
    }

    @Override
    public void updatePosition(Position position) {
        positionRepository.saveAndFlush(position);
    }
}
