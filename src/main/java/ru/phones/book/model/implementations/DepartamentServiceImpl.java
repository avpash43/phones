package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Departament;
import ru.phones.book.model.entites.Departament;
import ru.phones.book.model.repositories.DepartamentRepository;
import ru.phones.book.model.services.DepartamentService;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentServiceImpl implements DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    @Override
    public  List<Departament> findAll() {
        List<Departament> departamentes = (List<Departament>) departamentRepository.findAll();
        return departamentes;
    }

    public ResponseEntity<Departament> findById(Long departamentId) {
        Optional<Departament> optDepartament = departamentRepository.findById(departamentId);
        if(optDepartament.isPresent()) {
            return new ResponseEntity<>(optDepartament.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public Departament addDepartament(Departament departament) {
        return departamentRepository.save(departament);
    }

    public void deleteDepartamentById(Long departamentId){
        departamentRepository.deleteById(departamentId);
    }

    public void updateDepartament(Departament departament) {
        departamentRepository.save(departament);
    }
}
