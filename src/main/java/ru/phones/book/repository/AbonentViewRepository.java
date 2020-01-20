package ru.phones.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.phones.book.model.entites.AbonentView;

import java.util.Optional;


@Repository
public interface AbonentViewRepository extends JpaRepository<AbonentView, Long> {
    Optional<AbonentView> findByLastname(String lastname);
    Optional<AbonentView> findByLastnameAndFirstname(String lastname, String firstname);
}
