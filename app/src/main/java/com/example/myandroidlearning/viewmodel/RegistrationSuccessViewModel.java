package com.example.myandroidlearning.viewmodel;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.example.myandroidlearning.activity.LoginActivity;
import com.example.myandroidlearning.util.ResourceUtil;

public class RegistrationSuccessViewModel extends ViewModel {

    public void goLogin(){
        Context context=ResourceUtil.getAppContext();
        Intent intent=new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
