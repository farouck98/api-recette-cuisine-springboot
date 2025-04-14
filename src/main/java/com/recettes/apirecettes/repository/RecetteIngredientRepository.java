package com.recettes.apirecettes.repository;

import com.recettes.apirecettes.entity.RecetteIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetteIngredientRepository extends JpaRepository<RecetteIngredient, Long> {
    Long id(Long id);

    List<RecetteIngredient> findByRecetteId(Long recetteId);
}
