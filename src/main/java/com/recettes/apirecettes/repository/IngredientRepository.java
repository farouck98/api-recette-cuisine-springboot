package com.recettes.apirecettes.repository;

import com.recettes.apirecettes.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
