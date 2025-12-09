package org.example.demovoyage.controller;

import org.example.demovoyage.entity.Offre;
import org.example.demovoyage.service.OffreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/offres")
public class OffresAdminController {

    private final OffreService offresService;

    public OffresAdminController (OffreService offreService){

        this.offresService = offreService;

    }

    // CRUD
    @GetMapping("/all")
    public List<Offre> read(){
        return offresService.getAllOffres();
    }

    @PostMapping("/create")
    public ResponseEntity<Offre> createOffre(
            @RequestParam int id,
            @RequestParam int trajetId,
            @RequestParam int operateurId,
            @RequestParam String depart,
            @RequestParam double prixBase
    ) {
        return ResponseEntity.ok(
                offresService.createOffre(id, trajetId, operateurId, depart, prixBase)
        );
    }
}
