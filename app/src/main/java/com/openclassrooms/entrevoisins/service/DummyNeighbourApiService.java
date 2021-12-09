package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


    /**
     * favorite
     */

    private List<Neighbour> favNeighbour = DummyNeighbourGenerator.generateDummyFavNeighbours();

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        return favNeighbour;
    }

    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        favNeighbour.remove(neighbour);
    }

    @Override
    public void createFavoriteNeighbour(Neighbour neighbour) {
        int isIn = 0;
        for (int i = 0; i < favNeighbour.size(); i++) {
            if (neighbour.equals(favNeighbour.get(i))) {
                isIn = 1;
            }
        }
        if (isIn != 1) {
            favNeighbour.add(neighbour);
        } else {
            System.out.println("Already in");
        }

    }
}
