package ru.phones.book.model.data;

import org.springframework.data.repository.CrudRepository;
import ru.phones.book.model.Departament;

public interface DepartamentRepository extends CrudRepository<Departament, Long> {
}
