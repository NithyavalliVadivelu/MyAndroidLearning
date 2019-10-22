package com.example.myandroidlearning;

import androidx.databinding.ObservableField;

import javax.inject.Inject;

import dagger.Module;


public class HelpItem {

    String text;

    public HelpItem() {
    }


    public HelpItem(String text) {
        this.text = text;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
