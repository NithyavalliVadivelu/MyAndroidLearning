package com.example.myandroidlearning;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myandroidlearning.util.SharedPrefUtils;

public class SharedpreferenceActivity extends AppCompatActivity {
    public TextView text;
    public TextView showText;
    public Button saveButton;
    public Button showButton;
    public static String key="Text";
    final SharedPrefUtils utils=new SharedPrefUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference);
        text=findViewById(R.id.edit_text);
        showText=findViewById(R.id.show_view);
        saveButton=findViewById(R.id.save_button);
        showButton=findViewById(R.id.show_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();


            }

        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               readData();
            }
        });


    }

    public void saveData(){
        utils.setSharedPreferences(getApplicationContext());
        utils.addString(key,text.getText().toString());
        Toast.makeText(this,"Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void readData(){

      //  checkData();
        utils.setSharedPreferences(getApplicationContext());
        showText.setText(utils.getString(key));
    }
    public boolean checkData(){
        utils.setSharedPreferences(getApplicationContext());
        String checkdata=utils.getString(key);
        if(checkdata.equalsIgnoreCase("Sorry data not available"))
        return false;
        else
            return true;
    }

}
