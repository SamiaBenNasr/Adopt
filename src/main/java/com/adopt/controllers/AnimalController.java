package com.adopt.controllers;

import com.adopt.models.Animal;
import com.adopt.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/animaux")
    public String afficherAnimaux(Model model) {
        List<Animal> animaux = animalService.getAllAnimals();
        model.addAttribute("animaux", animaux);
        return "animaux";
    }


    @GetMapping("/animal/{id}")
    public String getAnimalById(@PathVariable("id") Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "animal"; // make sure you have animal.html
    }

    @GetMapping("/adopter/{id}")
    public String adopterAnimal(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "animal_adapt"; // à créer
    }


    @PostMapping("/animal/save")
    public String saveAnimal(@ModelAttribute Animal animal) {
        animalService.save(animal);
        return "redirect:/animaux";
    }

    @GetMapping("/animal/new")
    public String createAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal_form"; // make sure you have animal_form.html
    }
    // Soumettre le formulaire d'adoption et marquer l'animal comme adopté
    @PostMapping("/adopter/{id}")
    public String soumettreAdoption(@PathVariable Long id, @RequestParam String name, @RequestParam String email, @RequestParam String motivation, Model model) {
        // Récupérer l'animal
        Animal animal = animalService.getAnimalById(id);

        // Marquer l'animal comme adopté
        animal.setAdopted(true);
        animalService.saveAnimal(animal);

        // Passer les informations à la page de confirmation
        model.addAttribute("animal", animal);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("motivation", motivation);

        return "confirm_adapt"; // Page de confirmation
    }
}
