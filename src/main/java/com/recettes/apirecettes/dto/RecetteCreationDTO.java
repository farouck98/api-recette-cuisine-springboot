package com.recettes.apirecettes.dto;

import com.recettes.apirecettes.entity.RecetteIngredient;

import java.util.List;


public class RecetteCreationDTO {

    private String nom;
    private String description;
    private Long categorieId;
    private List<IngredientQuantiteDTO> ingredients;

    //Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public List<IngredientQuantiteDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientQuantiteDTO> ingredients) {
        this.ingredients = ingredients;
    }

    // Classe interne pour représenter un ingrédient avec sa quantité et unité
    public static class IngredientQuantiteDTO {
        private Long id;
        private double quantite;
        public String unite;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public double getQuantite() {
            return quantite;
        }

        public void setQuantite(double quantite) {
            this.quantite = quantite;
        }

        public String getUnite() {
            return unite;
        }

        public void setUnite(String unite) {
            this.unite = unite;
        }
    }


}
