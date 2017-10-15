package com.hackgtone.controller;

import com.hackgtone.model.Flight;
import com.hackgtone.model.Service;
import com.hackgtone.model.ServiceCenter;
import com.hackgtone.model.SkyClub;
import com.hackgtone.model.Trip;
import com.hackgtone.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aman on 10/14/17.
 */

class Facade {

    private static final Facade ourInstance = new Facade();
    private static Trip currentTrip;
    private static Service currentService;
    private static User currentUser;
    private Facade() {
        List<ServiceCenter> scList = new ArrayList<>(Arrays.asList(
                new Flight(2456, "ATL", "JFK", "09:01"),
                new Flight(8791, "JFK", "SEA", "12:02"),
                new SkyClub(1, "ATL")));
        List<ServiceCenter> scList2 = new ArrayList<>(Arrays.asList(
                new Flight(3211, "DEN", "SFO", "06:13"),
                new Flight(9100, "SFO", "DEN", "22:53"),
                new SkyClub(2, "SFO")));
        List<Trip> tripList = new ArrayList<>(Arrays.asList(
                new Trip(scList, "ATL -> SEA"),
                new Trip(scList2, "DEN -> SFO")));
        currentUser = new User("Cole", tripList);
    }
    static Facade getInstance() {
        return ourInstance;
    }

    public static void setCurrentTrip(Trip trip) {
        currentTrip = trip;
    }
    public static Trip getCurrentTrip() {
        return currentTrip;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Service getCurrentService() {
        return currentService;
    }

    public static void setCurrentService(Service currentService) {
        Facade.currentService = currentService;
    }
}