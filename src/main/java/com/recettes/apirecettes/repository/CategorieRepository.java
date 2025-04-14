package com.recettes.apirecettes.repository;

import com.recettes.apirecettes.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
}
