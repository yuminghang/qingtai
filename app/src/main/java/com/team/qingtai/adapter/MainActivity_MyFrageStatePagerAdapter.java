package com.team.qingtai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by ymh on 2016/4/11.
 */
//ViewPager适配器
public class MainActivity_MyFrageStatePagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragmentList;

    public MainActivity_MyFrageStatePagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return fragmentList.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragmentList.size();
    }
}

