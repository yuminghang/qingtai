package com.team.qingtai.activity.ThreeFragment_Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        MyApplication.getInstance().addActivity(this);

    }
}
