package com.hackgtone.model;

public class Service {
    private String timeframe;
    private String item;
    private String comment;
    private User user;

    public Service(String timeframe, String item, String comment, User user) {
        this.timeframe = timeframe;
        this.item = item;
        this.comment = comment;
        this.user = user;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
}