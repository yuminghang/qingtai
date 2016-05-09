package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

public class GuanLianTa extends Activity {
    private TextView title, edit;
    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guan_lian_ta);
        MyApplication.getInstance().addActivity(this);
        Fresco.initialize(this);
        initViews();
        setListener();
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("关联ta");
        edit = (TextView) findViewById(R.id.addinformationset);
        edit.setText("扫一扫");
        back = (RelativeLayout) findViewById(R.id.addinformationback);
    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }


}
