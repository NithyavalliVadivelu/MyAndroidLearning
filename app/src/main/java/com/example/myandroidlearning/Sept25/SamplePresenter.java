package com.example.myandroidlearning.Sept25;

import android.view.View;
import android.widget.TextView;

import com.example.myandroidlearning.R;

public class SamplePresenter {

    public void changeClick(View view, SampleViewModel name){
System.out.println("here===========================");

        TextView tv= (TextView) view.findViewById(R.id.checkingtext);
        System.out.println("================"+name.lName);
        tv.setText(name.lName);
    }
}
