package ru.phones.book.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.phones.book.model.entites.PhoneNumbers;

@Repository
public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbers, Long> {
}
