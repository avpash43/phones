package ru.phones.book.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.phones.book.model.entites.Address;
import ru.phones.book.service.AddressService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/address")
@Api(tags = "ddress")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response getAll() {
        return Response.builder()
                .data(List.of(
                        Map.of("response", addressService.findAll())
                ))
                .build();
    }

    @GetMapping(path = "/get/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response getById(@PathVariable(name="addressId")Long addressId) {
        return Response.builder()
                .data(List.of(
                        Map.of("response", addressService.findById(addressId))
                ))
                .build();
    }

    @PostMapping(path="/post", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @DeleteMapping("/delete/{addressId}")
    public void deleteAddressById(@PathVariable(name="addressId")Long addressId){
        addressService.deleteAddressById(addressId);
    }

    @PutMapping(path="/update/{addressId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAddress(@RequestBody Address address, @PathVariable(name="addressId")Long addressId) {
        Address emp = addressService.findById(addressId).getBody();
        if (emp != null && address.getId() != null) {
            addressService.updateAddress(address);
        }
    }
}
