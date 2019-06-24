package ru.phones.book.model.data;

import org.springframework.data.repository.CrudRepository;
import ru.phones.book.model.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {
}
