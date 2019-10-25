package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myandroidlearning.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegistrationBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_registration);
        binding.setViewModel(new RegistrationViewModel());
        Spinner spinner = findViewById(R.id.reg_country);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.list_items,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



    }
}
