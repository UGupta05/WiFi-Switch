package com.example.wifiswitch;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.TimePicker;

public class Set_Time_Pop_Up extends Activity {

    static boolean setStartTime = false;
    static boolean setEndTime = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time_pop_up);

        TextView textView = findViewById(R.id.material_timepicker_ok_button);
        TimePicker timePicker = findViewById(R.id.timePicker);

        timePicker.setIs24HourView(true);

        textView.setOnClickListener(v -> {
            Log.v("Utkarsh_SetPopUp", "onClick: setStartTime= " + setStartTime);
            Log.v("Utkarsh_SetPopUp", "onClick: setEndTime= " + setEndTime);
            if(setStartTime) {
                MainActivity.startHour = isOneDigit(Integer.toString(timePicker.getHour()));
                MainActivity.startMinute = isOneDigit(Integer.toString(timePicker.getMinute()));
                Log.d("Utkarsh_PopUP", "onClick start_time: " + MainActivity.startHour + ":" + MainActivity.startMinute);
                setStartTime = false;
            } else if(setEndTime){
                MainActivity.endHour = isOneDigit(Integer.toString(timePicker.getHour()));
                MainActivity.endMinute = isOneDigit(Integer.toString(timePicker.getMinute()));
                Log.v("Utkarsh_PopUP", "onClick end_time: " + MainActivity.endHour + ":" + MainActivity.endMinute);
                setEndTime = false;
            }
            finish();
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

    }
    public String isOneDigit(String strStart){
        if(strStart.equals("0")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("1")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("2")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("3")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("4")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("5")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("6")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("7")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("8")){
            strStart = "0" + strStart;
        }
        if(strStart.equals("9")){
            strStart = "0" + strStart;
        }
        return strStart;
    }
}