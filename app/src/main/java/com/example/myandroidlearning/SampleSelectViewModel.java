package com.example.myandroidlearning;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SampleSelectViewModel extends BaseObservable {

    private  String lname;
    private   String fname;

    @Bindable
    public  String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Bindable
    public  String getFname() {
        return fname;
    }

    public  void setFname(String fname) {
        this.fname = fname;
    }




    public void onChangeClick(View view){
        System.out.println("here==========================="+getLname());

         int checkingtext = R.id.checkingtext;
        TextView tv= (TextView) view.findViewById(R.id.checkingtext);
       // String lname=name.lName;
       // System.out.println("================"+lname);

    }
}
