package com.example.myandroidlearning;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.ui.main.SectionsPagerAdapter;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        final ViewPager mViewPager=findViewById(R.id.view_pager);

        // based on the current position you can then cast the page to the correct
        // class and call the method:\
        ((Button)findViewById(R.id.add_main)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.view_pager + ":" + mViewPager.getCurrentItem());
                int frag=mViewPager.getCurrentItem();

                switch (frag){
                    case 0 :
                        ((HelpFrag)page).updateData();
                    case 1:
                        ((EventFrag)page).updateData();
                    case 2:
                        ((InterestFrag)page).updateData();
                }
            }
        });
        ((Button)findViewById(R.id.save_main)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.view_pager + ":" + mViewPager.getCurrentItem());
                int frag=mViewPager.getCurrentItem();

                switch (frag){
                    case 0 :
                        ((HelpFrag)page).saveData();
                    case 1:
                        ((EventFrag)page).saveData();
                    case 2:
                        ((InterestFrag)page).saveData();
                }
            }
        });


    }
}