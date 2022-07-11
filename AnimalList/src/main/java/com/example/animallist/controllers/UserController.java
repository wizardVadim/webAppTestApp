package com.example.animallist.controllers;

import com.example.animallist.model.animal.Animal;
import com.example.animallist.model.animal.AnimalRepository;
import com.example.animallist.model.link.Link;
import com.example.animallist.model.link.LinkedRepository;
import com.example.animallist.model.user.User;
import com.example.animallist.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private LinkedRepository linkedRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", userRepository.findById(LoginController.getEnterUserid()).get());
        List<Integer> animalIdList = animalRepository.getAllIdByUserId(LoginController.getEnterUserid());
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        animalIdList.forEach(a -> animalArrayList.add(animalRepository.findById(a).get()));
        model.addAttribute("animals", animalArrayList);
        return "userPage";
    }

    @GetMapping("/addAnimal")
    public String addAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "new";
    }

    @PostMapping("/addAnimal")
    public String createAnimal(@ModelAttribute("animal") @Valid Animal animal,
                               BindingResult bindingResult, Model model) {

        for(Animal animal1 : animalRepository.findAll()) {
            if(animal1.getName().equals(animal.getName())) {
                bindingResult.addError(new FieldError("animal", "name", "This name is already in use"));
            }
        }

        if (bindingResult.hasErrors()) {
            return "new";
        }

        animal.setType(animalRepository.getType(animal.getTypeId()));

        animalRepository.save(animal);
        Link link = new Link();
        link.setAnimalId(animal.getId());
        link.setUserId(LoginController.getEnterUserid());
        linkedRepository.save(link);
        model.addAttribute("user", userRepository.findById(LoginController.getEnterUserid()));
        return "redirect:/user";
    }

}
