package com.example.myandroidlearning.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.databinding.ActivityMain7Binding;
import com.example.myandroidlearning.util.SharedPrefUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myandroidlearning.ui.main.SectionsPagerAdapter;

import static com.example.myandroidlearning.util.ResourceUtil.context;

public class Main7Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Toolbar toolBar=findViewById(R.id.appBarLayout);
        toolBar.getOverflowIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        setSupportActionBar(toolBar);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        final ViewPager mviewPager = findViewById(R.id.view_pager);
        mviewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mviewPager);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        getSupportActionBar().setTitle("Hello "+name+" !!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            SharedPrefUtils utils=new SharedPrefUtils();
            utils.clearSharedPreference("LogIn");
            Intent intent= new Intent(this,LoginActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void goLogout(View view){
        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog=new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Do you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    //    Main7Activity.super.onBackPressed();


                        Main7Activity.super.finish();
                        finishAffinity();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}