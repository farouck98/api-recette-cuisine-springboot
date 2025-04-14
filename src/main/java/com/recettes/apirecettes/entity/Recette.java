package com.recettes.apirecettes.entity;

import jakarta.persistence.*;

@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // Constructeur par défaut
    public Recette() {

    }

    // Constructeur avec les champs sauf l'id (généré automatiquement)
    public Recette(String nom, String description, Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
    }

    //Constructeur avec tous les champs
    public Recette(Long id, String nom, String description, Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
    }

    // Getters et Setters
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
