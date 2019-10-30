package com.example.myandroidlearning.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.databinding.ActivityRegistrationBinding;
import com.example.myandroidlearning.viewmodel.RegistrationViewModel;

public class RegistrationActivity extends AppCompatActivity {

    public static Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegistrationBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_registration);
        binding.setViewModel(new RegistrationViewModel());
        Spinner spinner = findViewById(R.id.reg_country);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.list_items,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        window=getWindow();



    }

    @Override
    public void onBackPressed() {

        Button button=(Button)findViewById(R.id.reg_button);
        System.out.println("clickable  =====>"+button.isEnabled());
        if(!button.isEnabled()){
            super.onBackPressed();
        }
    }
}
