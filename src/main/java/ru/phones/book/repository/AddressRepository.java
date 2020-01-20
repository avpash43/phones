package ru.phones.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.phones.book.model.entites.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
