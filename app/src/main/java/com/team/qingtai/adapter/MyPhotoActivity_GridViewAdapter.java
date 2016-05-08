package com.team.qingtai.adapter;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.lzy.imagepicker.bean.ImageItem;
import com.team.qingtai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymh on 2016/5/8.
 */
public class MyPhotoActivity_GridViewAdapter extends BaseAdapter {
    private List<ImageItem> imageList;
    private Activity activity;
    private int width;

    public MyPhotoActivity_GridViewAdapter(Activity activity, ArrayList<ImageItem> imageList, int width) {
        this.imageList = imageList;
        this.activity = activity;
        this.width = width;
    }

    public void setImageList(List<ImageItem> imageList) {
//        imageList.containsAll();
//        for (int i = 0; i < imageList.size(); i++) {
//            imageList.add(i, imageList.get(i));
//        }
//        this.imageList.addAll(imageList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        Log.d("123", "相册数目:" + imageList.size());
        return imageList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("123", position + ".............................");
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(R.layout.main_gridview_item, parent, false);
            holder = new ViewHolder();
            holder.pic = (com.facebook.drawee.view.SimpleDraweeView) convertView.findViewById(R.id.main_gridView_item_photo1);
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) holder.pic.getLayoutParams();
            float density = activity.getResources().getDisplayMetrics().density;
            lp.width = (int) (width / 3 - 4 * density);
            lp.height = (int) (width / 3 - 4 * density);
            holder.pic.setLayoutParams(lp);
            holder.cb = (CheckBox) convertView.findViewById(R.id.deletePic1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            holder.pic.setImageResource(imageList.get(position).width);
            holder.cb.setVisibility(CheckBox.GONE);
        } else {
//            if (isDelete) {
//                holder.cb.setVisibility(CheckBox.VISIBLE);
//                holder.cb.setChecked(false);
//            } else {
//                holder.cb.setVisibility(CheckBox.GONE);
//            }

//            if (imageList.get(position).length() > 0) {
//                if (!imageList.get(position).subSequence(0, 1).equals("/")) {
//                    holder.pic.setImageURI(
//                            Uri.parse(MyApplication.baseIp + "/pictures/mid/" + imageList.get(position)));
//                } else {
            holder.pic.setImageURI(Uri.parse("file:///" + imageList.get(position).path));
//                }
//            }
        }
        return convertView;
    }

    class ViewHolder {
        public com.facebook.drawee.view.SimpleDraweeView pic;
        public CheckBox cb;
    }
}
