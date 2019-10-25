package com.example.myandroidlearning.services;

import com.example.myandroidlearning.Model.LoginParamModel;
import com.example.myandroidlearning.Model.RegisterParamModel;
import com.example.myandroidlearning.Model.UserProfileModel;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AccountProfileServices {



    @POST("/login")
    Observable<UserProfileModel> login(@Body LoginParamModel loginParamModel);


    @POST("register")
    Observable<String> register(@Body RegisterParamModel registerParamModel);
}
