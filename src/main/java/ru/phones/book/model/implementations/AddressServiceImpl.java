package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.Address;
import ru.phones.book.model.repositories.AddressRepository;
import ru.phones.book.model.services.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Address> findById(Long employeeId) {
        return null;
    }

    @Override
    public Address addEmployee(Address employee) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }

    @Override
    public void updateEmployee(Address employee) {

    }
}
