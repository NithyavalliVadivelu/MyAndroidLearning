package com.example.myandroidlearning.Sept25;

public class SampleViewModel  {

    public String Fname;
    public String lName;

    public SampleViewModel(String fname, String lName) {
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


}
