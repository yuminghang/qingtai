package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.base.BaseActivity;

public class guanyuapp extends BaseActivity implements View.OnClickListener {
    private TextView title, edit;
    private RelativeLayout back;
    private RelativeLayout xieyi, weixin, weibo, pingfen, versionupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanyuapp);
        initViews();
        setListener();
    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        xieyi.setOnClickListener(this);
        weixin.setOnClickListener(this);
        weibo.setOnClickListener(this);
        pingfen.setOnClickListener(this);
        versionupdate.setOnClickListener(this);
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("关于青苔");
        edit = (TextView) findViewById(R.id.addinformationset);
        edit.setVisibility(View.GONE);
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        xieyi = (RelativeLayout) findViewById(R.id.userxieyi);
        weixin = (RelativeLayout) findViewById(R.id.ourweixin);
        weibo = (RelativeLayout) findViewById(R.id.ourweibo);
        pingfen = (RelativeLayout) findViewById(R.id.guanyupingfen);
        versionupdate = (RelativeLayout) findViewById(R.id.versionupdate);

    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        Intent in1 = new Intent(guanyuapp.this, ouraddressconnect.class);
        switch (v.getId()) {
            case R.id.userxieyi:
                startActivity(new Intent(guanyuapp.this, userxieyi.class));
                break;
            case R.id.guanyupingfen:
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.ourweixin:
                in1.putExtra("name", "微博");
                startActivity(in1);
                break;
            case R.id.ourweibo:
                in1.putExtra("name", "微信");
                startActivity(in1);
                break;
            case R.id.versionupdate:
//                new checkNewestVersionAsyncTask().execute();
                break;
            default:
                break;
        }
    }
}
