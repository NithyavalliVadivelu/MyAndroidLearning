package com.example.myandroidlearning.Model;

import com.google.gson.annotations.SerializedName;

public class RegisterParamModel {

    @SerializedName("name")
    String name;
    @SerializedName("userName")
    String userName;
    @SerializedName("password")
    String password;
    @SerializedName("country")
    String country;


    public RegisterParamModel() {
    }

    public RegisterParamModel(String name, String userName, String password, String country) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.country = country;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
