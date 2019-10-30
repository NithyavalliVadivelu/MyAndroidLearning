package com.example.myandroidlearning.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.databinding.ActivityLoginBinding;
import com.example.myandroidlearning.viewmodel.LoginBindViewModel;

public class LoginActivity extends AppCompatActivity {

    EditText nameEdit;
    public static  Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding=DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel(new LoginBindViewModel());
       window=getWindow();


    }

    public void applyOverlayLayout(View view){

    }

    @Override
    public void onBackPressed() {
    super.onBackPressed();

    }
}
