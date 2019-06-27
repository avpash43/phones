package ru.phones.book.model.services;

import ru.phones.book.model.entites.Abonent;
import ru.phones.book.model.entites.AbonentView;


public interface AbonentService {
    AbonentView addAbonent(AbonentView abonent);
    void deleteAbonentById(Long abonentId);
    void updateAbonent(Abonent abonent);
}
