package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.myandroidlearning.databinding.ActivityMain4Binding;

public class Main4Activity extends AppCompatActivity {

    int androidFlag=0;
    int iosFlag=0;
    int initial=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain4Binding binding= DataBindingUtil.setContentView(this,R.layout.activity_main4);
        Sample VM=new Sample("John","William");
        binding.setName(VM);

       // setContentView(R.layout.activity_main4);
        /*if(initial==0) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            BlankFragment androidFrag = new BlankFragment();

            transaction.add(R.id.frag, androidFrag);
            transaction.commit();
            androidFlag = 1;
            System.out.println("androidflag======>" + androidFlag);
            System.out.println("iosFlag========>" + iosFlag);
            initial=1;
        }*/
    }

    public void showAndroidFrag(View view){
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.frag);
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        BlankFragment androidFrag=new BlankFragment();

        System.out.println("androidflag======>"+androidFlag);
        System.out.println("iosFlag========>"+iosFlag);
        if(androidFlag==1 || iosFlag==1)
            transaction.replace(R.id.frag,androidFrag);
        else
            transaction.add(R.id.frag,androidFrag);
        transaction.addToBackStack(null);
        transaction.commit();

        androidFlag=1;
        iosFlag=0;}

    public void showIOSFrag(View view){

        System.out.println("androidflag======>"+androidFlag);
        System.out.println("iosFlag========>"+iosFlag);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        BlankFragment2 iosFrag=new BlankFragment2();
        if(androidFlag==1 || iosFlag==1)
            transaction.replace(R.id.frag,iosFrag);
        else
            transaction.add(R.id.frag,iosFrag);
        transaction.addToBackStack(null);
        transaction.commit();
        iosFlag=1;
        androidFlag=0;

    }

}