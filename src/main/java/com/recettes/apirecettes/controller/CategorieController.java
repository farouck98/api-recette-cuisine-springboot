package com.recettes.apirecettes.controller;

import com.recettes.apirecettes.dto.ApiReponseDTO;
import com.recettes.apirecettes.entity.Categorie;
import com.recettes.apirecettes.service.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin


public class CategorieController {

    private final CategorieService service;

    public CategorieController(CategorieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categorie> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiReponseDTO> create(@RequestBody Categorie categorie) {
        Categorie saved = service.save(categorie);
        return ResponseEntity.status(201).body(
                new ApiReponseDTO(true, "Categorie enregistrée avec succès", saved)
        );
    }

    @PutMapping("/{id}")
    public Categorie update(@PathVariable Long id, @RequestBody Categorie categorie) {
        return service.update(id, categorie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
