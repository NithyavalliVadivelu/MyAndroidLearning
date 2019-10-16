package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myandroidlearning.Sept18.MainActivity;
import com.example.myandroidlearning.databinding.ActivityOverallMainBinding;

public class OverallMainActivity extends AppCompatActivity {

    EditText nameEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOverallMainBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_overall_main);
        binding.setViewModel(new OverallBindViewModel());
    }
}
