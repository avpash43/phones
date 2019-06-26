package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Abonent;

import java.util.List;

public interface AbonentService {
    List<Abonent> findAll();
    ResponseEntity<Abonent> findById(Long abonentId);
    Abonent addAbonent(Abonent abonent);
    void deleteAbonentById(Long abonentId);
    void updateAbonent(Abonent abonent);
}
