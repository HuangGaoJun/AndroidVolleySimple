package com.example.androidvolley.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.androidvolley.Api.VolleyApi;
import com.example.androidvolley.R;


/**
 * Created by Jun on 2015/2/9.
 */
public class SimpleRequetActivity extends BaseActivity {
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_request);

        Button btnRequest = (Button)findViewById(R.id.btn_simple_request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeRequest(new StringRequest(Request.Method.GET, VolleyApi.BAIDU,
                        responseListener(),errorListener()));
            }
        });
    }

    private Response.Listener<String> responseListener(){
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                mTvResult.setText(s);
            }
        };
    }
}
