package ru.phones.book.model.data;

import org.springframework.data.repository.CrudRepository;
import ru.phones.book.model.PhoneNumbers;

public interface PhoneNumbersRepository extends CrudRepository<PhoneNumbers, Long> {
}
