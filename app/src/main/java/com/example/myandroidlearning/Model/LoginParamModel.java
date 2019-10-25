package com.example.myandroidlearning.Model;

public class LoginParamModel {

    String userName;
    String password;


    public LoginParamModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public LoginParamModel() {
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
}
