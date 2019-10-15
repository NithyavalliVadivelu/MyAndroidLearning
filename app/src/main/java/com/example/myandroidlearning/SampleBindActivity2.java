package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myandroidlearning.databinding.ActivitySampleBind2Binding;

public class SampleBindActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySampleBind2Binding binding = DataBindingUtil.setContentView(this,R.layout.activity_sample_bind2);



    }

    public void showData(ObservableField<String> text){
        System.out.println("sample============>"+text);

        /*ActivitySampleBind2Binding binding = DataBindingUtil.setContentView(this,R.layout.activity_sample_bind2);
        binding.setSampleBind(new SampleBindViewModel(text));*/

        EditText text1= (EditText) findViewById(R.id.showtext);
        text1.setText(text.get());
        setContentView(R.layout.activity_sample_bind2);
    }

}
