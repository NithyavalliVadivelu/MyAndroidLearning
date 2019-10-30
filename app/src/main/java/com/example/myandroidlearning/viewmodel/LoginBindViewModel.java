package com.example.myandroidlearning.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.activity.LoginActivity;
import com.example.myandroidlearning.activity.Main7Activity;
import com.example.myandroidlearning.Model.LoginParamModel;

import com.example.myandroidlearning.Model.UserProfileModel;
import com.example.myandroidlearning.activity.RegistrationActivity;
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
    public ObservableField<Integer> visibility= new ObservableField<>();
    ///public MutableLiveData<Integer> visibility=new MutableLiveData<>();


    public LoginBindViewModel() {
        visibility.set( View.GONE);
    }

    public LoginBindViewModel(ObservableField<String> userName, ObservableField<String> password) {
        this.userName = userName;
        this.password = password;
    }

    public void showSignupPage() {
        Intent myIntent = new Intent(context, RegistrationActivity.class);
        context.startActivity(myIntent);
    }

    public void checkValidity(View view ) {

        final Intent myIntent = new Intent(context, Main7Activity.class);
        AccountProfileServices services = AccountProfileServiceProvider.getRetroInstance();





        services.login(new LoginParamModel(this.userName.get(), this.password.get()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<UserProfileModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("in subcribe=================");
                       visibility.set(View.VISIBLE);
                       LoginActivity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


                    }

                    @Override
                    public void onNext(UserProfileModel userProfileModel) {
                        System.out.println("hereeeeeeeeee======================>"+userProfileModel.getName());
                        LoginActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        myIntent.putExtra("name",userProfileModel.getName());
                        context.startActivity(myIntent);

                        if(userProfileModel==null){
                            Toast.makeText(context,"User name or Password invalid.",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LoginActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                       if(e.getMessage().contains("401"))
                        Toast.makeText(context,"User name or Password invalid.",Toast.LENGTH_LONG).show();
                       else
                           Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();

                        visibility.set(View.GONE);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("com,pleted========================");
                        visibility.set(View.GONE);
                        LoginActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                      //  LoginActivity.layout.
                    }
                });


    }


}
