package org.example.demovoyage.service;

import org.example.demovoyage.entity.Offre;
import org.example.demovoyage.repository.OffresRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreService {

    private OffresRepo offreRepository;

    public void OffreServices (OffresRepo offresRepo){
        this.offreRepository = offreRepository;
    }

    public List<Offre> getAllOffres(){
        return offreRepository.findAll();
    }

    public Offre createOffre(int id, int volId, int operateurId, String depart, double prixBase) {
        // à faire
        // vérfieir si le vol et l'opérateur existent
        // créer l'offre
        return new Offre();
    }
}
