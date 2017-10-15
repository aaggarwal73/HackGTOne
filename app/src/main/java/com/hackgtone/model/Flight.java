package com.hackgtone.model;

import java.util.*;

public class Flight extends ServiceCenter {
    private String dst;
    private String departing;
    private String arriving;

    public Flight(int id, String src, String dst, String departing, String arriving) {
        super(id, src);
        this.dst = dst;
        this.departing = departing;
        this.arriving = arriving;
    }
    public Flight(int id, String src, String dst, String departing, String arriving, List<Service> services) {
        super(id, src, services);
        this.dst = dst;
        this.departing = departing;
        this.arriving = arriving;
    }

    public String getDst() {
        return this.dst;
    }
    public String getDeparting() {
        return this.departing;
    }
    public String getArriving() {return this.arriving;}
}