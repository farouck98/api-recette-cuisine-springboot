package com.recettes.apirecettes.dto;

public class IngredientRecetteDTO {

    private String ingredient;
    private double quantite;
    private String unite;

    // Constructeur avec tous les champs
    public IngredientRecetteDTO (String ingredient, double quantite, String unite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
        this.unite = unite;
    }

    // Getter et Setter pour ingredient
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    // Getter et Setter pour quantite
    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    // Getter et Setter pour unite
    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

}
