package com.team.qingtai.activity.Twofragment_Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

/**
 * Created by ymh on 2016/4/12.
 */
public class fortest extends Activity implements OnClickListener {
    private LinearLayout v1, v2, v3, v4, v5, v6;
    private RelativeLayout rl;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knowtest2);
        MyApplication.getInstance().addActivity(this);
        v1 = (LinearLayout) findViewById(R.id.knowsale1);
        v2 = (LinearLayout) findViewById(R.id.knowsale2);
        v3 = (LinearLayout) findViewById(R.id.knowsale3);
        v4 = (LinearLayout) findViewById(R.id.knowsale4);
        v5 = (LinearLayout) findViewById(R.id.knowsale5);
        v6 = (LinearLayout) findViewById(R.id.knowsale6);
        title = (TextView) findViewById(R.id.addinformationtitle);
        rl = (RelativeLayout) findViewById(R.id.addinformationback);

        title.setText("贴心暖宝");
        rl.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });


        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);
        v4.setOnClickListener(this);
        v5.setOnClickListener(this);
        v6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(fortest.this, nuannanplan2.class);
        switch (v.getId()) {
            case R.id.knowsale1:
                intent.putExtra("num", 1);
                break;
            case R.id.knowsale2:
                intent.putExtra("num", 2);
                break;
            case R.id.knowsale3:
                intent.putExtra("num", 3);
                break;
            case R.id.knowsale4:
                intent.putExtra("num", 4);
                break;
            case R.id.knowsale5:
                intent.putExtra("num", 5);
                break;
            case R.id.knowsale6:
                intent.putExtra("num", 6);
                break;
        }
        startActivity(intent);
    }
}
