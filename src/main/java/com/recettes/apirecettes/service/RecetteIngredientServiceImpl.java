package com.recettes.apirecettes.service;

import com.recettes.apirecettes.entity.RecetteIngredient;
import com.recettes.apirecettes.repository.RecetteIngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetteIngredientServiceImpl implements RecetteIngredientService {

    private final RecetteIngredientRepository repository;

    public RecetteIngredientServiceImpl(RecetteIngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RecetteIngredient> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<RecetteIngredient> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public RecetteIngredient save(RecetteIngredient ri) {
        return repository.save(ri);
    }

    @Override
    public RecetteIngredient update(Long id, RecetteIngredient ri) {
        RecetteIngredient existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Association non trouvée"));
        existing.setRecette(ri.getRecette());
        existing.setIngredient(ri.getIngredient());
        existing.setQuantite(ri.getQuantite());
        existing.setUnite(ri.getUnite());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }


}
