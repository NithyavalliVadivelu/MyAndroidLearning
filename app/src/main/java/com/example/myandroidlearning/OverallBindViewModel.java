package com.example.myandroidlearning;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class OverallBindViewModel extends ViewModel {
    public ObservableField<String> userName=new ObservableField<>();
    public ObservableField<String> password=new ObservableField<>();

    public OverallBindViewModel() {
    }

    public OverallBindViewModel(ObservableField<String> userName, ObservableField<String> password) {
        this.userName = userName;
        this.password = password;
    }

    public void showSignupPage(){
        System.out.println("came here for Navigation ");
    }

    public void checkValidity(){
        System.out.println("came here for validity checking ");

    }

}
