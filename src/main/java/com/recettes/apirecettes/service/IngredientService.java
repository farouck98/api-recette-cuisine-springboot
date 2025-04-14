package com.recettes.apirecettes.service;

import com.recettes.apirecettes.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    List<Ingredient> getAll();
    Optional<Ingredient> getById(Long id);
    Ingredient save(Ingredient ingredient);
    Ingredient update(Long id, Ingredient updated);
    void delete(Long id);
}
