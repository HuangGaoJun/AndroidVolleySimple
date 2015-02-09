package com.example.androidvolley.data;

import android.app.ActivityManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Jun on 2015/2/9.
 */
public class RequestManager {

    private static RequestQueue requestQueue;
    private static ImageLoader imageLoader;

    public static void init(Context context){

        //获取RequestQueue对象
        requestQueue = Volley.newRequestQueue(context);

        //对ImageLoader进行缓存
        int memClass = ((ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
        int cacheSize = 1024 * 1024 * memClass / 8 ;
        //获取ImageLoader并做缓存
        imageLoader = new ImageLoader(requestQueue,new BitmapLruCache(cacheSize));
    }

    public static RequestQueue getRequestQueue(){
        if(requestQueue != null){
            return requestQueue;
        }else{
            //如果获取不到RequestQueue对象，抛出自定义一个异常
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }

    //将Request添加到RequestQueue对象中
    public static void addRequest(Request<?> request,Object tag){
        if(tag != null){
            request.setTag(tag);
        }
        requestQueue.add(request);
    }

    public static void cancelAll(Object tag){
        requestQueue.cancelAll(tag);
    }

    public static ImageLoader getImageLoader(){
        if(imageLoader != null){
            return imageLoader;
        }else{
            //没有初始化ImageLoader，抛出异常
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }


}
