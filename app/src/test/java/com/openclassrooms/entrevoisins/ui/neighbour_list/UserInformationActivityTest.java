package com.openclassrooms.entrevoisins.ui.neighbour_list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.*;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.List;


@RunWith(JUnit4.class)
public class UserInformationActivityTest {

    public NeighbourApiService service;
    public UserInformationActivity mUserInformationActivity = new UserInformationActivity();

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void addToFavoriteTest() {
        List<Neighbour> favList = service.getFavNeighbour();
        Neighbour neighbour1 = mock(Neighbour.class);
        Neighbour neighbour2 = mock(Neighbour.class);
        Neighbour neighbour3 = mock(Neighbour.class);
        Neighbour neighbour4 = mock(Neighbour.class);
        favList.add(neighbour1);
        favList.add(neighbour2);
        favList.add(neighbour3);
        favList.add(neighbour4);
        long favListSize = favList.size();
        long expectedSize = 4;
        assertEquals(expectedSize, favListSize);
    }

}