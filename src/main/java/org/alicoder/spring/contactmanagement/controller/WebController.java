package org.alicoder.spring.contactmanagement.controller;


import org.alicoder.spring.contactmanagement.payload.LoginPayload;
import org.alicoder.spring.contactmanagement.payload.UserPayload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping(value = "/")
    public ModelAndView home(ModelMap model) {
        return new ModelAndView("redirect:login", model);
    }

    @GetMapping(value = "/dashboard")
    public ModelAndView dashboard(ModelMap model) {
        return new ModelAndView("pages/dashboard", model);
    }

    @GetMapping(value = "/login")
    public ModelAndView login(ModelMap model) {
        LoginPayload user = new LoginPayload();
        model.addAttribute("loginForm", user);
        return new ModelAndView("pages/login", model);
    }

    @GetMapping(value = "/register")
    public ModelAndView register(ModelMap model) {
        UserPayload user = new UserPayload();
        model.addAttribute("userForm", user);
        return new ModelAndView("pages/register", model);
    }

}