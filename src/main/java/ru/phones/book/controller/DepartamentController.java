package ru.phones.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.Departament;
import ru.phones.book.service.DepartamentService;

import java.util.List;

@RestController
@RequestMapping(path="/v1/api/departament", produces="application/json")
public class DepartamentController {
    private final DepartamentService departamentService;

    @Autowired
    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping("/get")
    public List<Departament> getAll() {
        return departamentService.findAll();
    }

    @GetMapping("/get/{departamentId}")
    public ResponseEntity<Departament> getById(@PathVariable(name="departamentId")Long departamentId) {
        return departamentService.findById(departamentId);
    }

    @PostMapping(path="/post", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Departament addDepartament(@RequestBody Departament departament) {
        return departamentService.addDepartament(departament);
    }

    @DeleteMapping("/delete/{departamentId}")
    public void deleteDepartamentById(@PathVariable(name="departamentId")Long departamentId){
        departamentService.deleteDepartamentById(departamentId);
    }

    @PutMapping(path="/update/{departamentId}", consumes="application/json")
    public void updateDepartament(@RequestBody Departament departament, @PathVariable(name="departamentId")Long departamentId) {
        Departament emp = departamentService.findById(departamentId).getBody();
        if (emp != null && departament.getId() != null) {
            departamentService.updateDepartament(departament);
        }
    }
}
