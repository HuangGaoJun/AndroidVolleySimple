package com.example.androidvolley.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidvolley.Api.VolleyApi;
import com.example.androidvolley.R;

import org.json.JSONObject;

/**
 * Created by Jun on 2015/2/9.
 */
public class JsonRequestActivity extends BaseActivity {

    private TextView mTvReuslt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_request);

        mTvReuslt = (TextView)findViewById(R.id.tv_result);

        Button btnResult = (Button)findViewById(R.id.btn_json_request);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeRequest(new JsonObjectRequest(Request.Method.GET, VolleyApi.JSON_TEST,null,
                       responseListener(),errorListener()));
            }
        });
    }

    private Response.Listener<JSONObject> responseListener(){
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
               // mTvReuslt.setText(jsonObject.toString());
                Log.d("TAG",jsonObject.toString());
            }
        };
    }
}
