package com.example.androidvolley;

import android.app.Application;

import com.example.androidvolley.data.RequestManager;

/**
 * Created by Jun on 2015/2/9.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        RequestManager.init(this);
    }
}
