package com.recettes.apirecettes.controller;

import com.recettes.apirecettes.dto.ApiReponseDTO;
import com.recettes.apirecettes.entity.RecetteIngredient;
import com.recettes.apirecettes.service.RecetteIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recette-ingredients")
@CrossOrigin
public class RecetteIngredientController {

    private final RecetteIngredientService service;

    public RecetteIngredientController(RecetteIngredientService service) {
        this.service = service;
    }

    @GetMapping
    public List<RecetteIngredient> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiReponseDTO> getById(@PathVariable Long id){
        return service.getById(id)
                .map(RecetteIngredient -> ResponseEntity.ok(
                        new ApiReponseDTO(true, "Recette trouvée", RecetteIngredient)
                ))
                .orElse(ResponseEntity.status(404).body(
                        new ApiReponseDTO(false, "Recette non trouvée", null)
                ));
    }

    @PostMapping
    public ResponseEntity<ApiReponseDTO> create(@RequestBody RecetteIngredient ri){
        RecetteIngredient saved = service.save(ri);
        return ResponseEntity.status(201).body(
                new ApiReponseDTO(true, " recette (avec ses ingrédients et quantités) ajoutée", saved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiReponseDTO> update(@PathVariable Long id, @RequestBody RecetteIngredient ri){
        RecetteIngredient updated = service.update(id, ri);
        return ResponseEntity.status(201).body(
               new ApiReponseDTO(true, "recette modifiée avec succès", updated)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiReponseDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok(
                new ApiReponseDTO(true, "recette supprimée avec succès", null)
        );
    }
}
