package com.example.myandroidlearning.util;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dagger.Module;

@Module
public class ResourceUtil extends Application {


    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
       context=getApplicationContext();
    }

    @Inject
    public ResourceUtil() {

    }

    public static Context getAppContext(){

        return context;
    }
}
