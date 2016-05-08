package com.team.qingtai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.team.qingtai.R;
import com.team.qingtai.activity.ThreeFragment_Activitys.ArticleActivity;

public class ThreeFragment extends Fragment implements View.OnClickListener {

    LinearLayout community_top_aiqing, community_top_yima, community_top_xingge;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.threefragment_layout, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        community_top_aiqing = (LinearLayout) view.findViewById(R.id.community_top_aiqing);
        community_top_yima = (LinearLayout) view.findViewById(R.id.community_top_yima);
        community_top_xingge = (LinearLayout) view.findViewById(R.id.community_top_xingge);
        community_top_aiqing.setOnClickListener(this);
        community_top_yima.setOnClickListener(this);
        community_top_xingge.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.community_top_aiqing:
                Intent intent = new Intent(getActivity(), ArticleActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
                break;
            case R.id.community_top_yima:
                Intent intent2 = new Intent(getActivity(), ArticleActivity.class);
                intent2.putExtra("type", 2);
                startActivity(intent2);
                break;
            case R.id.community_top_xingge:
                Intent intent3 = new Intent(getActivity(), ArticleActivity.class);
                intent3.putExtra("type", 3);
                startActivity(intent3);
                break;
        }
    }
}