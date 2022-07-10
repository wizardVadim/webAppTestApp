package com.example.animallist.controllers;

import com.example.animallist.model.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/{id}")
    public String index(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalRepository.findById(id).get());
        return "show";
    }
}
