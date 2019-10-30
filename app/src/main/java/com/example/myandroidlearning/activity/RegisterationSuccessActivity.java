package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.myandroidlearning.databinding.ActivityRegisterationSuccessBinding;
import com.example.myandroidlearning.viewmodel.RegistrationSuccessViewModel;

public class RegisterationSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRegisterationSuccessBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_registeration_success);
        binding.setViewModel(new RegistrationSuccessViewModel());
    }
}
