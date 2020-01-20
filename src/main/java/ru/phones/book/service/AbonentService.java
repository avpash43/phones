package ru.phones.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Abonent;
import ru.phones.book.model.entites.AbonentView;
import ru.phones.book.repository.AbonentRepository;
import ru.phones.book.repository.AbonentViewRepository;

@Service
public class AbonentService {

    AbonentRepository abonentRepository;
    AbonentViewRepository abonentViewRepository;

    @Autowired
    public AbonentService(AbonentRepository abonentRepository, AbonentViewRepository abonentViewRepository) {
        this.abonentRepository = abonentRepository;
        this.abonentViewRepository = abonentViewRepository;
    }

    public Abonent findById(Long abonentId) {
        return abonentRepository.findById(abonentId).orElse(new Abonent());
    }

    public AbonentView addAbonent(Abonent abonent) {
        Long savedAbonent = abonentRepository.saveAndFlush(abonent).getId();
        return abonentViewRepository.findById(savedAbonent).orElse(new AbonentView());
    }

    public void deleteAbonentById(Long abonentId) {
        abonentRepository.deleteById(abonentId);
    }

    public void updateAbonent(Abonent abonent) {
        abonentRepository.saveAndFlush(abonent);
    }
}
