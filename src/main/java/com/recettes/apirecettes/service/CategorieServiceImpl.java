package com.recettes.apirecettes.service;

import com.recettes.apirecettes.entity.Categorie;
import com.recettes.apirecettes.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<Categorie> getById(Long id) {
        return categorieRepository.findById(id);
    }

    @Override
    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie update(Long id, Categorie updated) {
        Categorie existing = categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
        existing.setNom(updated.getNom());
        return categorieRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }
}
