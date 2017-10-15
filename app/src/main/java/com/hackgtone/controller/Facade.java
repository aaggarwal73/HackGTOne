package com.hackgtone.controller;

import com.hackgtone.model.*;

/**
 * Created by Aman on 10/14/17.
 */

class Facade {

    private static final Facade ourInstance = new Facade();
    private static String currentTrip; //change to type Trip later
    private static String chosenLeg; //change to type Itinerary later
    private static Service services;
    private static Trip trips;
    private Facade() {

    }
    static Facade getInstance() {
        return ourInstance;
    }

    public static void setCurrentTrip(String trip) {
        currentTrip = trip;
    }
    public static String getCurrentTrip() {
        return currentTrip;
    }

}
