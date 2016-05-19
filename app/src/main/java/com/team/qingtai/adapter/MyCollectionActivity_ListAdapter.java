package com.team.qingtai.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team.qingtai.R;
import com.team.qingtai.api.Urls;
import com.team.qingtai.bean.CollectionBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymh on 2016/5/19.
 */
public class MyCollectionActivity_ListAdapter extends BaseAdapter {
    private Activity activity;
    List<CollectionBean.DataEntity> list = new ArrayList<CollectionBean.DataEntity>();

    public MyCollectionActivity_ListAdapter(Activity activity, List<CollectionBean.DataEntity> list) {
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
        View view = View.inflate(activity, R.layout.mycollectionitem, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView time = (TextView) view.findViewById(R.id.time);
        TextView visit_num = (TextView) view.findViewById(R.id.visit_num);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        title.setText(list.get(position).getContents());
        time.setText(list.get(position).getCreate_time());
        visit_num.setText("" + list.get(position).getVisit_num());
        Glide.with(activity).load(Urls.SmallImageUrl + list.get(position).getOwner_avatar()).into(image);
        return view;
    }
}
