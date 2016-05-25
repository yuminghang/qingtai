package com.team.qingtai.activity.FourFragment_Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team.qingtai.R;
import com.team.qingtai.base.BaseActivity;

public class MyAccountSettingActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout changecode;
    private TextView title;
    private TextView addinformationset;
    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_setting);
        initView();
    }

    private void initView() {
        changecode = (RelativeLayout) findViewById(R.id.changecode);
        changecode.setOnClickListener(this);
        addinformationset = (TextView) findViewById(R.id.addinformationset);
        addinformationset.setVisibility(View.GONE);
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("账号设置");
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.changecode:
                startActivity(new Intent(MyAccountSettingActivity.this, ChangePasswordActivity.class));
                break;
            case R.id.addinformationback:
                finish();
                break;
            default:
                break;
        }
    }
}
