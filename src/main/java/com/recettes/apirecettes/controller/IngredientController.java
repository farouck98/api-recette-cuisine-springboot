package com.recettes.apirecettes.controller;

import com.recettes.apirecettes.entity.Ingredient;
import com.recettes.apirecettes.service.IngredientService;
import com.recettes.apirecettes.dto.ApiReponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@CrossOrigin
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ingredient> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiReponseDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ingredient -> ResponseEntity.ok(
                        new ApiReponseDTO(true, "Ingrédient trouvé !", ingredient)
                ))
                .orElse(ResponseEntity.status(404).body(
                        new ApiReponseDTO(false, "Ingrédient non trouvé", null)
                ));
    }

    @PostMapping
    public ResponseEntity<ApiReponseDTO> create(@RequestBody Ingredient ingredient) {
        Ingredient saved = service.save(ingredient);
        return ResponseEntity.status(201).body(
                new ApiReponseDTO(true, "Ingredient enregistré !", saved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiReponseDTO> update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        Ingredient updated = service.update(id, ingredient);
        return ResponseEntity.ok(
                new ApiReponseDTO(true, "Ingredient modifié avec succès", updated)

        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiReponseDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                new ApiReponseDTO(true, "Ingrédient supprimé avec succès", null)
        );
    }
}
