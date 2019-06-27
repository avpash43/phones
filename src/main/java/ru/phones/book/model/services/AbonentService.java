package ru.phones.book.model.services;

import ru.phones.book.model.entites.Abonent;
import ru.phones.book.model.entites.AbonentView;


public interface AbonentService {
    Abonent findById(Long abonentId);
    AbonentView addAbonent(Abonent abonent);
    void deleteAbonentById(Long abonentId);
    void updateAbonent(Abonent abonent);
}
