package com.example.myandroidlearning.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherDetails {

    @SerializedName("coord")
    Coord coord;

    Weather[] weather;
    @SerializedName("base")
     String base;
    @SerializedName("main")
     Main main;
    @SerializedName("visibility")
     int visibility;
    @SerializedName("wind")
    Wind wind;
    @SerializedName("clouds")
    cloud clouds;
    @SerializedName("dt")
    int dt;
    @SerializedName("sys")
    Sys sys;
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("cod")
    int cod;


    public WeatherDetails(Coord coord, Weather[] weather, String base, Main main, int visibility, Wind wind, cloud clouds, int dt, Sys sys, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public cloud getClouds() {
        return clouds;
    }

    public void setClouds(cloud clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
