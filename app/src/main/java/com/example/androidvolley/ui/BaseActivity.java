package com.example.androidvolley.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.androidvolley.data.RequestManager;

/**
 * Created by Jun on 2015/2/9.
 */
public class BaseActivity extends Activity {
    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
    }

    @Override
    protected void onStop() {
        super.onStop();

        RequestManager.cancelAll(this);
    }

    protected void executeRequest(Request<?> request){
        RequestManager.addRequest(request,this);
    }

    protected Response.ErrorListener errorListener(){
        return  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(activity,volleyError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        };
    }
}
