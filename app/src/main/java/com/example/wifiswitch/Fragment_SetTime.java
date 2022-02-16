package com.example.wifiswitch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class Fragment_SetTime extends Fragment_Switch {

    TextView currentSelectedTextView;
    Set_Time_Pop_Up set_time_pop_up = new Set_Time_Pop_Up();
    TextView starting_timeTV;
    TextView starting_time;
    TextView ending_timeTV;
    TextView ending_time;

   public Fragment_SetTime(int pos) {
        super(pos);
    }

    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("Utkarsh_Fragment_SetTime", "onCreateView: start");

        Log.d("Utkarsh_Fragment_SetTime", "onCreateView: http://192.168.2.189/1/" + "?startHour=" + MainActivity.dStartHour + "&startMinute=" + MainActivity.startMinute + "&endHour=" + MainActivity.endHour + "&endMinute=" + MainActivity.endMinute);


        MainActivity.startHour = MainActivity.dStartHour;
        MainActivity.startMinute = MainActivity.dStartMinute;
        MainActivity.endHour = MainActivity.dEndHour;
        MainActivity.endMinute = MainActivity.dEndMinute;

        Log.d("Utkarsh_Fragment_SetTime", "onCreateView: http://192.168.2.189/1/" + "?startHour=" + MainActivity.startHour + "&startMinute=" + MainActivity.startMinute + "&endHour=" + MainActivity.endHour + "&endMinute=" + MainActivity.endMinute);


        //setText("hello");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);
        btn = view.findViewById(R.id.button_setTime);
        starting_timeTV = (TextView) view.findViewById(R.id.starting_timeTV);
        starting_time = (TextView) view.findViewById(R.id.starting_time);
        ending_timeTV = (TextView) view.findViewById(R.id.ending_timeTV);
        ending_time = (TextView) view.findViewById(R.id.ending_time);

        starting_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Utkarsh_Fragment_SetEndTime", "onClick: setStartTime= " + Set_Time_Pop_Up.setStartTime);
                Set_Time_Pop_Up.setStartTime = true;
                Log.v("Utkarsh_Fragment_SetEndTime", "onClick: setStartTime= " + Set_Time_Pop_Up.setStartTime);
                Intent i = new Intent(getContext(), Set_Time_Pop_Up.class);
                startActivity(i);
            }
        });



        ending_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Utkarsh_Fragment_SetEndTime", "onClick: setEndTime= " + Set_Time_Pop_Up.setEndTime);
                Set_Time_Pop_Up.setEndTime = true;
                Log.v("Utkarsh_Fragment_SetEndTime", "onClick: setEndTime= " + Set_Time_Pop_Up.setEndTime);
                Intent i = new Intent(getContext(), Set_Time_Pop_Up.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                Log.v("Utkarsh_Fragment_SetTime", "onClick: Start ");
                Toast.makeText(getContext(),"Time Set",Toast.LENGTH_SHORT).show();
                String randText = "off";
                if(!MainActivity.bSwitch1){
                    randText = "on";
                }
                Log.d("Utkarsh_Fragment_SetTime", "onClick: http://192.168.2.189/1/" + randText + "?startHour=" + MainActivity.startHour + "&startMinute=" + mainActivity.startMinute + "&endHour=" + MainActivity.endHour + "&endMinute=" + MainActivity.endMinute);
                SendRequestToServer("http://192.168.2.189/1/" + randText + "?startHour=" + MainActivity.startHour + "&startMinute=" + MainActivity.startMinute + "&endHour=" + MainActivity.endHour + "&endMinute=" + MainActivity.endMinute);
            }
        });



        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();
        Log.d("Utkarsh_Fragment_SetTime", "onResume: http://192.168.2.189/1/"  + "?startHour=" + MainActivity.startHour + "&startMinute=" + MainActivity.startMinute + "&endHour=" + MainActivity.endHour + "&endMinute=" + MainActivity.endMinute);
        starting_time.setText(MainActivity.startHour + ":" + MainActivity.startMinute);
        ending_time.setText(MainActivity.endHour + ":" + MainActivity.endMinute);
    }

    public void changeText(String strText){
    }
}
