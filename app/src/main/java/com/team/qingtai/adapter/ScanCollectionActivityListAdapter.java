package com.team.qingtai.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ymh on 2016/5/19.
 */
public class ScanCollectionActivityListAdapter extends BaseAdapter {
    private Activity activity;
    private List<String> list;

    public ScanCollectionActivityListAdapter(Activity activity, List<String> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list.size() > 0) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list.size() > 0)
            return list.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}
