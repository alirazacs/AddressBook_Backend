package com.address.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.address.dao.AddressDao;

@Controller
public class DeleteController {

    @Autowired
    private AddressDao addressDao;

    @RequestMapping(value = "/delete/{addressId}")
    public String deleteAddressById(Model model, @PathVariable("addressId") int addressId)
            throws IOException {

        int counter = addressDao.delete(addressId);

        if (counter > 0) {
//            model.addAttribute("msg", "Addresses record deleted against address id: " + addressId);
        } else {
//            model.addAttribute("msg", "Error- check the console log.");
        }



        return "redirect:/read";
    }

}