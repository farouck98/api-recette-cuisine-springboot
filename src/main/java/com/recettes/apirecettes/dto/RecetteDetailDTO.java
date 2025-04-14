package com.recettes.apirecettes.dto;

import java.util.List;

public class RecetteDetailDTO {

    private Long id;
    private String nom;
    private String description;
    private String categorie;
    private List<IngredientDTO> ingredients;

    // Constructeur
    public RecetteDetailDTO(Long id, String nom, String description, String categorie, List<IngredientDTO> ingredients) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.ingredients = ingredients;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients; //
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    // Classe interne
    public static class IngredientDTO {
        private String nom;
        private double quantite;
        private String unite;

        public IngredientDTO(String nom, double quantite, String unite) {
            this.nom = nom;
            this.quantite = quantite;
            this.unite = unite;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
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
