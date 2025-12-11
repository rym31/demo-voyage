package org.example.demovoyage.repository;

import org.example.demovoyage.entity.Aeroport;
import org.example.demovoyage.entity.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AeroportRepository extends JpaRepository<Aeroport, Integer> {
    Aeroport findById(String code);
}