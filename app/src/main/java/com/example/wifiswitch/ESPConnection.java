package com.example.wifiswitch;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler;

import java.util.concurrent.TimeUnit;

import okhttp3.Headers;

public class ESPConnection {

    public Activity activity;
    String strResponseHtml = "";
    String strButton1Text = "";
    boolean bResponseRcvd = false;

    public ESPConnection(Activity _activity){

        this.activity = _activity;
    }
    public String SendRequestToServer(String url) {
        //final TextView textView = (TextView) activity.findViewById(R.id.textView);
        strResponseHtml ="";
// ...
        Log.d("Utkarsh_ESPConnection", "sendRequestToServer 1: start url:" + url );

        // Instantiate the RequestQueue.
/*        RequestQueue queue = Volley.newRequestQueue(activity);
        //String url = "https://www.google.com";
        //String url = "http://192.168.2.189/2/on";

        Log.d("Utkarsh_ESPConnection", "sendRequestToServer 2");
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //textView.setText("Response is: " + response.substring(0, 500));
                        strResponseHtml = response;
                        Log.d("Utkarsh_ESPConnection", "sendRequestToServer 3: onResponse strResponseHtml: " + strResponseHtml);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
                strResponseHtml = "That didn't work!!";
                Log.d("Utkarsh_ESPConnection", "sendRequestToServer 4: onErrorResponse strResponseHtml: " + strResponseHtml);
            }
        });

        Log.d("Utkarsh_ESPConnection", "sendRequestToServer 5");

// Add the request to the RequestQueue.

        queue.add(stringRequest);
        queue.
*/
        RequestParams params = new RequestParams();
        params.put("key", "value");
        params.put("more", "data");

        AsyncHttpClient client = new AsyncHttpClient();
        bResponseRcvd = false;
        client.get(url, params, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, String response) {
                strResponseHtml = response;
                Log.d("Utkarsh_ESPConnection", "sendRequestToServer AsyncHttpClient success");
                Log.d("Utkarsh_ESPConnection", "sendRequestToServer strResponseHtml:" + strResponseHtml);
                bResponseRcvd = true;
                //ParseHtml(strResponseHtml);
            }

            @Override
            public void onFailure(int statusCode, @Nullable Headers headers, String errorResponse, @Nullable Throwable throwable) {
                Log.d("Utkarsh_ESPConnection", "sendRequestToServer AsyncHttpClient failure");
                bResponseRcvd = true;
            }
        });

        //Log.d("Utkarsh_ESPConnection", "sendRequestToServer strResponseHtml:" + strResponseHtml);
        //Log.d("Utkarsh_ESPConnection", "sendRequestToServer end");
        return strResponseHtml;
    }

    void ParseHtml(String strHtml){
/*        int iStartIndex = strResponseHtml.indexOf(strHtml) + strHtml.length();
        if(iStartIndex >= 0)
            strButton1Text = strResponseHtml.substring(iStartIndex, iStartIndex + iLength);
        else
            strButton1Text = "";
 */
    }

}


