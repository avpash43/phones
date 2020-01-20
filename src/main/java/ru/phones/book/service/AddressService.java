package ru.phones.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Address;
import ru.phones.book.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public  List<Address> findAll() {
        return addressRepository.findAll();
    }

    public ResponseEntity<Address> findById(Long addressId) {
        Optional<Address> optAddresses = addressRepository.findById(addressId);
        if(optAddresses.isPresent()) {
            return new ResponseEntity<>(optAddresses.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public Address addAddress(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    public void deleteAddressById(Long addressId){
        addressRepository.deleteById(addressId);
    }

    public void updateAddress(Address address) {
        addressRepository.saveAndFlush(address);
    }
}
