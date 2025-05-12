package com.adopt.controllers;

import com.adopt.models.Animal;
import com.adopt.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping({"/", "/animaux"})
    public String afficherAnimaux(Model model) {
        model.addAttribute("animaux", animalService.getAllAnimals());
        return "animaux";
    }

    @GetMapping("/animal/{id}")
    public String getAnimalById(@PathVariable Long id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "animal";
    }

    // ← Spring Security will intercept unauthenticated users and redirect to /login
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/adopter/{id}")
    public String adopterAnimal(@PathVariable Long id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "animal_adapt";
    }

    @PostMapping("/animal/save")
    public String saveAnimal(@ModelAttribute Animal animal) {
        animalService.save(animal);
        return "redirect:/animaux";
    }

    @GetMapping("/animal/new")
    public String createAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/adopter/{id}")
    public String soumettreAdoption(@PathVariable Long id,
                                    @RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String motivation,
                                    Model model) {
        Animal a = animalService.getAnimalById(id);
        a.setAdopted(true);
        animalService.saveAnimal(a);

        model.addAttribute("animal", a);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("motivation", motivation);
        return "confirm_adapt";
    }
}
