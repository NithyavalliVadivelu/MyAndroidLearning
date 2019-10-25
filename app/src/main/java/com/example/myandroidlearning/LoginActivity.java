package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.EditText;

import com.example.myandroidlearning.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    EditText nameEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setViewModel(new LoginBindViewModel());

    }
}
