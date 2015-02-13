package com.example.androidvolley.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.androidvolley.R;
import com.example.androidvolley.data.RequestManager;

/**
 * Created by Jun on 2015/2/9.
 */
public class ImageLoadingActivity extends BaseActivity {

    private NetworkImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loading);

        mImageView = (NetworkImageView)findViewById(R.id.iv_image);

        Button btnResult = (Button)findViewById(R.id.btn_image_requst);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoader imageLoader = RequestManager.getImageLoader();
                mImageView.
                        setImageUrl(
                        "http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg",
                        imageLoader);
            }
        });
    }
}
