package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourPagerAdapter;

/**
 * Event fired when a user click on profile picture of a neighbour
 */
public class OpenUserProfileEvent {

        /**
         * Neighbour data to open
         */
        public Neighbour neighbour;

        /**
         /**
         * Constructor.
         * @param neighbour
         */
        public OpenUserProfileEvent(Neighbour neighbour) {
            this.neighbour = neighbour;
        }
}
