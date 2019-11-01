package com.example.myandroidlearning.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
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
import com.example.myandroidlearning.util.SharedPrefUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginBindViewModel extends ViewModel {
    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    final Context context = ResourceUtil.getAppContext();
    public ObservableField<Integer> visibility= new ObservableField<>();

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

                    String userName="";
                     String password="";
                    String name="";
                    @Override
                    public void onSubscribe(Disposable d) {
                       visibility.set(View.VISIBLE);
                       LoginActivity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }

                    @Override
                    public void onNext(UserProfileModel userProfileModel) {
                        if(userProfileModel==null){
                            Toast.makeText(context,"User name or Password invalid.",Toast.LENGTH_LONG).show();
                        }else {
                            name = userProfileModel.getName();
                            userName = userProfileModel.getUserName();
                            password = userProfileModel.getPassword();
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
                        visibility.set(View.GONE);
                        LoginActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        myIntent.putExtra("name",name);
                        if(!userName.equalsIgnoreCase("") && !password.equalsIgnoreCase("")) {
                            SharedPrefUtils utils = new SharedPrefUtils();
                            HashMap<String, String> credentials = new HashMap<>();
                            credentials.put("username", userName);
                            credentials.put("password", password);
                            utils.saveLoginCredential(credentials, "LogIn");
                        }
                        context.startActivity(myIntent);
                    }
                });
    }


}
