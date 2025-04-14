package com.recettes.apirecettes.entity;

import jakarta.persistence.*;

@Entity
public class RecetteIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recette_id")
    private Recette recette;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private Double quantite;

    private String unite;

    //Constructeur par défaut
    public RecetteIngredient() {

    }

    // Constructeur avec tous les champs sauf l'id
    public RecetteIngredient(Recette recette, Ingredient ingredient, Double quantite, String unite) {
        this.recette = recette;
        this.ingredient = ingredient;
        this.quantite = quantite;
        this.unite = unite;
    }

    // Constructeur avec tous les champs
    public RecetteIngredient(Long id, Recette recette, Ingredient ingredient, Double quantite, String unite) {
        this.id = id;
        this.recette = recette;
        this.ingredient = ingredient;
        this.quantite = quantite;
        this.unite = unite;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

}

