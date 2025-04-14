package com.recettes.apirecettes.service;

import com.recettes.apirecettes.entity.Ingredient;
import com.recettes.apirecettes.repository.IngredientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Optional<Ingredient> getById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient update(Long id, Ingredient updated) {
        Ingredient existing = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient non trouvé"));
        existing.setNom(updated.getNom());
        return ingredientRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }
}
