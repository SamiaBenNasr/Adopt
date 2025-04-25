package com.adopt.repository;

import java.util.List;

import com.adopt.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findBySpeciesIgnoreCase(String species);  // Recherche insensible à la casse
}
