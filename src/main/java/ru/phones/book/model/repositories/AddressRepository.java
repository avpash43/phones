package ru.phones.book.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.phones.book.model.entites.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
