package com.hackgtone.model;

import java.util.*;
public abstract class ServiceCenter {
    private List<Service> services;
    private List<String> items;
    private int id;
    private String src;
    public ServiceCenter(int id, String src) {
        this.id = id;
        this.src = src;
        this.services = new ArrayList<>();
        this.items=new ArrayList<>();
    } 
    public ServiceCenter(int id, String src, List<Service> services) {
        this.id = id;
        this.src = src;
        this.services = services;
        this.items = new ArrayList<>();
    } 
    public ServiceCenter(int id, String src, List<Service> services, List<String> items)
    {
        this.id = id;
        this.src = src;
        this.services = services;
        this.items = items;
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
    public void addItem(String i) {this.items.add(i);}
    public List<String> getItems() {return this.items;}
    public void removeItem(String i) {
        this.items.remove(i);
    }
    public void addItems(List<String> items) {
        this.items.addAll(items);
    }
    public void setItems(List<String> items) {
        this.items = items;
    }
    public void removeService(Service s) {
        this.services.remove(s);
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