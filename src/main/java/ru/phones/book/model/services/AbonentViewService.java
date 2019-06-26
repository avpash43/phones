package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.AbonentView;

import java.util.List;

public interface AbonentViewService {
    List<AbonentView> findAll();
    ResponseEntity<AbonentView> findById(Long abonentViewId);
}
