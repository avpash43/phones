package ru.phones.book.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.phones.book.model.entites.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
}
