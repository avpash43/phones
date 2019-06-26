package ru.phones.book.model.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.phones.book.model.entites.PhoneNumbers;
import ru.phones.book.model.entites.PhoneNumbers;
import ru.phones.book.model.repositories.PhoneNumbersRepository;
import ru.phones.book.model.services.PhoneNumbersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumbersServiceImpl implements PhoneNumbersService {

    @Autowired
    private PhoneNumbersRepository phoneNumbersRepository;

    @Override
    public  List<PhoneNumbers> findAll() {
        List<PhoneNumbers> phoneNumberses = new ArrayList<>();
        phoneNumbersRepository.findAll().forEach(phone -> phoneNumberses.add(phone));
        return phoneNumberses;
    }

    public ResponseEntity<PhoneNumbers> findById(Long phoneNumbersId) {
        Optional<PhoneNumbers> optPhoneNumbers = phoneNumbersRepository.findById(phoneNumbersId);
        if(optPhoneNumbers.isPresent()) {
            return new ResponseEntity<>(optPhoneNumbers.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public PhoneNumbers addPhoneNumbers(PhoneNumbers phoneNumbers) {
        return phoneNumbersRepository.save(phoneNumbers);
    }

    public void deletePhoneNumbersById(Long phoneNumbersId){
        phoneNumbersRepository.deleteById(phoneNumbersId);
    }

    public void updatePhoneNumbers(PhoneNumbers phoneNumbers) {
        phoneNumbersRepository.save(phoneNumbers);
    }
}
