package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class OpenUserProfileFromFavEvent {
    /**
     * Neighbour data to open
     */
    public Neighbour neighbour;

    /**
     /**
     * Constructor.
     * @param neighbour
     */
    public OpenUserProfileFromFavEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}
