//package com.address.controller;
//
//import com.address.exception.AddressNotFoundException;
//import com.address.model.Address;
//import com.address.model.AddressErrorResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@org.springframework.web.bind.annotation.RestController
//
//
//@RequestMapping("/api")
//public class RestController {
//
//
//    private List<Address> addressList;
//
////    define postconstruct annotation: so that our addressList data only loaded once when this RestController bean is registered...
//
//    @PostConstruct
//    public void loadData() {
//        addressList = new ArrayList<>();
//        addressList.add(new Address("aliraza", "male"));
//        addressList.add(new Address("hassan", "male"));
//        addressList.add(new Address("jony", "male"));
//
//
//    }
//
//    //    get all the addresses
//    @GetMapping("/addresses")
//    public List<Address> addressList() {
//        return addressList;
//    }
//
//    //    get single address
//    @GetMapping("/address/{addressId}")
//    public Address getAddress(@PathVariable int addressId) {
////        lets hadnle the exception here if address id not found
//        if (addressId >= addressList.size() || addressId < 0) {
//            throw new AddressNotFoundException("Address id not found - " + addressId);
//        }
////        if everything is ok and address id is valid
////        then following code will return
//
//        return addressList.get(addressId);
//
//    }
//
//
//
//
//}
