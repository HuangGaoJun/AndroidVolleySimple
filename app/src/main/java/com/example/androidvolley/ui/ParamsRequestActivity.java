package com.example.androidvolley.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.androidvolley.Api.VolleyApi;
import com.example.androidvolley.R;
import com.example.androidvolley.data.ApiParams;

import java.util.Map;

/**
 * Created by Jun on 2015/2/9.
 */
public class ParamsRequestActivity extends BaseActivity {

    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param_request);

        mTvResult = (TextView) findViewById(R.id.tv_result);

        Button btnResult = (Button)findViewById(R.id.btn_params_request);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeRequest(new StringRequest(Request.Method.POST, VolleyApi.POST_TEST,
                        responseListener(),errorListener()){
                    protected Map<String,String> getParams(){
                        return new ApiParams().with("param1","01").with("param2","02");
                    }
                });
            }
        });
    }

    private Response.Listener<String> responseListener(){
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                mTvResult.setText(s);
                Log.i("TAGParams",s);
            }
        };
    }
}
