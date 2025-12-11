package org.example.demovoyage.repository;

import org.example.demovoyage.entity.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolRepository extends JpaRepository<Vol, Integer>  {
    Vol getVolById(int id);
}