package org.example.demovoyage;

import org.example.demovoyage.entity.Offre;
import org.example.demovoyage.repository.OffreRepository;
import org.example.demovoyage.service.OffresClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class testPrixOffres {

    @Mock
    private OffreRepository repo;

    @InjectMocks
    private OffresClientService service;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void prixMax_retournePrixMaximum() {
        Offre o1 = new Offre();
        o1.setPrixBase(100);
        Offre o2 = new Offre();
        o2.setPrixBase(250);

        when(repo.findByVolId(1)).thenReturn(Arrays.asList(o1, o2));

        double result = service.prixMax(1);

        assertEquals(250, result);
    }

    @Test
    void prixMin_retournePrixMinimum() {
        Offre o1 = new Offre();
        o1.setPrixBase(100);
        Offre o2 = new Offre();
        o2.setPrixBase(250);

        when(repo.findByVolId(1)).thenReturn(Arrays.asList(o1, o2));

        double result = service.prixMin(1);

        assertEquals(100, result);
    }
}
