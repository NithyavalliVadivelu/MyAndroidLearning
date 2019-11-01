package com.example.myandroidlearning.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.myandroidlearning.R;

public class ValidationActivity extends AppCompatActivity {
    boolean editTextFlag=false;
    boolean editText2Flage=false;
    boolean radioButtonFlag=false;
    boolean spinnerflag=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);


    }



void checkValidity(){
System.out.println("in validation======================");
    EditText editText1=(EditText) findViewById(R.id.fname);



    EditText editText2=(EditText) findViewById(R.id.lname);

    RadioGroup radioGroup=(RadioGroup) findViewById(R.id.gender);
    RadioButton radioButton=(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
     Spinner spinner = (Spinner) findViewById(R.id.spinner);

    Button btn= (Button) findViewById(R.id.button) ;
    String spinnerText=spinner.getSelectedItem().toString();
    if(spinnerText.equalsIgnoreCase("choose country")){
        spinnerText="";
    }



        if (!editText1.getText().toString().equalsIgnoreCase("") ) {
            editTextFlag=true;
        }else
            editTextFlag=false;

        if(!editText2.getText().toString().equalsIgnoreCase("")) {
            editText2Flage = true;
        }else
            editText2Flage=false;
        if(radioButton!=null){
        if( !radioButton.getText().toString().equalsIgnoreCase("") ) {
            radioButtonFlag=true;
        }}else
            radioButtonFlag=false;
        if(!spinnerText.equalsIgnoreCase("")) {
            spinnerflag=true;
        }else
            spinnerflag=false;


  if(editText2Flage && editTextFlag && radioButtonFlag && spinnerflag) {
      System.out.println("inside if---------");
      btn.setEnabled(true);
      btn.setBackgroundColor(Color.rgb(23, 57, 133));
      btn.setTextColor(Color.rgb(242, 244, 247));


  }else{
      System.out.println("inside else---------");
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.rgb(242, 244, 247));
        btn.setTextColor(Color.rgb(187, 190, 199));
    }

}


}
