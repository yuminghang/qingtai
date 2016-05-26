package com.team.qingtai.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team.qingtai.R;
import com.team.qingtai.api.Urls;
import com.team.qingtai.bean.MyHomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymh on 2016/5/26.
 */
public class MyHomePageActivity_ListAdapter extends BaseAdapter {
    private Activity activity;
    private List<MyHomePageBean.DataEntity> list = new ArrayList<>();

    public MyHomePageActivity_ListAdapter(Activity activity, List<MyHomePageBean.DataEntity> list) {
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
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = View.inflate(activity, R.layout.blog_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            viewHolder.sex_image = (ImageView) convertView.findViewById(R.id.sex_image);
            viewHolder.nickname = (TextView) convertView.findViewById(R.id.nickname);
            viewHolder.blog_content = (TextView) convertView.findViewById(R.id.blog_content);
            viewHolder.data_time = (TextView) convertView.findViewById(R.id.data_time);
            viewHolder.scan_num = (TextView) convertView.findViewById(R.id.scan_num);
            viewHolder.comment_num = (TextView) convertView.findViewById(R.id.comment_num);
            viewHolder.excellent_num = (TextView) convertView.findViewById(R.id.excellent_num);
            viewHolder.gridview = (GridView) convertView.findViewById(R.id.gridview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.data_time.setText(list.get(position).getCreate_time());
        viewHolder.nickname.setText(list.get(position).getOwner_nickname());
        viewHolder.scan_num.setText(list.get(position).getVisit_num() + "");
        viewHolder.comment_num.setText(list.get(position).getNum_comments() + "");
        viewHolder.excellent_num.setText(list.get(position).getNum_favorite() + "");
        if (!list.get(position).getContents().equals("NULL")) {
            viewHolder.blog_content.setText(list.get(position).getContents());
        }
        Glide.with(activity).load(Urls.SmallImageUrl + list.get(position).getOwner_avatar()).into(viewHolder.avatar);
        if (list.get(position).getOwner_gender() == 0) {
            viewHolder.sex_image.setImageResource(R.drawable.community_boy);
        } else {
            viewHolder.sex_image.setImageResource(R.drawable.community_girl);
        }
        return convertView;
    }

    class ViewHolder {
        GridView gridview;
        ImageView avatar, sex_image;
        TextView data_time, nickname, blog_content, scan_num, comment_num, excellent_num;

        public ViewHolder() {
        }
    }
}
