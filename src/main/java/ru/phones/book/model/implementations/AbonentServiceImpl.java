package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Abonent;
import ru.phones.book.model.repositories.AbonentRepository;
import ru.phones.book.model.services.AbonentService;


@Service
public class AbonentServiceImpl implements AbonentService {

    @Autowired
    private AbonentRepository abonentRepository;

    @Override
    public Abonent addAbonent(Abonent abonent) {
        return null;
    }

    @Override
    public void deleteAbonentById(Long abonentId) {

    }

    @Override
    public void updateAbonent(Abonent abonent) {

    }
}
