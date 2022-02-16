package com.example.wifiswitch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.codepath.asynchttpclient.RequestParams;



public class Fragment_Switch extends Fragment {

    int position;

    public Fragment_Switch(int pos) {
        position = pos;
    }

    //private int pos;

    Button btn;
    String strResponseHtml = "";
    boolean bResponseRcvd = false;
    MainActivity mainActivity = (MainActivity) getActivity();
    int fragmentID = 0;
    int buttonID = 0;
    SwipeRefreshLayout swipeRefreshLayout;
    String strOnResumeState;


    @SuppressLint("NonConstantResourceId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("Utkarsh_Fragment_Switch", "onCreateView: start");

        // Inflate the layout for this fragment

        switch (position) {
            case 0:
                fragmentID = R.layout.fragment_fragment1;
                buttonID = R.id.button_switch1;
                break;
            case 1:
                fragmentID = R.layout.fragment_fragment2;
                buttonID = R.id.button_switch2;
                break;
            case 2:
                fragmentID = R.layout.fragment_fragment3;
                buttonID = R.id.button_switch3;
                break;
            case 3:
                fragmentID = R.layout.fragment_fragment4;
                buttonID = R.id.button_setTime;
                break;
        }
        Log.d("Utkarsh_Fragment_Switch", "onCreate: fragmentID = " + fragmentID);
        Log.d("Utkarsh_Fragment_Switch", "onCreate: buttonID = " + buttonID);
        View view = inflater.inflate(fragmentID, container, false);


        swipeRefreshLayout=view.findViewById(R.id.SwipeRefresh1);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            Toast.makeText(getContext(),"Refresh",Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
        });

        btn = view.findViewById(buttonID);


