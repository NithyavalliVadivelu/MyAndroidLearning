package com.example.myandroidlearning.services;


import com.example.myandroidlearning.Model.LoginParamModel;
import com.example.myandroidlearning.Model.RetroPhoto;
import com.example.myandroidlearning.Model.UserProfileModel;
import com.example.myandroidlearning.Model.WeatherDetails;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetServices {

    @GET("/data/2.5/weather")
    Call<WeatherDetails> getWeatherDetailsBasedOnCityName(@Query("q") String q, @Query("appid") String appid);

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();





}
