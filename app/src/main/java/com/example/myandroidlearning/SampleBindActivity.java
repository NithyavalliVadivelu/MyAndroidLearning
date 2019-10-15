package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import android.os.Bundle;

import com.example.myandroidlearning.databinding.ActivitySampleBind2Binding;
import com.example.myandroidlearning.databinding.ActivitySampleBindBinding;

import java.util.Observer;

public class SampleBindActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySampleBindBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_sample_bind);
        binding.setSampleBind(new SampleBindViewModel());


    }





    public void callLogIn() {
        System.out.println("hererererererererererererererer`");

        ActivitySampleBindBinding binding = ActivitySampleBindBinding.inflate(getLayoutInflater());

         System.out.println("=================>"+binding.getSampleBind().userName.get());
        ActivitySampleBind2Binding binding2 = DataBindingUtil.setContentView(this,R.layout.activity_sample_bind2);
        binding2.setSampleBind(binding.getSampleBind());
    }

    @Override
    public void update(java.util.Observable observable, Object o) {
    if(o instanceof Integer){
        int value=(int) o;
        switch(value){
            case SampleBindViewModel.changeAct:

        }
    }
    }
}
