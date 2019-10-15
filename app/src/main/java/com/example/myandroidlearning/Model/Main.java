package com.example.myandroidlearning.Model;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private float temp;

    @SerializedName("pressure")
    private int pressure;

    @SerializedName("humidity")
    private int humidity;


    @SerializedName("temp_min")
    private float temp_min;

    @SerializedName("temp_max")
    private float temp_max;

    @SerializedName("sea_level")
    private int sea_level;

    @SerializedName("grnd_level")
    private int grnd_level;


    public Main(float temp, int pressure, int humidity, float temp_min, float temp_max, int sea_level, int grnd_level) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
    }

    public Main(float temp) {
        this.temp = temp;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public int getSea_level() {
        return sea_level;
    }

    public void setSea_level(int sea_level) {
        this.sea_level = sea_level;
    }

    public int getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(int grnd_level) {
        this.grnd_level = grnd_level;
    }
}
