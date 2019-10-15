package com.example.myandroidlearning.Model;

import com.google.gson.annotations.SerializedName;

public class cloud {
    @SerializedName("all")
    private int all;

    public cloud(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
