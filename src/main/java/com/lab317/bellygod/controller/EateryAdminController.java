package com.lab317.bellygod.controller;

import com.lab317.bellygod.model.Eatery;
import com.lab317.bellygod.model.EateryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * For Backend Management Eatery
 *
 * Created by balicanta on 1/25/15.
 */

@Controller
@RequestMapping("/admin/eatery")
public class EateryAdminController {

    @Autowired EateryRepository eateryRepository;

    @RequestMapping(value="/new", method= RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("eatery", new Eatery());
        return "/admin/eatery/new";
    }

    @RequestMapping(value="/new", method= RequestMethod.POST)
    public String createSubmit(@ModelAttribute Eatery newEatery, Model model) {
        eateryRepository.save(newEatery);
        return "/admin/eatery/new";
    }
}
