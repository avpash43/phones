package ru.phones.book.model.services;

import ru.phones.book.model.entites.Abonent;


public interface AbonentService {
    Abonent addAbonent(Abonent abonent);
    void deleteAbonentById(Long abonentId);
    void updateAbonent(Abonent abonent);
}
