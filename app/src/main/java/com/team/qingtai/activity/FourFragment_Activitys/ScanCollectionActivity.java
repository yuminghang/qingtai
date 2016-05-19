package com.team.qingtai.activity.FourFragment_Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team.qingtai.R;
import com.team.qingtai.adapter.ScanCollectionActivityListAdapter;
import com.team.qingtai.adapter.ScanCollectionActivity_gridViewAdapter;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;
import com.team.qingtai.bean.CollectionBean;
import com.team.qingtai.view.MyGridView;

import java.util.ArrayList;

public class ScanCollectionActivity extends BaseActivity {

    private ListView listView;
    private ImageView avatar;
    private MyGridView gridview;
    private TextView name, time, content;
    private CollectionBean.DataEntity data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_collection);
        Intent intent = this.getIntent();
        data = (CollectionBean.DataEntity) intent.getSerializableExtra("pos");
        initView();
    }

    private View loadHeadView() {
        View view = View.inflate(this, R.layout.scan_blog_head, null);
        avatar = (ImageView) view.findViewById(R.id.avatar);
        name = (TextView) view.findViewById(R.id.name);
        time = (TextView) view.findViewById(R.id.time);
        content = (TextView) view.findViewById(R.id.content);
        gridview = (MyGridView) view.findViewById(R.id.gridview);
        Glide.with(this).load(Urls.SmallImageUrl + data.getOwner_avatar()).into(avatar);
        name.setText(data.getOwner_nickname());
        time.setText(data.getCreate_time());
        content.setText(data.getContents());
        if (data.getPic().size() > 0) {
            ScanCollectionActivity_gridViewAdapter adapter = new ScanCollectionActivity_gridViewAdapter(this, data.getPic());
            gridview.setAdapter(adapter);
        }
        return view;
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        listView.addHeaderView(loadHeadView());
        listView.setAdapter(new ScanCollectionActivityListAdapter(this,new ArrayList<String>(){}));
    }
}
