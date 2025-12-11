package org.example.demovoyage.repository;

import org.example.demovoyage.entity.Operateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperateurRepository extends JpaRepository<Operateur, Integer> {
    Operateur findOperateurById(int id);
}