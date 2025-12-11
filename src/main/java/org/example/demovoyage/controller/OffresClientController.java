package org.example.demovoyage.controller;

import org.example.demovoyage.entity.Offre;
import org.example.demovoyage.service.OffresService;
import org.example.demovoyage.service.OffresClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voyageur/offres")
public class OffresClientController {
    private final OffresService offresService;
    private final OffresClientService offresClientService;

    public OffresClientController(OffresService offresService, OffresClientService offresClientService) {
        this.offresService = offresService;
        this.offresClientService = offresClientService;
    }

    @GetMapping("/vol")
    public List<Offre> findByTrajetId(int volId){
        return offresClientService.offreList(volId);
    }

    @GetMapping("/vol/min")
    public double min(int volId){
        return offresClientService.prixMin(volId);
    }

    @GetMapping("/vol/max")
    public double max(int volId){
        return offresClientService.prixMax(volId);
    }


}