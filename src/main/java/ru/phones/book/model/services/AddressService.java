package ru.phones.book.model.services;

import org.springframework.http.ResponseEntity;
import ru.phones.book.model.entites.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    ResponseEntity<Address> findById(Long addressId);
    Address addAddress(Address address);
    void deleteAddressById(Long addressId);
    void updateAddress(Address address);
}
