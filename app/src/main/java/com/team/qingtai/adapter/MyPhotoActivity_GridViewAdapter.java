package com.team.qingtai.adapter;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.team.qingtai.R;
import com.team.qingtai.activity.FourFragment_Activitys.MyPhotoActivity;


/**
 * Created by ymh on 2016/5/8.
 */
public class MyPhotoActivity_GridViewAdapter extends BaseAdapter {
    private Activity activity;
    private int width;
    public static boolean isDelete = false;

    public MyPhotoActivity_GridViewAdapter(Activity activity, int width) {
        this.activity = activity;
        this.width = width;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        Log.d("123", "相册数目:" + MyPhotoActivity.mImageList.size());
        return MyPhotoActivity.mImageList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return MyPhotoActivity.mImageList.get(position);
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
            int width1 = 50, height1 = 50;
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(MyPhotoActivity.mImageList.get(position)))
                    .setResizeOptions(new ResizeOptions(width1, height1))
                    .build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    .setOldController(holder.pic.getController())
                    .setImageRequest(request)
                    .build();
            holder.pic.setController(controller);
            holder.cb.setVisibility(CheckBox.GONE);
        } else {
            if (isDelete) {
                holder.cb.setVisibility(CheckBox.VISIBLE);
                holder.cb.setChecked(false);
            } else {
                holder.cb.setVisibility(CheckBox.GONE);
            }

//            if (imageList.get(position).length() > 0) {
//                if (!imageList.get(position).subSequence(0, 1).equals("/")) {
//                    holder.pic.setImageURI(
//                            Uri.parse(MyApplication.baseIp + "/pictures/mid/" + imageList.get(position)));
//                } else {
            int width1 = 50, height1 = 50;
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse("file:///" + MyPhotoActivity.mImageList.get(position)))
                    .setResizeOptions(new ResizeOptions(width1, height1))
                    .build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    .setOldController(holder.pic.getController())
                    .setImageRequest(request)
                    .build();
            holder.pic.setController(controller);
//            holder.pic.setImageURI(Uri.parse("file:///" + mImageList.get(position)));
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
