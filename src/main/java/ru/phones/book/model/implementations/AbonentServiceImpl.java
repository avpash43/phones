package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Abonent;
import ru.phones.book.model.repositories.AbonentRepository;
import ru.phones.book.model.services.AbonentService;

import java.util.List;

@Service
public class AbonentServiceImpl implements AbonentService {

    @Autowired
    private AbonentRepository abonentRepository;

    @Override
    public List<Abonent> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Abonent> findById(Long employeeId) {
        return null;
    }

    @Override
    public Abonent addEmployee(Abonent employee) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }

    @Override
    public void updateEmployee(Abonent employee) {

    }
}
