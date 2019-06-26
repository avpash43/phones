package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Departament;

import java.util.List;

public interface DepartamentService {
    List<Departament> findAll();
    ResponseEntity<Departament> findById(Long departamentId);
    Departament addDepartament(Departament departament);
    void deleteDepartamentById(Long departamentId);
    void updateDepartament(Departament departament);
}
