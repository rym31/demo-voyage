package org.example.demovoyage.service;

import org.example.demovoyage.entity.Offre;
import org.example.demovoyage.repository.OffreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffresClientService {
    private final OffreRepository offreRepository;

    public OffresClientService(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    public List<Offre> offreList(int volId){
        return offreRepository.findByVolId(volId);
    }

    public double prixMax(int volId){
        List<Offre> offres = offreList(volId);
        if (offres.isEmpty()) return 0;
        double max = offres.get(0).getPrixBase();
        for (Offre offre : offres) {
            if (offre.getPrixBase() > max) max = offre.getPrixBase();
        }
        return max;
    }

    public double prixMin(int volId){
        List<Offre> offres = offreList(volId);
        if (offres.isEmpty()) return 0;
        double min = offres.get(0).getPrixBase();
        for (Offre offre : offres) {
            if (offre.getPrixBase() < min) min = offre.getPrixBase();
        }
        return min;
    }
}