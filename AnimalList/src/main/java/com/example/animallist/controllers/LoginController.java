package com.example.animallist.controllers;

import com.example.animallist.model.user.User;
import com.example.animallist.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    private int tryValue;

    private long firstTry;

    private static int enterUserid;

    public static int getEnterUserid() {
        return enterUserid;
    }

    public static void setEnterUserid(int enterUserid) {
        LoginController.enterUserid = enterUserid;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String checkPass(@ModelAttribute("user") @Valid User user,
                            BindingResult bindingResult, Model model) {

        if(isLastTry()) {
            bindingResult.addError(new FieldError("user", "password", "You have exceeded the maximum number of attempts"));
        }

        Integer id = userRepository.findIdByLogin(user.getLogin());

        if (id == null) {
            bindingResult.addError(new FieldError("user", "login", "The login is not already in use"));
        }


        if (bindingResult.hasErrors()) {
            return "login";
        }

        user.setId(id);

        if (userRepository.findPasswordByLogin(user.getLogin()).equals(user.getPassword())) {
            setEnterUserid(user.getId());
            model.addAttribute("user", user);
            tryValue = 0;
            firstTry = 0;
            return "redirect:/user";
        } else {
            tryValue++;
            if (tryValue == 1) {
                firstTry = System.currentTimeMillis();
            }
            bindingResult.addError(new FieldError("user", "password", "Unknown password"));
        }

        return "login";
    }

    private boolean isLastTry(){
        if (System.currentTimeMillis() - firstTry > 3600000) {
            tryValue = 0;
        }
        if (tryValue > 9) {
            return true;
        }
        return false;
    }


}
