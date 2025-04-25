package com.adopt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adopt.models.Animal;
import com.adopt.repository.AnimalRepository;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public void save(Animal animal) {
        animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> findBySpecies(String species) {
        return animalRepository.findBySpeciesIgnoreCase(species);  // Recherche insensible à la casse
    }

    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }
}
