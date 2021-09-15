package com.address.controller;


import com.address.dao.AddressDao;
import com.address.exception.AddressNotFoundException;
import com.address.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AddressRestController {

    @Autowired
    AddressDao addressDao;

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return addressDao.read();

    }

    @PostMapping("/addresses")
    public Address addAddress(@RequestBody Address address) {
        Address addressObj = null;
        if( addressDao.create(address)>0){
            addressObj = address;
        }
        return addressObj;
    }

    @PutMapping("/addresses/{addressId}")
    public Address updateAddress(@RequestBody Address address,@PathVariable int addressId) {
        Address addressObj = null;
        if( addressDao.update(address,addressId)>0){
            addressObj = address;
        }
        return addressObj;
    }
//
    @GetMapping(value = "/addresses/{addressId}")
    public Address findAddress(@PathVariable int addressId) {

        Address address = addressDao.findAddressById(addressId);
        if (address == null)
            throw new AddressNotFoundException("No address found for id - " + addressId);
        return address;
    }
//
    @DeleteMapping("/addresses/{addressId}")
    public List<Address>  deleteAddress(@PathVariable int addressId) {
       if(addressDao.delete(addressId) == 0)
            throw new AddressNotFoundException("No address found for id - " + addressId);
        return addressDao.read();

    }

}
