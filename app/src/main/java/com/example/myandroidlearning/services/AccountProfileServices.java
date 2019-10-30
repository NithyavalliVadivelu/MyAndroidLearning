package com.example.myandroidlearning.services;

import com.example.myandroidlearning.Model.LoginParamModel;
import com.example.myandroidlearning.Model.RegisterParamModel;
import com.example.myandroidlearning.Model.UserProfileModel;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountProfileServices {



    @POST("/login")
    Observable<UserProfileModel> login(@Body LoginParamModel loginParamModel);


    @POST("register")
    Observable<Response<ResponseBody>> register(@Body RegisterParamModel registerParamModel);
}
