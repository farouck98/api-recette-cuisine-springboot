package com.recettes.apirecettes.entity;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    // Constructeur par défaut
    public Ingredient() {

    }

    public Ingredient(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    // Setter pour id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }
}
