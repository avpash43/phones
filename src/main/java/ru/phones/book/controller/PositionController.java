package ru.phones.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.Position;
import ru.phones.book.service.PositionService;

import java.util.List;

@RestController
@RequestMapping(path="/v1/api/position", produces="application/json")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/get")
    public List<Position> getAll() {
        return positionService.findAll();
    }

    @GetMapping("/get/{positionId}")
    public ResponseEntity<Position> getById(@PathVariable(name="positionId")Long positionId) {
        return positionService.findById(positionId);
    }

    @PostMapping(path="/post", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Position addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @DeleteMapping("/delete/{positionId}")
    public void deletePositionById(@PathVariable(name="positionId")Long positionId){
        positionService.deletePositionById(positionId);
    }

    @PutMapping(path="/update/{positionId}", consumes="application/json")
    public void updatePosition(@RequestBody Position position, @PathVariable(name="positionId")Long positionId) {
        Position emp = positionService.findById(positionId).getBody();
        if (emp != null && position.getId() != null) {
            positionService.updatePosition(position);
        }
    }
}