        //ViewPager viewPager = findViewById(R.id.viewpager);
        btn.setOnClickListener(v -> {
            Log.v("Utkarsh_Fragment_Switch", "onClick: Start ");
            //Toast.makeText(getContext(),"Test on",Toast.LENGTH_SHORT).show();

            switch (v.getId()){
                case R.id.button_switch1:
                    if (MainActivity.bSwitch1) {
                        Log.v("Utkarsh_Fragment_Switch", "buttonClick 3: Switch 1 off");
                        String retValue = SendRequestToServer("http://192.168.2.189/1/on");
                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 4: retValue:" + retValue);
                        MainActivity.bSwitch1 = false;
                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 6: bSwitch1:" + MainActivity.bSwitch1);
                        Toast.makeText(getContext(),"Switch 1 is off",Toast.LENGTH_SHORT).show();
                    } else {
                        Log.v("Utkarsh_Fragment_Switch", "buttonClick 7: Switch 1 on");
                        String retValue = SendRequestToServer("http://192.168.2.189/1/off");
                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 8: retValue:" + retValue);
                        MainActivity.bSwitch1 = true;
                        //Log.d("Utkarsh_Fragment_Switch", "buttonClick 9:" + getState(retValue, "Plug 1 is ", 2));
                        Toast.makeText(getContext(),"Switch 1 is on",Toast.LENGTH_SHORT).show();

                    }
                    break;
                case R.id.button_switch2:
                    if (MainActivity.bSwitch2) {
                        Log.v("Utkarsh_Fragment_Switch", "buttonClick 3: Switch 2 off");
                        String retValue = SendRequestToServer("http://192.168.2.189/2/on");

                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 4: retValue:" + retValue);

                        MainActivity.bSwitch2 = false;
                        //Log.d("Utkarsh_Fragment_Switch", "buttonClick 5:" + getState(retValue, "Plug 1 is ", 2));
                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 6: bSwitch2:" + MainActivity.bSwitch2);
                        Toast.makeText(getContext(),"Switch 2 is off",Toast.LENGTH_SHORT).show();

                    } else {
                        Log.v("Utkarsh_Fragment_Switch", "buttonClick 7: Switch 2 on");
                        String retValue = SendRequestToServer("http://192.168.2.189/2/off");
                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 8: retValue:" + retValue);
                        MainActivity.bSwitch2 = true;
                        //Log.d("Utkarsh_Fragment_Switch", "buttonClick 9:" + getState(retValue, "Plug 1 is ", 2));
                        Toast.makeText(getContext(),"Switch 2 is on",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.button_switch3:
                    if (MainActivity.bSwitch3) {
                        Log.v("Utkarsh_Fragment_Switch", "buttonClick 3: Switch 3 off");
                        String retValue = SendRequestToServer("http://192.168.2.189/3/on");

                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 4: retValue:" + retValue);

                        MainActivity.bSwitch3 = false;
                        //Log.d("Utkarsh_Fragment_Switch", "buttonClick 5:" + getState(retValue, "Plug 1 is ", 2));
                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 6: bSwitch3:" + MainActivity.bSwitch3);
                        Toast.makeText(getContext(),"Switch 3 is off",Toast.LENGTH_SHORT).show();
                    } else {
                        Log.v("Utkarsh_Fragment_Switch", "buttonClick 7: Switch 3 on");
                        String retValue = SendRequestToServer("http://192.168.2.189/3/off");
                        Log.d("Utkarsh_Fragment_Switch", "buttonClick 8: retValue:" + retValue);
                        MainActivity.bSwitch3 = true;
                        //Log.d("Utkarsh_Fragment_Switch", "buttonClick 9:" + getState(retValue, "Plug 1 is ", 2));
                        Toast.makeText(getContext(),"Switch 3" +
                                " is on",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        });

        //viewPager = (ViewPager) view.findViewById(R.id.viewpager);



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("Utkarsh_Fragment_Switch", "onResume start");
        String state = "";
        if(!MainActivity.bFragment_SwitchStart) {
            state = SendRequestToServer("http://192.168.2.189");
        }
        if(bResponseRcvd) {
            Log.v("Utkarsh_Fragment_Switch", "onResume responsercvd start");
            state = getState(strOnResumeState, "Plug 1 is ", 2);
            if (getState(strOnResumeState, "Plug 1 is ", 2).equals("of")){
                MainActivity.bSwitch1 = false;
            }
            if (getState(strOnResumeState, "Plug 2 is ", 2).equals("of")){
                MainActivity.bSwitch2 = false;
            }
            if (getState(strOnResumeState, "Plug 3 is ", 2).equals("of")){
                MainActivity.bSwitch3 = false;
            }
            MainActivity.bFragment_SwitchStart = true;
            /*MainActivity.dStartHour = getState(strOnResumeState, "The current starting time is ", 2);
            MainActivity.dStartMinute = getState1(strOnResumeState, "The current starting time is ", 2);
            MainActivity.dEndHour = getState(strOnResumeState, "The current Ending time is :", 2);
            MainActivity.dEndMinute = getState1(strOnResumeState, "The current Ending time is :", 2);*/

            Log.d("Utkarsh_Fragment_Switch", "onResume start_time: " + MainActivity.startHour + ":" + MainActivity.startMinute);

            Log.d("Utkarsh_Fragment_Switch", "onResume end_time: " + MainActivity.endHour + ":" + MainActivity.endMinute);
        }
        Log.d("Utkarsh_Fragment_Switch", "onResume: stateSwitch1 = " + state);
        if(buttonID == R.id.button_switch1){
            if(!MainActivity.bSwitch1){
                changeText("Turn on");
            } else {
                changeText("Turn off");
            }
        } if(buttonID == R.id.button_switch2){
            if(!MainActivity.bSwitch2){
                changeText("Turn on");
            } else {
                changeText("Turn off");
            }
        } if(buttonID == R.id.button_switch3){
            if(!MainActivity.bSwitch3){
                changeText("Turn on");
            } else {
                changeText("Turn off");
            }
        }

    }
    public void changeText(String strText){
        String strSetText = strText;
        if(strText.equals("of")){
            strText = "on";
            strSetText = "Turn " + strText;
        } else if (strText.equals("on")){
            strText = "off";
            strSetText = "Turn " + strText;
        }
        Log.d("Utkarsh_Fragment_Switch", "changeText: " + strSetText );
        btn.setText(strSetText);
        //remoteViews.setTextViewText(R.id.button_switch1, "Set button text here");
    }

    public String SendRequestToServer(String url) {
        //final TextView textView = (TextView) activity.findViewById(R.id.textView);
        strResponseHtml ="";
        Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer 1: start url:" + url );

        // Instantiate the RequestQueue.
        RequestParams params = new RequestParams();
        params.put("key", "value");
        params.put("more", "data");

        bResponseRcvd = false;
        /*client.get(url, params, new TextHttpResponseHandler() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onSuccess(int statusCode, Headers headers, String response) {
                strResponseHtml = response;
                strOnResumeState = response;
                Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer AsyncHttpClient success");
                //Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer strResponseHtml:" + strResponseHtml);
                bResponseRcvd = true;
                String strSearch = "";
                boolean Switch1;
                boolean Switch2;
                boolean Switch3;
                switch (buttonID) {
                    case R.id.button_switch1:
                        strSearch = "Plug 1 is ";
                        changeText(getState(strResponseHtml, strSearch, 2));
                    break;
                    case R.id.button_switch2:
                        strSearch = "Plug 2 is ";
                        changeText(getState(strResponseHtml, strSearch, 2));
                        break;
                    case R.id.button_switch3:
                        strSearch = "Plug 3 is ";
                        changeText(getState(strResponseHtml, strSearch, 2));
                        break;
                }

                Switch1 = isOn(getState(strResponseHtml, "Plug 1 is ", 2));
                Switch2 = isOn(getState(strResponseHtml, "Plug 2 is ", 2));
                Switch3 = isOn(getState(strResponseHtml, "Plug 3 is ", 2));

                MainActivity.bSwitch1 = Switch1;
                MainActivity.bSwitch2 = Switch2;
                MainActivity.bSwitch3 = Switch3;

                MainActivity.startHour = getState(strOnResumeState, "The current starting time is ", 2);
                MainActivity.startMinute = getState1(strOnResumeState, "The current starting time is ", 2);
                MainActivity.endHour = getState(strOnResumeState, "The current Ending time is :", 2);
                MainActivity.endMinute = getState1(strOnResumeState, "The current Ending time is :", 2);


                //ParseHtml(strResponseHtml);
            }

            @Override
            public void onFailure(int statusCode, @Nullable Headers headers, String errorResponse, @Nullable Throwable throwable) {
                Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer AsyncHttpClient failure");
                bResponseRcvd = true;
                //changeText("Test failure");
            }
        });*/


        RequestQueue queue = Volley.newRequestQueue(requireContext());

// Request a string response from the provided URL.
        @SuppressLint("NonConstantResourceId") StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                this::onResponse, error -> {
                    Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer AsyncHttpClient failure");
                    bResponseRcvd = true;
                    Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer AsyncHttpClient failure: " + error.toString());
                    changeText("Test failure");
                });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


        //Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer strResponseHtml:" + strResponseHtml);
        Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer end");
        return strResponseHtml;
    }

    public String getState (String strHTML, String strSearch, int iLength) {
        //String strHTML = espConnection.SendRequestToServer(url);
        int iStartIndex = strHTML.indexOf(strSearch) + strSearch.length();
        if(iStartIndex >= 0)
            return strHTML.substring(iStartIndex, iStartIndex + iLength);
        else
            return "Not found: " + strSearch;
    }

    /*public void getPos(int pos){
        Log.d("Utkarsh_Fragment_Switch", "getPos " + pos);
    }*/
    Boolean isOn(String strCheck){
        boolean bIsOn = true;
        if(strCheck.equals("on")){
            bIsOn = true;
        } else if(strCheck.equals("of")){
            bIsOn = false;
        }
        return bIsOn;
    }

    public String getState1 (String strHTML, String strSearch, int iLength) {
        //String strHTML = espConnection.SendRequestToServer(url);
        int iStartIndex = strHTML.indexOf(strSearch) + strSearch.length() + 3;
        if(iStartIndex >= 0)
            return strHTML.substring(iStartIndex, iStartIndex + iLength);
        else
            return "Not found: " + strSearch;
    }


    @SuppressLint("NonConstantResourceId")
    private void onResponse(String response) {
// Display the first 500 characters of the response string.
        strResponseHtml = response;
        strOnResumeState = response;
        Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer AsyncHttpClient success");
//Log.d("Utkarsh_Fragment_Switch", "sendRequestToServer strResponseHtml:" + strResponseHtml);
        bResponseRcvd = true;
        String strSearch = "";
        boolean Switch1;
        boolean Switch2;
        boolean Switch3;
        switch (buttonID) {
            case R.id.button_switch1:
                strSearch = "Plug 1 is ";
                changeText(getState(strResponseHtml, strSearch, 2));
                break;
            case R.id.button_switch2:
                strSearch = "Plug 2 is ";
                changeText(getState(strResponseHtml, strSearch, 2));
                break;
            case R.id.button_switch3:
                strSearch = "Plug 3 is ";
                changeText(getState(strResponseHtml, strSearch, 2));
                break;
        }

        Switch1 = isOn(getState(strResponseHtml, "Plug 1 is ", 2));
        Switch2 = isOn(getState(strResponseHtml, "Plug 2 is ", 2));
        Switch3 = isOn(getState(strResponseHtml, "Plug 3 is ", 2));

        MainActivity.bSwitch1 = Switch1;
        MainActivity.bSwitch2 = Switch2;
        MainActivity.bSwitch3 = Switch3;

        MainActivity.dStartHour = getState(strOnResumeState, "The current starting time is ", 2);
        MainActivity.dStartMinute = getState1(strOnResumeState, "The current starting time is ", 2);
        MainActivity.dEndHour = getState(strOnResumeState, "The current Ending time is :", 2);
        MainActivity.dEndMinute = getState1(strOnResumeState, "The current Ending time is :", 2);

        Log.d("Utkarsh_Fragment_Switch", "SendRequestToServer: http://192.168.2.189/1/" + "?startHour=" + MainActivity.dStartHour + "&startMinute=" + MainActivity.dStartMinute + "&endHour=" + MainActivity.dEndHour + "&endMinute=" + MainActivity.dEndMinute);

    }
}