package com.recettes.apirecettes.controller;

import com.recettes.apirecettes.entity.Recette;
import com.recettes.apirecettes.service.RecetteService;

import com.recettes.apirecettes.dto.RecetteDetailDTO;

import com.recettes.apirecettes.dto.IngredientRecetteDTO;
import com.recettes.apirecettes.entity.RecetteIngredient;
import com.recettes.apirecettes.repository.RecetteIngredientRepository;

import com.recettes.apirecettes.dto.RecetteCreationDTO;
import com.recettes.apirecettes.dto.ApiReponseDTO;
import com.recettes.apirecettes.entity.*;
import com.recettes.apirecettes.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
@CrossOrigin



public class RecetteController {

    public final RecetteIngredientRepository recetteIngredientRepository;
    private final RecetteService service;
    private final CategorieRepository categorieRepository;
    private final IngredientRepository ingredientRepository;
    private final RecetteRepository recetteRepository;


    public RecetteController(
            RecetteService service,
            RecetteRepository recetteRepository,
            RecetteIngredientRepository recetteIngredientRepository,
            CategorieRepository categorieRepository,
            IngredientRepository ingredientRepository) {
        this.service = service;
        this.recetteRepository = recetteRepository;
        this.recetteIngredientRepository = recetteIngredientRepository;
        this.categorieRepository = categorieRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public List<Recette> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiReponseDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(recette -> ResponseEntity.ok(
                        new ApiReponseDTO(true, "recette trouvée !", recette)
                ))
                .orElse(ResponseEntity.status(400).body(
                        new ApiReponseDTO(false, "ingrédient non trouvée !", null)
                ));
    }

    @PostMapping
    public Recette create(@RequestBody Recette recette) {
        return service.save(recette);
    }

    @PutMapping("/{id}")
    public Recette update(@PathVariable Long id, @RequestBody Recette recette) {
        return service.update(id, recette);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/ingredients")
    public List<IngredientRecetteDTO> getIngredientsByRecette(@PathVariable Long id) {
        List<RecetteIngredient> liste = recetteIngredientRepository.findByRecetteId(id);
        return liste.stream()
                .map(ri -> new IngredientRecetteDTO(
                        ri.getIngredient().getNom(),
                        ri.getQuantite(),
                        ri.getUnite()
                )).toList();
    }

    @GetMapping("/search")
    public ResponseEntity<ApiReponseDTO> searchRecettes(
            @RequestParam(required = false) String categorie,
            @RequestParam(required = false) String ingredient
    ) {
        List<RecetteDetailDTO> results = service.searchRecettes(categorie, ingredient);

        if (results.isEmpty()) {
             return ResponseEntity.ok(
                     new ApiReponseDTO(false, "Aucune recette trouvée pour cette recherche !", null)
             );
        }

         return ResponseEntity.ok(
                 new ApiReponseDTO(true, "recettes trouvées avec succès", results)
         );

    }



    // Création d'une recette complète
    @PostMapping("/complete")
    public ResponseEntity<Recette> createComplete(@RequestBody RecetteCreationDTO dto) {

        // Vérifie la catégorie
        Categorie cat = categorieRepository.findById(dto.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));

        // Création de la recette
        Recette recette = new Recette();
        recette.setNom(dto.getNom());
        recette.setDescription(dto.getDescription());
        recette.setCategorie(cat);
        Recette savedRecette = recetteRepository.save(recette);

        //Lien avec les ingrédients
        for (RecetteCreationDTO.IngredientQuantiteDTO i : dto.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findById(i.getId())
                    .orElseThrow(() -> new RuntimeException("Ingrédient non trouvé"));

            RecetteIngredient ri = new RecetteIngredient();
            ri.setRecette(savedRecette);
            ri.setIngredient(ingredient);
            ri.setQuantite(i.getQuantite());
            ri.setUnite(i.getUnite());

            recetteIngredientRepository.save(ri);
        }
        return ResponseEntity.ok(savedRecette);
    }


}
