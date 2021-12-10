package com.openclassrooms.entrevoisins.ui.neighbour_list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class UserInformationActivityTest {

    public NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void addToFavoriteTest() {
        List<Neighbour> favList = service.getFavoriteNeighbours();
        Neighbour neighbour1 = service.getNeighbours().get(0);
        Neighbour neighbour2 = service.getNeighbours().get(1);
        Neighbour neighbour3 = service.getNeighbours().get(2);
        Neighbour neighbour4 = service.getNeighbours().get(3);
        favList.clear();
        favList.add(neighbour1);
        favList.add(neighbour2);
        favList.add(neighbour3);
        favList.add(neighbour4);
        long favListSize = favList.size();
        long expectedSize = 4;
        assertEquals(expectedSize, favListSize);
        assertTrue(service.getFavoriteNeighbours().contains(neighbour1));
        assertTrue(service.getFavoriteNeighbours().contains(neighbour2));
        assertTrue(service.getFavoriteNeighbours().contains(neighbour3));
        assertTrue(service.getFavoriteNeighbours().contains(neighbour4));
    }

}