package ru.phones.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.Address;
import ru.phones.book.service.AddressService;

import java.util.List;

@RestController
@RequestMapping(path="/v1/api/address", produces="application/json")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/get")
    public List<Address> getAll() {
        return addressService.findAll();
    }

    @GetMapping("/get/{addressId}")
    public ResponseEntity<Address> getById(@PathVariable(name="addressId")Long addressId) {
        return addressService.findById(addressId);
    }

    @PostMapping(path="/post", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @DeleteMapping("/delete/{addressId}")
    public void deleteAddressById(@PathVariable(name="addressId")Long addressId){
        addressService.deleteAddressById(addressId);
    }

    @PutMapping(path="/update/{addressId}", consumes="application/json")
    public void updateAddress(@RequestBody Address address, @PathVariable(name="addressId")Long addressId) {
        Address emp = addressService.findById(addressId).getBody();
        if (emp != null && address.getId() != null) {
            addressService.updateAddress(address);
        }
    }
}
