package com.example.androidvolley.model;

/**
 * Created by Jun on 2015/2/9.
 */
public class ActivityInfo {

    public String title;
    public Class<?> name;

    public ActivityInfo(String title, Class<?> name){
        this.title = title;
        this.name = name;
    }

    @Override
    public String toString() {
        return title;
    }
}
