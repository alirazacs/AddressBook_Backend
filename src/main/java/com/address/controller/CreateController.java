package com.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.address.dao.AddressDao;
import com.address.model.Address;

@Controller
public class CreateController {

    @Autowired
    private AddressDao addressDao;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAddress(@ModelAttribute("address") Address addressObj, Model model) {
        int counter = -1;
        Address address = new Address();
        address.setName(addressObj.getName());
        address.setEmail(addressObj.getEmail());
        address.setGender(addressObj.getGender());
        address.setCity(addressObj.getCity());

        if (addressObj.getId() > 0) {
            counter = addressDao.update(address,addressObj.getId());

        } else {
            counter = addressDao.create(address);

        }

        if (counter > 0) {
            //successsful
        } else {
//            model.addAttribute("msg", "Error- check the console log.");
        }

        return "redirect:read";
    }

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(Model model) {
        Address address = new Address();
        model.addAttribute("address", address);
        return "create";

    }
}