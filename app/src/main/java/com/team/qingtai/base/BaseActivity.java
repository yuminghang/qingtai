package com.team.qingtai.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.team.qingtai.MyApplication;


public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyApplication.getInstance().addActivity(this);
    }
}
