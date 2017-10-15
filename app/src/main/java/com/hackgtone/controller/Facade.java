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

public class Facade {

    private static final Facade ourInstance = new Facade();
    private static Trip currentTrip;
    private static ServiceCenter currentServiceCenter;
    private static Service currentService;
    private static User currentUser;
    private Facade() {
        List<ServiceCenter> scList = new ArrayList<>(Arrays.asList(
                new SkyClub(1, "ATL"),
                new Flight(2456, "ATL", "JFK", "09:01", "13:00"),
                new Flight(8791, "JFK", "SEA", "13:02", "18:34")));
        List<ServiceCenter> scList2 = new ArrayList<>(Arrays.asList(
                new Flight(3211, "DEN", "SFO", "06:13", "9:17"),
                new SkyClub(2, "SFO"),
                new Flight(9100, "SFO", "DEN", "22:53", "23:20")));
        List<Trip> tripList = new ArrayList<>(Arrays.asList(
                new Trip(scList, "ATL -> SEA"),
                new Trip(scList2, "DEN -> SFO")));
        currentUser = new User("Cole", tripList);
        scList.get(0).addService(new Service("8:15-8:30", "Breakfast A", "With orange juice", currentUser));
        scList.get(0).setItems(Arrays.asList("Cookies","Coke","Breakfast A", "Breakfast B","Blanket"));
        scList.get(1).setItems(Arrays.asList("Peanuts","Coke","Breakfast A", "Breakfast B","Blanket"));
        scList.get(2).setItems(Arrays.asList("Cookies","Coke","Breakfast A", "Breakfast B","Blanket"));
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

    public static ServiceCenter getCurrentServiceCenter() {
        return currentServiceCenter;
    }

    public static void setCurrentServiceCenter(ServiceCenter currentServiceCenter) {
        Facade.currentServiceCenter = currentServiceCenter;
    }


}
