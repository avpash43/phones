package ru.phones.book.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.phones.book.model.Abonent;

@Repository
public interface AbonentRepository extends CrudRepository<Abonent, Long> {

}
