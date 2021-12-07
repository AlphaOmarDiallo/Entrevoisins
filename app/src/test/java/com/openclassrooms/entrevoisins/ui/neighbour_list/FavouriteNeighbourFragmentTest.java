package com.openclassrooms.entrevoisins.ui.neighbour_list;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class FavouriteNeighbourFragmentTest {

    public NeighbourApiService service;

    @Before
    public void setup(){
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void displayFavouriteNeighboursOnly() {
        List<Neighbour> favNeighbours = service.getFavNeighbour();
        List<Neighbour> neighbours = service.getNeighbours();
        favNeighbours.add(neighbours.get(0));
        favNeighbours.add(neighbours.get(1));
        long neighbourAddedInFav = 2;
        long favNeighbourSize = favNeighbours.size();
        long neighbourSize = neighbours.size();
        assertEquals(neighbourAddedInFav, favNeighbourSize);
        assertNotEquals(favNeighbourSize, neighbourSize);
    }
}