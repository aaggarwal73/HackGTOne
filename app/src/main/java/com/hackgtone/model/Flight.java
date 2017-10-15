package com.hackgtone.model;

import java.util.*;

public class Flight extends ServiceCenter {
    private String dst;
    private String departing;

    public Flight(int id, String src, String dst, String departing) {
        super(id, src);
        this.dst = dst;
        this.departing = departing;
    }
    public Flight(int id, String src, String dst, String departing, List<Service> services) {
        super(id, src, services);
        this.dst = dst;
        this.departing = departing;
    }

    public String getDst() {
        return this.dst;
    }

    public String getDeparting() {
        return this.departing;
    }
}