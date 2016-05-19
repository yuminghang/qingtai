package com.team.qingtai.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.team.qingtai.R;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;

import java.util.List;

/**
 * Created by ymh on 2016/5/19.
 */
public class ScanCollectionActivity_gridViewAdapter extends BaseAdapter {
    private Activity activity;

    private List<String> list;

    public ScanCollectionActivity_gridViewAdapter(Activity activity, List<String> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(activity, R.layout.griditem, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        Glide.with(activity).load(Urls.SmallImageUrl + list.get(position)).into(imageView);
        return imageView;
    }
}
