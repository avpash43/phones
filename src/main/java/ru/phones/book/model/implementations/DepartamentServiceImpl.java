package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Departament;
import ru.phones.book.model.repositories.DepartamentRepository;
import ru.phones.book.model.services.DepartamentService;

import java.util.List;

@Service
public class DepartamentServiceImpl implements DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    @Override
    public List<Departament> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Departament> findById(Long employeeId) {
        return null;
    }

    @Override
    public Departament addEmployee(Departament employee) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }

    @Override
    public void updateEmployee(Departament employee) {

    }
}
