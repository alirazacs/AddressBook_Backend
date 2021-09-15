package com.address.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.address.dao.AddressDao;
import com.address.model.Address;

@Controller
public class UpdateController {

//    using autowired we are doing field injection...
    
    @Autowired
    private AddressDao addressDao;

    @RequestMapping(value = "/update/{addressId}")
    public String findAddressById(Model model, @PathVariable("addressId") int addressId)
            throws IOException {

        Address listAddress = addressDao.findAddressById(addressId);
        model.addAttribute("address", listAddress);

        return "create";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updateAddress(@ModelAttribute("address") Address addressObj, Model model) {
//
//        Address address = new Address();
//        address.setId(addressObj.getId());
//        address.setName(addressObj.getName());
//        address.setEmail(addressObj.getEmail());
//        address.setGender(addressObj.getGender());
//        address.setCity(addressObj.getCity());
//        int counter = addressDao.update(address);
//
//        if (counter > 0) {
//            model.addAttribute("msg", "Address records updated against adddress id: " + address.getId());
//        } else {
//            model.addAttribute("msg", "Error- check the console log.");
//        }
//
//
//        return "read";
//
//    }
}