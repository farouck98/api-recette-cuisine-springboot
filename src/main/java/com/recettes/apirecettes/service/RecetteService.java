package com.recettes.apirecettes.service;

import com.recettes.apirecettes.entity.Recette;
import com.recettes.apirecettes.dto.RecetteDetailDTO;
import java.util.List;
import java.util.Optional;

public interface RecetteService {
    List<Recette> getAll();
    Optional<Recette> getById(Long id);
    Recette save(Recette recette);
    Recette update(Long id, Recette updated);
    void delete(Long id);
    List<RecetteDetailDTO> searchRecettes(String categorie, String ingredient);

}
