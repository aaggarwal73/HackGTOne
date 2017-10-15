package com.hackgtone;

import com.hackgtone.model.*;

/**
 * Created by Aman on 10/14/17.
 */

class Main {

    private static final Main ourInstance = new Main();
    private static String currentTrip; //change to type Trip later
    private static String chosenLeg; //change to type Itinerary later
    private static Service services;
    private static Trip trips;
    private Main() {

    }
    static Main getInstance() {
        return ourInstance;
    }

    public static void setCurrentTrip(String trip) {
        currentTrip=trip;
    }
    public static String getCurrentTrip() {
        return currentTrip;
    }

}
