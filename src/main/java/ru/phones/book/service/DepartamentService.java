package ru.phones.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Departament;
import ru.phones.book.repository.DepartamentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    public  List<Departament> findAll() {
        return departamentRepository.findAll();
    }

    public ResponseEntity<Departament> findById(Long departamentId) {
        Optional<Departament> optDepartament = departamentRepository.findById(departamentId);
        if(optDepartament.isPresent()) {
            return new ResponseEntity<>(optDepartament.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public Departament addDepartament(Departament departament) {
        return departamentRepository.saveAndFlush(departament);
    }

    public void deleteDepartamentById(Long departamentId){
        departamentRepository.deleteById(departamentId);
    }

    public void updateDepartament(Departament departament) {
        departamentRepository.saveAndFlush(departament);
    }
}
