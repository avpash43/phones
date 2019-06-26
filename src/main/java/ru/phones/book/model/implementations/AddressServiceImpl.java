package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Address;
import ru.phones.book.model.repositories.AddressRepository;
import ru.phones.book.model.services.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public  List<Address> findAll() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        return addresses;
    }

    public ResponseEntity<Address> findById(Long addressId) {
        Optional<Address> optAddresses = addressRepository.findById(addressId);
        if(optAddresses.isPresent()) {
            return new ResponseEntity<>(optAddresses.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddressById(Long addressId){
        addressRepository.deleteById(addressId);
    }

    public void updateAddress(Address address) {
        addressRepository.save(address);
    }
}
