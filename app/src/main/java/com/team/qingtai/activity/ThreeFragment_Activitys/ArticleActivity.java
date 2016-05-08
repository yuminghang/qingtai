package com.team.qingtai.activity.ThreeFragment_Activitys;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.adapter.MyRecyclerViewAdapter;
import com.team.qingtai.bean.jsonbean2;
import com.team.qingtai.cache.Datas;
import com.team.qingtai.view.DividerLine;

public class ArticleActivity extends Activity {

    private ImageView back;
    private RecyclerView mRecyclerView;
    public jsonbean2 datas;
    private LinearLayoutManager mLayoutManager;
    private MyRecyclerViewAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_article);
        MyApplication.getInstance().addActivity(this);

        initViews();
        initData();
    }

    private void initData() {
        Gson gson = new Gson();
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //动画特效
//        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
//        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
//        scaleInAnimationAdapter.setFirstOnly(false);
        //分隔线
        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
        dividerLine.setSize(3);
        dividerLine.setColor(0xFDDDDDDD);
        mRecyclerView.addItemDecoration(dividerLine);
        datas = (gson.fromJson(Datas.CACHE_URL, new TypeToken<jsonbean2>() {
        }.getType()));
        mAdapter = new MyRecyclerViewAdapter(this, datas);
//            AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
//            ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
//            scaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void initViews() {
        back = (ImageView) findViewById(R.id.activity_article_back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }
}
