package com.recettes.apirecettes.service;

import com.recettes.apirecettes.entity.Recette;
import com.recettes.apirecettes.entity.RecetteIngredient;
import com.recettes.apirecettes.repository.RecetteIngredientRepository;
import com.recettes.apirecettes.repository.RecetteRepository;
import com.recettes.apirecettes.dto.RecetteDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecetteServiceImpl implements RecetteService {

    private final RecetteRepository recetteRepository;
    private final RecetteIngredientRepository recetteIngredientRepository;

    public RecetteServiceImpl(RecetteRepository recetteRepository,
                              RecetteIngredientRepository recetteIngredientRepository) {
        this.recetteRepository = recetteRepository;
        this.recetteIngredientRepository = recetteIngredientRepository;
    }

    @Override
    public List<Recette> getAll() {
        return recetteRepository.findAll();
    }

    @Override
    public Optional<Recette> getById(Long id) {
        return recetteRepository.findById(id);
    }

    @Override
    public Recette save(Recette recette) {
        return recetteRepository.save(recette);
    }

    @Override
    public Recette update(Long id, Recette updated) {
        Recette existing = recetteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recette non trouvée"));
        existing.setNom(updated.getNom());
        existing.setDescription(updated.getDescription());
        existing.setCategorie(updated.getCategorie());
        return recetteRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        recetteRepository.deleteById(id);
    }

    @Override
    public List<RecetteDetailDTO> searchRecettes(String categorie, String ingredient) {
        List<Recette> recettes = recetteRepository.findAll();

        return recettes.stream()
                .filter(r -> categorie == null || r.getCategorie().getNom().equalsIgnoreCase(categorie))
                .filter(r -> {
                    if (ingredient == null) return true;
                    return recetteIngredientRepository.findByRecetteId(r.getId()).stream()
                            .anyMatch(ri -> ri.getIngredient().getNom().equalsIgnoreCase(ingredient));
                })
                .map(r -> {
                    List<RecetteDetailDTO.IngredientDTO> ingredients = recetteIngredientRepository
                            .findByRecetteId(r.getId())
                            .stream()
                            .map(ri -> new RecetteDetailDTO.IngredientDTO(
                                    ri.getIngredient().getNom(),
                                    ri.getQuantite(),
                                    ri.getUnite()
                            ))
                            .collect(Collectors.toList());

                    return new RecetteDetailDTO(
                            r.getId(),
                            r.getNom(),
                            r.getDescription(),
                            r.getCategorie().getNom(),
                            ingredients
                    );
                })
                .collect(Collectors.toList());
    }
}
