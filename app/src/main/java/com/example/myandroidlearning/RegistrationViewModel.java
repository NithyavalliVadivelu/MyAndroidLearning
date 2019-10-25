package com.example.myandroidlearning;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myandroidlearning.Model.RegisterParamModel;
import com.example.myandroidlearning.Model.UserProfileModel;
import com.example.myandroidlearning.providers.AccountProfileServiceProvider;
import com.example.myandroidlearning.services.AccountProfileServices;
import com.example.myandroidlearning.util.ResourceUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegistrationViewModel extends ViewModel {

    public ObservableField<String> userName=new ObservableField<>();
    public ObservableField<String> password=new ObservableField<>();
    public ObservableField<String> confirmPassword=new ObservableField<>();
    public ObservableField<String> name=new ObservableField<>();
    public ObservableField<String> country=new ObservableField<>();




    public void onSelectItem(AdapterView<?> parent, View view, int pos, long id)
    {
        //pos                                 get selected item position
                           //  get lable of selected item
        //parent.getAdapter().getItem(pos)    get item by pos
        //parent.getAdapter().getCount()      get item count
        //parent.getCount()                   get item count
        //parent.getSelectedItem()            get selected item
        //and other...
        country.set(parent.getSelectedItem().toString());

    }

    public void submitData(){

        AccountProfileServices services= AccountProfileServiceProvider.getRetroInstance();
        services.register(new RegisterParamModel(name.get(),userName.get(),password.get(),country.get()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
        System.out.println("--------------------------------------in onsub");
                    }

                    @Override
                    public void onNext(String string) {
                        System.out.println("hewre======>"+string);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("--------------------------in error"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                        System.out.println("in complete--------------------------");
                        Context context= ResourceUtil.getAppContext();
                        Intent intent=new Intent(context, RegisterationSuccessActivity.class);
                        context.startActivity(intent);
                    }
                });
    }


public void getData(String data){
    System.out.println("text============>"+data);
}

}


