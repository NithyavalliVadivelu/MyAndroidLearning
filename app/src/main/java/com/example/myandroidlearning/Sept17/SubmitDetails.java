package com.example.myandroidlearning.Sept17;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidlearning.R;

public class SubmitDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_details);
        Intent intent=getIntent();
        System.out.println(intent.getStringExtra("FirstName"));
        System.out.println("-----------------------"+intent.getStringExtra("LastName")); System.out.println(intent.getStringExtra("Gender"));
        TextView fName = (TextView) findViewById(R.id.Fname);
        fName.setText(intent.getStringExtra("FirstName").toString());
        TextView lName=(TextView) findViewById(R.id.Lname);
        lName.setText(intent.getStringExtra("LastName").toString());
        TextView gender=(TextView) findViewById(R.id.Gender);




        gender.setText(intent.getStringExtra("Gender"));
        TextView country=(TextView) findViewById(R.id.Country);
        country.setText(intent.getStringExtra("Country"));

    }
}
