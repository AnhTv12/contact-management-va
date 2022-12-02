package org.alicoder.spring.contactmanagement.controller;

import org.alicoder.spring.contactmanagement.model.Users;
import org.alicoder.spring.contactmanagement.payload.LoginPayload;
import org.alicoder.spring.contactmanagement.payload.UserPayload;
import org.alicoder.spring.contactmanagement.service.AuthenticationService;
import org.alicoder.spring.contactmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.NoSuchAlgorithmException;

@Controller
public class AuthenticationController {

    @Autowired UserService service;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/register")
    public ModelAndView register(@ModelAttribute("userForm") UserPayload payload,
                                 BindingResult bindingResult, ModelMap model) throws NoSuchAlgorithmException {
        service.save(payload);
        return new ModelAndView("redirect:login", model);
    }

    @PostMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("loginForm") LoginPayload payload,
                                 BindingResult bindingResult, ModelMap model) throws NoSuchAlgorithmException {
        boolean authenticated = authenticationService.login(payload);
        if (authenticated)
            return new ModelAndView("redirect:dashboard", model);
        return new ModelAndView("redirect:login", model);
    }
}
