package com.recettes.apirecettes.controller;

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
    public ResponseEntity<RecetteIngredient> getById(@PathVariable Long id){
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RecetteIngredient create(@RequestBody RecetteIngredient ri){
        return service.save(ri);
    }

    @PutMapping("/{id}")
    public RecetteIngredient update(@PathVariable Long id, @RequestBody RecetteIngredient ri){
        return service.update(id, ri);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
