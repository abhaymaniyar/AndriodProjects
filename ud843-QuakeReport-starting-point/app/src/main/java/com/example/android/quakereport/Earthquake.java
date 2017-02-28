package com.example.android.quakereport;

/**
 * Created by abhay on 8/2/17.
 */

public class Earthquake {

    private Double magnitude;
    private String place;
    private Long date;
    private String url;

    public Earthquake(Double magnitude, String place, Long date, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.date = date;
        this.url = url;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public Long getTimeInMillisecond() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
