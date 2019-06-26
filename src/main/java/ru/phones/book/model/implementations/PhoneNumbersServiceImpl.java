package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.PhoneNumbers;
import ru.phones.book.model.repositories.PhoneNumbersRepository;
import ru.phones.book.model.services.PhoneNumbersService;

import java.util.List;

@Service
public class PhoneNumbersServiceImpl implements PhoneNumbersService {

    @Autowired
    private PhoneNumbersRepository phoneNumbersRepository;

    @Override
    public List<PhoneNumbers> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<PhoneNumbers> findById(Long employeeId) {
        return null;
    }

    @Override
    public PhoneNumbers addEmployee(PhoneNumbers employee) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }

    @Override
    public void updateEmployee(PhoneNumbers employee) {

    }
}
