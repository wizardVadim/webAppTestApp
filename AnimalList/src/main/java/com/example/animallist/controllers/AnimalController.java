package com.example.animallist.controllers;

import com.example.animallist.model.animal.Animal;
import com.example.animallist.model.animal.AnimalRepository;
import com.example.animallist.model.link.LinkedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private LinkedRepository linkedRepository;

    @DeleteMapping
    public String removeAll(){
        linkedRepository.deleteAll();
        animalRepository.deleteAll();
        return "index";
    }

    @GetMapping("/{id}")
    public String index(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalRepository.findById(id).get());
        return "show";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id, @ModelAttribute("animal") Animal animal) {
        animalRepository.deleteById(id);
        linkedRepository.deleteById(linkedRepository.findByAnimalId(id));
        return "index";
    }
}
