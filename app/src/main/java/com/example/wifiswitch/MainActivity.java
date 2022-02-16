package com.example.wifiswitch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    static boolean bSwitch1 = true;
    static boolean bSwitch2 = true;
    static boolean bSwitch3 = true;
    static boolean bFragment_SwitchStart = false;
    String retValue;
    ViewPager viewPager;
    static String startMinute = "";
    static String startHour = "";
    static String endHour = "";
    static String endMinute = "";
    static String dStartMinute = "";
    static String dStartHour = "";
    static String dEndHour = "";
    static String dEndMinute = "";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("Utkarsh_MainActivity", "onCreate 1: start");

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);


        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new Fragment_Switch(0), "Switch 1");
        vpAdapter.addFragment(new Fragment_Switch(1), "Switch 2");
        vpAdapter.addFragment(new Fragment_Switch(2), "Switch 3");
        vpAdapter.addFragment(new Fragment_SetTime(3), "Set time");
        viewPager.setAdapter(vpAdapter);
        tabLayout.setupWithViewPager(viewPager);

        int pos;
        pos = viewPager.getCurrentItem();
        Log.d("Utkarsh_MainActivity", "onCreate: position = " + pos);

        //((TextView) findViewById(R.id.textView)).setText("This is the default text: ");
    }


}