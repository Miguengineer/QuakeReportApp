package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {
    private double magnitude;
    private String location;
    private Date date;

    public Earthquake(double magnitude, String location, Date date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
