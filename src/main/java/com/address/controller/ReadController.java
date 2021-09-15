package com.address.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.address.dao.AddressDao;
import com.address.model.Address;


@Controller
public class ReadController {

    @Autowired
    private AddressDao addressDao;

    @RequestMapping(value = "/read",method = RequestMethod.GET)
    public String readAddress(Model model) throws IOException {

        List<Address> listAddress = addressDao.read();
        model.addAttribute("listAddress", listAddress);


        return "read";
    }
}
