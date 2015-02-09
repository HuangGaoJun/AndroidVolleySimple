package com.example.androidvolley.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.androidvolley.R;
import com.example.androidvolley.model.ActivityInfo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jun on 2015/2/9.
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    private List<ActivityInfo> mData = Arrays.asList(
            new ActivityInfo("SimpleRequest",SimpleRequetActivity.class),
            new ActivityInfo("JsonRequest", JsonRequestActivity.class),
            new ActivityInfo("PostParamsRequest", ParamsRequestActivity.class),
            new ActivityInfo("GsonRequest", GsonRequestActivity.class),
            new ActivityInfo("ImageLoading", ImageLoadingActivity.class)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<ActivityInfo>(this,
                android.R.layout.simple_list_item_1,mData));

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(activity,mData.get(position).name);
        startActivity(intent);
    }
}
