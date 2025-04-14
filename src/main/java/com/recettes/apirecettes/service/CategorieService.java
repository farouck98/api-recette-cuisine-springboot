package com.recettes.apirecettes.service;

import com.recettes.apirecettes.entity.Categorie;

import java.util.List;
import java.util.Optional;


public interface CategorieService {
    List<Categorie> getAll();
    Optional<Categorie> getById(Long id);
    Categorie save(Categorie categorie);
    Categorie update(Long id, Categorie updated);
    void delete(Long id);
}
