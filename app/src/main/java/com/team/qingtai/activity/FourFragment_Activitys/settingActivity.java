package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class settingActivity extends BaseActivity {

    private TextView title, edit;
    private ListView lv1;
    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initViews();
        initListView();
        setListener();

    }

    private void initListView() {
        Map<String, String> lvmap = new HashMap<String, String>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        lvmap = new HashMap<String, String>();
        lvmap.put("nuanbao", "账号设置");
        list.add(lvmap);
        lvmap = new HashMap<String, String>();
        lvmap.put("nuanbao", "关于青苔");
        list.add(lvmap);
        lvmap = new HashMap<String, String>();
        lvmap.put("nuanbao", "意见反馈");
        list.add(lvmap);

        SimpleAdapter sim = new SimpleAdapter(settingActivity.this, list, R.layout.melistview, new String[]{"nuanbao"}, new int[]{R.id.melistviewname});
        lv1.setAdapter(sim);
        lv1.setDividerHeight(0);
    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                switch (position) {
                    case 0:
//                        startActivity(new Intent(settingActivity.this, accountsetting.class));
                        break;
                    case 1:
                        startActivity(new Intent(settingActivity.this, guanyuapp.class));
                        break;
                    case 2:
                        startActivity(new Intent(settingActivity.this, feedback.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("设置");
        edit = (TextView) findViewById(R.id.addinformationset);
        edit.setVisibility(View.GONE);
        back = (RelativeLayout) findViewById(R.id.addinformationback);

        lv1 = (ListView) findViewById(R.id.settingfirstlist);

    }
}
