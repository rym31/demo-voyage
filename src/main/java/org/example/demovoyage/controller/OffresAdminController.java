package org.example.demovoyage.controller;

import org.example.demovoyage.entity.Offre;
import org.example.demovoyage.service.OffresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/offres")
public class OffresAdminController {

    private final OffresService offresService;

    public OffresAdminController (OffresService offreService){

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

    @PutMapping("/update")
    public ResponseEntity<Offre> updateOffre(
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
    @DeleteMapping("/supprimer")
    public void delete (@RequestParam int id){
        offresService.deleteOffre(id);
    }
}

