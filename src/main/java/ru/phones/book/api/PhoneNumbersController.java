package ru.phones.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.PhoneNumbers;
import ru.phones.book.model.services.PhoneNumbersService;

import java.util.List;

@RestController
@RequestMapping(path="/api/phonenumber", produces="application/json")
public class PhoneNumbersController {
    private final PhoneNumbersService phoneNumbersService;

    @Autowired
    public PhoneNumbersController(PhoneNumbersService phoneNumbersService) {
        this.phoneNumbersService = phoneNumbersService;
    }

    @GetMapping("/get")
    public List<PhoneNumbers> getAll() {
        return phoneNumbersService.findAll();
    }

    @GetMapping("/get/{phoneNumbersId}")
    public ResponseEntity<PhoneNumbers> getById(@PathVariable(name="phoneNumbersId")Long phoneNumbersId) {
        return phoneNumbersService.findById(phoneNumbersId);
    }

    @PostMapping(path="/post", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneNumbers addPhoneNumbers(@RequestBody PhoneNumbers phoneNumbers) {
        return phoneNumbersService.addPhoneNumbers(phoneNumbers);
    }

    @DeleteMapping("/delete/{phoneNumbersId}")
    public void deletePhoneNumbersById(@PathVariable(name="phoneNumbersId")Long phoneNumbersId){
        phoneNumbersService.deletePhoneNumbersById(phoneNumbersId);
    }

    @PutMapping(path="/update/{phoneNumbersId}", consumes="application/json")
    public void updatePhoneNumbers(@RequestBody PhoneNumbers phoneNumbers, @PathVariable(name="phoneNumbersId")Long phoneNumbersId) {
        PhoneNumbers emp = phoneNumbersService.findById(phoneNumbersId).getBody();
        if (emp != null && phoneNumbers.getId() != null) {
            phoneNumbersService.updatePhoneNumbers(phoneNumbers);
        }
    }
}
