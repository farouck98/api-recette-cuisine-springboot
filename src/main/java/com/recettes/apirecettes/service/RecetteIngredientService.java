package com.recettes.apirecettes.service;

import com.recettes.apirecettes.entity.RecetteIngredient;

import java.util.List;
import java.util.Optional;

public interface RecetteIngredientService {
    List<RecetteIngredient> getAll();
    Optional<RecetteIngredient> getById(Long id);
    RecetteIngredient save(RecetteIngredient ri);
    RecetteIngredient update(Long id, RecetteIngredient ri);
    void delete(Long id);
}
