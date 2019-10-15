package com.example.myandroidlearning.Model;

import com.google.gson.annotations.SerializedName;

public class Coord {
    @SerializedName("lon")
    private String lon;

    @SerializedName("lat")
    private float lat;

    public Coord(String lon, float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
