package com.maxcheung.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maxcheung.account.model.User;
import com.maxcheung.account.service.SecurityService;
import com.maxcheung.account.service.UserService;
import com.maxcheung.account.validator.UserPasswordValidator;
import com.maxcheung.account.validator.UserValidator;

@Controller
public class UserPasswordController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;


    @Autowired
    private UserPasswordValidator userPasswordValidator;


    
    @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
    public String changepassword(Model model) {
        model.addAttribute("userForm", new User());

        return "changepassword";
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public String changepassword(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	userPasswordValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "changepassword";
        }
        userService.updatePassword(userForm.getUsername(), userForm.getPassword());
        return "redirect:/welcome";
    }
    
}
