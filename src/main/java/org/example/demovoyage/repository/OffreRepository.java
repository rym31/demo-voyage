package org.example.demovoyage.repository;

import org.example.demovoyage.entity.Offre;
import org.example.demovoyage.entity.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Integer> {
    default List<Offre> findByVolId(int volId) {
        return null;
    }
}