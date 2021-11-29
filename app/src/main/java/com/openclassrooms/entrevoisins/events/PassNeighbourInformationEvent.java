package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class PassNeighbourInformationEvent {

    /**
     * Neighbour data pass to UserInformation activity
     */
    public Neighbour neighbour;

    /**
     /**
     * Constructor.
     * @param neighbour
     */
    public PassNeighbourInformationEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}
