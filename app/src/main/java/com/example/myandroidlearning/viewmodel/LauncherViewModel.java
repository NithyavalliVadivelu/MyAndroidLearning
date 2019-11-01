package com.example.myandroidlearning.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myandroidlearning.Model.LoginParamModel;
import com.example.myandroidlearning.Model.RegisterParamModel;
import com.example.myandroidlearning.Model.UserProfileModel;
import com.example.myandroidlearning.activity.LoginActivity;
import com.example.myandroidlearning.activity.Main7Activity;
import com.example.myandroidlearning.providers.AccountProfileServiceProvider;
import com.example.myandroidlearning.services.AccountProfileServices;
import com.example.myandroidlearning.util.ResourceUtil;
import com.example.myandroidlearning.util.SharedPrefUtils;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class LauncherViewModel extends ViewModel {

   public ObservableField<Integer> visibility= new ObservableField<>(View.VISIBLE);
    public ObservableField<Integer> buttonVisibility= new ObservableField<>(View.GONE);

    Context context= ResourceUtil.getAppContext();
    public void checkCredentials(){
        SharedPrefUtils utils=new SharedPrefUtils();
       HashMap<String,String> credential=utils.getLoginCredentials("LogIn");
       String userName=credential.get("username");
       String password=credential.get("password");
       if(userName.equalsIgnoreCase("")){
           Intent intent= new Intent(context,LoginActivity.class);
           context.startActivity(intent);
       }
       else{
           AccountProfileServices services= AccountProfileServiceProvider.getRetroInstance();
           final Intent myIntent = new Intent(context, Main7Activity.class);
           services.login(new LoginParamModel(userName,password))
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new Observer<UserProfileModel>() {
                       public void onSubscribe(Disposable d) {
                           visibility.set(View.VISIBLE);
                           buttonVisibility.set(View.GONE);
                       }

                       @Override
                       public void onNext(UserProfileModel userProfileModel) {
                           myIntent.putExtra("name",userProfileModel.getName());
                           context.startActivity(myIntent);
                           if(userProfileModel==null){
                               Toast.makeText(context,"User name or Password invalid.",Toast.LENGTH_LONG).show();
                           }
                       }

                       @Override
                       public void onError(Throwable e) {
                           if(e.getMessage().contains("401"))
                               Toast.makeText(context,"User name or Password invalid.",Toast.LENGTH_LONG).show();
                           else
                               Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();

                           visibility.set(View.GONE);
                           buttonVisibility.set(View.VISIBLE);
                       }

                       @Override
                       public void onComplete() {
                           visibility.set(View.GONE);
                           visibility.set(View.VISIBLE);
                       }
                   });
       }
    }
}
