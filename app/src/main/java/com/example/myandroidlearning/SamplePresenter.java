package com.example.myandroidlearning;

import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;


@Module
public class SamplePresenter {


    public SamplePresenter() {

    }

   @Inject  Sample data;
    Sample2 sample2;


    @Inject
    public SamplePresenter(Sample2 sample2) {
        this.sample2 = sample2;
    }



    @Provides
    static Sample2 provideSample2(Child1 child1){
        System.out.println("here===========================offffffffff=======dagger provides working");
        return new Sample2(child1);
    }

    @Provides
    static Child1 provideChild1(){
        System.out.println("here===========================offffffffff=======child1is creating");
    return new Child1();
    }



}
