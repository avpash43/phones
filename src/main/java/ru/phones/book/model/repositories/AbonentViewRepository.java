package ru.phones.book.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.phones.book.model.entites.AbonentView;
import ru.phones.book.model.entites.Employee;

import java.util.Optional;


@Repository
public interface AbonentViewRepository extends CrudRepository<AbonentView, Long> {
    Optional<AbonentView> findByLastname(String lastname);
    Optional<AbonentView> findByLastnameAndFirstname(String lastname, String firstname);
}
