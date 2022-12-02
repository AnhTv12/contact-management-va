package org.alicoder.spring.contactmanagement.controller;

import org.alicoder.spring.contactmanagement.model.Users;
import org.alicoder.spring.contactmanagement.payload.UserPayload;
import org.alicoder.spring.contactmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class UserController {

    @Autowired UserService service;

    @GetMapping(value = "/users")
    public ModelAndView listUser(ModelMap model) {
        List<Users> usersList = service.listUser();
        model.addAttribute("users", usersList);
        return new ModelAndView("pages/list_user", model);
    }
    @GetMapping(value = "/adduser")
    public ModelAndView addUser(ModelMap model) {
        UserPayload user = new UserPayload();
        model.addAttribute("user", user);
        return new ModelAndView("pages/adduser", model);
    }
    @PostMapping(value = "/adduser")
    public String addUser(ModelMap model, @ModelAttribute UserPayload payload) throws NoSuchAlgorithmException {
        service.save(payload);
        return "redirect:/users";
    }
    @GetMapping(value = "/edit-user")
    public ModelAndView editUser(ModelMap model, @RequestParam("id")int id) {
        Users user = service.findUserById(id);
        model.addAttribute("user", user);
        return new ModelAndView("pages/edituser", model);
    }
    @PostMapping(value = "/edit-user")
    public String editUser(ModelMap model, @ModelAttribute Users users) throws NoSuchAlgorithmException {
        service.editUser(users);
        return "redirect:/users";
    }
    @GetMapping(value = "/users/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") int id) {
        service.delete(id);
        return "redirect:/users";
    }

}
