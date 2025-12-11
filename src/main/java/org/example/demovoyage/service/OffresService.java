package org.example.demovoyage.service;

import org.example.demovoyage.entity.Offre;
import org.example.demovoyage.entity.Operateur;
import org.example.demovoyage.entity.Vol;
import org.example.demovoyage.repository.OffreRepository;
import org.example.demovoyage.repository.OperateurRepository;
import org.example.demovoyage.repository.VolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffresService {

    private final VolRepository volRepository;
    private final OperateurRepository operateurRepository;
    private OffreRepository offreRepository;

    public OffresService (OffreRepository offreRepository, VolRepository volRepository, OperateurRepository operateurRepository){
        this.offreRepository = offreRepository;
        this.volRepository = volRepository;
        this.operateurRepository = operateurRepository;
    }

    public List<Offre> getAllOffres(){
        return offreRepository.findAll();
    }

    public Offre createOffre(int id, int volId, int operateurId, String depart, double prixBase) {
        Optional<Vol> trajet = volRepository.findById(volId);
        if (trajet.isEmpty()){
            System.out.println("trajet" + volId + "n'existe pas");
            return null;
        }

        Optional<Operateur> operateur = operateurRepository.findById(operateurId);
        if (operateur.isEmpty()){
            System.out.println("opérateur" + operateurId + "n'existe pas");
            return null;
        }

        // créer l'offre
        Offre offre = new Offre();
        offre.setId(id);
        offre.setTrajet(trajet.get());
        offre.setOperateur(operateur.get());
        offre.setDepart(depart);
        offre.setPrixBase(prixBase);

        return offreRepository.save(offre);
    }

    public  Offre deleteOffre(int id){
            offreRepository.deleteById(id);
        return null;
    };


}
