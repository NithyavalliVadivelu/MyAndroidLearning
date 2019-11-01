package com.example.myandroidlearning.Sept19;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidlearning.R;

public class MainActivity extends AppCompatActivity {
    boolean editTextFlag=false;
    boolean editText2Flage=false;
    boolean radioButtonFlag=false;
    boolean spinnerflag=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);

        boolean textOnFocusFlag=false;
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
          Button btn= (Button) findViewById(R.id.button) ;
        btn.setBackgroundColor(Color.rgb(242, 244, 247));
        btn.setTextColor(Color.rgb(187, 190, 199));
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                      Intent intent=  new Intent(MainActivity.this, SubmitDetails.class);
                      EditText editText1=(EditText) findViewById(R.id.fname);

                      System.out.println("text is ============>"+editText1.getText());
                      intent.putExtra("FirstName",editText1.getText().toString());
                        EditText editText2=(EditText) findViewById(R.id.lname);
                      intent.putExtra("LastName",editText2.getText().toString());
                        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.gender);
                       RadioButton radioButton=(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                       if(radioButton!=null)
                       intent.putExtra("Gender",radioButton.getText());
                        System.out.println(spinner.getSelectedItem().toString());
                        String spinnerText=spinner.getSelectedItem().toString();
                        if(spinnerText.equalsIgnoreCase("choose country")){
                            spinnerText="";
                        }
                        intent.putExtra("Country",spinnerText);
                        startActivity(intent);
                        /*if(radioButton!=null){
                        if(!editText1.getText().toString().equalsIgnoreCase("") && !editText2.getText().toString().equalsIgnoreCase("") && !radioButton.getText().toString().equalsIgnoreCase("") && !spinnerText.equalsIgnoreCase("")){

                            Button btn= (Button) findViewById(R.id.button) ; btn.setEnabled(true);
                           btn.setBackgroundColor(Color.GREEN);

                        }}else{
                            AlertDialog.Builder adb = new AlertDialog.Builder(ValidationActivity.this);
                            //    adb.setView(alertDialogView);
                            adb.setTitle("Please give all the details");
                            adb.setIcon(android.R.drawable.ic_dialog_alert);
                            adb.show();
                        }*/

                    }
                }
        );

        System.out.println("=----------------------------in hmouse over");
        TextWatcher mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                checkValidity();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                checkValidity();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // check Fields For Empty Values
                checkValidity();
            }
        };
        EditText editText2=(EditText) findViewById(R.id.lname);
        editText2.addTextChangedListener(mTextWatcher);
        final EditText editText1=(EditText) findViewById(R.id.fname);
        editText1.addTextChangedListener(mTextWatcher);

        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.gender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                checkValidity();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                checkValidity();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                checkValidity();
            }
        });

        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog dialog=adb.create();
        editText1.setFocusable(true);
System.out.println("focus=========>"+(editText1.FOCUSABLE==View.FOCUSABLE));
        if(editText1.FOCUSABLE==View.FOCUSABLE){
        //   dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(editText1, InputMethodManager.SHOW_IMPLICIT);
          //  imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

         //   dialog.show();


        }

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText1, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        /*editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                    dialog.show();
                }
            }
        });

        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                    dialog.show();
                }
            }
        });*/




    btn.setOnHoverListener(new View.OnHoverListener() {
        @Override
        public boolean onHover(View view, MotionEvent motionEvent) {

            return true;
        }
    });

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
