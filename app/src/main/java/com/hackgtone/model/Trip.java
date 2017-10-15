package com.hackgtone.model;

import java.util.*;

public class Trip {
    private List<ServiceCenter> servCenters = new ArrayList<>();
    private String name;

    public Trip(List<ServiceCenter> list, String name) {
        this.servCenters = list;
        this.name = name;
    }

    public List<ServiceCenter> getServiceCenters() {
        return servCenters;
    }

    public List<Flight> getFlights() {
        List<Flight> flightList = new ArrayList<>();
        for (ServiceCenter sc : servCenters) {
            if (sc instanceof Flight) {
                flightList.add((Flight) sc);
            }
        }
        return flightList;
    }

    public List<SkyClub> getSkyClubs() {
        List<SkyClub> skyClubList = new ArrayList<>();
        for (ServiceCenter servCenter : servCenters) {
            if (servCenter instanceof SkyClub) {
                skyClubList.add((SkyClub) servCenter);
            }
        }
        return skyClubList;
    }

    public String getName() {
        return this.name;
    }
}