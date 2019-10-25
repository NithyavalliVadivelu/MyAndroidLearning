package com.example.myandroidlearning;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myandroidlearning.Model.LoginParamModel;

import com.example.myandroidlearning.Model.UserProfileModel;
import com.example.myandroidlearning.providers.AccountProfileServiceProvider;
import com.example.myandroidlearning.services.AccountProfileServices;
import com.example.myandroidlearning.util.ResourceUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginBindViewModel extends ViewModel {
    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    final Context context = ResourceUtil.getAppContext();

    public LoginBindViewModel() {
    }

    public LoginBindViewModel(ObservableField<String> userName, ObservableField<String> password) {
        this.userName = userName;
        this.password = password;
    }

    public void showSignupPage() {
        Intent myIntent = new Intent(context, RegistrationActivity.class);
        context.startActivity(myIntent);
    }

    public void checkValidity() {

        final Intent myIntent = new Intent(context, Main7Activity.class);
        AccountProfileServices services = AccountProfileServiceProvider.getRetroInstance();



        services.login(new LoginParamModel(this.userName.get(), this.password.get()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<UserProfileModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserProfileModel userProfileModel) {
                        System.out.println("hereeeeeeeeee======================>"+userProfileModel.getName());
                        myIntent.putExtra("name",userProfileModel.getName());
                        context.startActivity(myIntent);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("com,pleted========================");

                    }
                });


    }


}
