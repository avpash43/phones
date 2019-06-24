package ru.phones.book.model.data;

import org.springframework.data.repository.CrudRepository;
import ru.phones.book.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
