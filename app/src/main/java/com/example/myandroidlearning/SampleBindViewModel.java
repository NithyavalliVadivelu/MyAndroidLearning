package com.example.myandroidlearning;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.myandroidlearning.databinding.ActivitySampleBind2Binding;
import com.example.myandroidlearning.databinding.ActivitySampleBindBinding;

import java.util.Objects;

import javax.inject.Inject;

public class SampleBindViewModel extends ViewModel  {
    public static final int changeAct=100;
    @Inject SamplePresenter presenter;
    public ObservableField<String> userName=new ObservableField<>();
    public ObservableField<String> password=new ObservableField<>();
    public ObservableField<String> confirmPassword=new ObservableField<>();
    public ObservableField<String> showData=new ObservableField<>();
    public SampleBindViewModel(ObservableField<String> text) {
        this.userName = text;
    }

    public SampleBindViewModel(ObservableField<String> userName, ObservableField<String> password) {
        this.userName = userName;
        this.password = password;
    }



    public SampleBindViewModel() {
    }

    public TextWatcher watcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            System.out.println("we are hereeeeeeeeeeeeeeeee");
            if (!Objects.equals(userName.get(), editable.toString())) {
                userName.set(editable.toString());

                System.out.println("went inside ");
            }
        }
    };


    public View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


    public void callLogIn() {
        System.out.println("hererererererererererererererer===>"+userName.get()+"=========>"+password.get()+"========>"+confirmPassword.get());
        if(Objects.equals(confirmPassword.get(),password.get())) {
            showData.set("Password for " + userName.get() + " is " + password.get());
        }else{
            showData.set("Password miss match found !!");
        }

        SampleComponent sampleComponent=DaggerSampleComponent.create();
       /* Sample sample=sampleComponent.getSample();
        sample.printText();*/

       sampleComponent.inject(this);

     System.out.println("date issss=================>"+presenter.data);

    }
}