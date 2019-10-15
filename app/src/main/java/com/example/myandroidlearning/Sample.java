package com.example.myandroidlearning;


import javax.inject.Inject;

public class Sample {

    public String Fname;
    public String lName;

    @Inject
    public Sample() {
    }

    public Sample(String fname, String lName) {
        this.Fname = fname;
        this.lName = lName;
        System.out.println("fname===>"+lName);
    }


    public String getFname() {
        return Fname;
    }


    public String getlName() {
        return lName;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    void printText(){

        System.out.println("Dagger is working ");

        SamplePresenter samplePresenter;






    }




}
