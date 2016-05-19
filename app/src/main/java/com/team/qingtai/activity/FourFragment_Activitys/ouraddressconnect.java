package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.base.BaseActivity;

public class ouraddressconnect extends BaseActivity {
    private TextView title, edit;
    private RelativeLayout back;
    private TextView nickname;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ouraddressconnect);
        initViews();
        setListener();
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setVisibility(View.GONE);
        edit = (TextView) findViewById(R.id.addinformationset);
        edit.setVisibility(View.GONE);
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        iv = (ImageView) findViewById(R.id.ouraddress);
        nickname = (TextView) findViewById(R.id.ouraddressnickname);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        if (name.equals("微信")) {
            nickname.setText("我们的微信公共主页：青苔有话聊");
            iv.setImageResource(R.drawable.weixinerweima);
        } else {
            nickname.setText("我们的微博：青苔官方微博");
            iv.setImageResource(R.drawable.weixinerweima);
        }
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
