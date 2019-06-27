package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.*;
import ru.phones.book.model.repositories.AbonentRepository;
import ru.phones.book.model.repositories.AbonentViewRepository;
import ru.phones.book.model.services.AbonentService;

@Service
public class AbonentServiceImpl implements AbonentService {

    AbonentRepository abonentRepository;
    AbonentViewRepository abonentViewRepository;

    @Autowired
    public AbonentServiceImpl(AbonentRepository abonentRepository, AbonentViewRepository abonentViewRepository) {
        this.abonentRepository = abonentRepository;
        this.abonentViewRepository = abonentViewRepository;
    }

    @Override
    public Abonent findById(Long abonentId) {
        return abonentRepository.findById(abonentId).orElse(new Abonent());
    }

    @Override
    public AbonentView addAbonent(Abonent abonent) {
        Long savedAbonent = abonentRepository.saveAndFlush(abonent).getId();
        return abonentViewRepository.findById(savedAbonent).orElse(new AbonentView());
    }

    @Override
    public void deleteAbonentById(Long abonentId) {
        abonentRepository.deleteById(abonentId);
    }

    @Override
    public void updateAbonent(Abonent abonent) {
        abonentRepository.saveAndFlush(abonent);
    }
}
