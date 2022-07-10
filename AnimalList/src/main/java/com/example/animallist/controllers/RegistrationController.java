package com.example.animallist.controllers;

import com.example.animallist.model.user.User;
import com.example.animallist.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String regForm(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult, Model model) {

        for(User user1 : userRepository.findAll()) {
            if(user.getLogin().equals(user1.getLogin())) {
                bindingResult.addError(new FieldError("user", "login", "The login is already in use"));
            }
        }

        if (bindingResult.hasErrors()) {
            return "reg";
        }

        userRepository.save(user);
        LoginController.setEnterUserid(userRepository.findIdByLogin(user.getLogin()));
        model.addAttribute("user", user);
        return "redirect:/user";
    }
}
