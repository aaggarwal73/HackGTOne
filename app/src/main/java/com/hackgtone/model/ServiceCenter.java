package com.hackgtone.model;

import java.util.*;
public abstract class ServiceCenter {
    private List<Service> services;
    private int id;
    private String src;
    public ServiceCenter(int id, String src) {
        this.id = id;
        this.src = src;
        this.services = new ArrayList<>();
    } 
    public ServiceCenter(int id, String src, List<Service> services) {
        this.id = id;
        this.src = src;
        this.services = services;
    } 

    public List<Service> getServices(User user) {
        ArrayList<Service> userServices = new ArrayList<>();
        for(Service s: this.services) {
            if(s.getUser().equals(user)) {
                userServices.add(s);
            }
        }
        return userServices;
    }
    public void addService(Service s) {
        this.services.add(s);
    }

    public List<Service> getServices() {
        return this.services;
    }
    public int getId() {
        return this.id;
    }
    public String getSrc() {
        return this.src;
    }
}