package ru.phones.book.model.data;

import org.springframework.data.repository.CrudRepository;
import ru.phones.book.model.Address;


public interface AddressRepository extends CrudRepository<Address, Long> {
}
