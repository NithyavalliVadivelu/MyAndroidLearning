package com.example.myandroidlearning.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.databinding.ActivityLauncherBinding;
import com.example.myandroidlearning.viewmodel.LauncherViewModel;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LauncherViewModel viewModel=new LauncherViewModel();
        ActivityLauncherBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_launcher);
        binding.setViewModel(viewModel);
        viewModel.checkCredentials();



    }
}
