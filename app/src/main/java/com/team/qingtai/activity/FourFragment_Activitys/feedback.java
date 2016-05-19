package com.team.qingtai.activity.FourFragment_Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.team.qingtai.R;
import com.team.qingtai.base.BaseActivity;

public class feedback extends BaseActivity {
    private TextView title, edit;
    private RelativeLayout back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initViews();
        setListener();
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("意见反馈");
        edit = (TextView) findViewById(R.id.addinformationset);
        edit.setVisibility(View.GONE);
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
