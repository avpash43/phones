package ru.phones.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.PhoneNumbers;
import ru.phones.book.repository.PhoneNumbersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumbersService {

    @Autowired
    private PhoneNumbersRepository phoneNumbersRepository;

    public  List<PhoneNumbers> findAll() {
        return phoneNumbersRepository.findAll();
    }

    public ResponseEntity<PhoneNumbers> findById(Long phoneNumbersId) {
        Optional<PhoneNumbers> optPhoneNumbers = phoneNumbersRepository.findById(phoneNumbersId);
        if(optPhoneNumbers.isPresent()) {
            return new ResponseEntity<>(optPhoneNumbers.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public PhoneNumbers addPhoneNumbers(PhoneNumbers phoneNumbers) {
        return phoneNumbersRepository.saveAndFlush(phoneNumbers);
    }

    public void deletePhoneNumbersById(Long phoneNumbersId){
        phoneNumbersRepository.deleteById(phoneNumbersId);
    }

    public void updatePhoneNumbers(PhoneNumbers phoneNumbers) {
        phoneNumbersRepository.saveAndFlush(phoneNumbers);
    }
}
