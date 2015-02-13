package com.example.androidvolley.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.example.androidvolley.Api.VolleyApi;
import com.example.androidvolley.R;
import com.example.androidvolley.data.GsonRequest;
import com.example.androidvolley.model.MyClass;
import com.google.gson.Gson;


/**
 * Created by Jun on 2015/2/9.
 */
public class GsonRequestActivity extends BaseActivity {

    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_request);

        mTvResult = (TextView) findViewById(R.id.tv_result);

        Button btnRequest = (Button) findViewById(R.id.btn_gson_request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   executeRequest(new GsonRequest<MyClass>(VolleyApi.GSON_TEST,MyClass.class,
                          responseListener(),errorListener() ));
            }
        });
    }

    private Response.Listener<MyClass> responseListener(){
        return new Response.Listener<MyClass>(){

            @Override
            public void onResponse(MyClass myClass) {
                mTvResult.setText(new Gson().toJson(myClass));
            }
        };
    }
}
