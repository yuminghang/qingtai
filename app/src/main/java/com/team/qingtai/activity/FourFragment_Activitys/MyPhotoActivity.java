package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.loader.GlideImageLoader;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.adapter.MyPhotoActivity_GridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPhotoActivity extends Activity {
    private int width;
    private GridView gv;
    private RelativeLayout back;
    private TextView title;
    private TextView finish;
    private MyApplication myapplication;
    private Button sendMessage;
    MyPhotoActivity_GridViewAdapter adapter;
    protected static final int UPDATEIMAGE = 0;
    private static final int GET_PHOTO = 1;
    private RequestQueue requestQueue;
    private List<ImageItem> imageList = new ArrayList<>();// 用来保存展示图片的地址
    private List<String> deleteImage = new ArrayList<>();// 用来保存需要删除的图片地址
    private List<String> updateImage = new ArrayList<>();// 用来保存要上传的图片；
    private Boolean isDelete;
    private float density;
    private ImageItem imageItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_photo);
        MyApplication.getInstance().addActivity(this);
        Fresco.initialize(this);
        initImagePicker();
        initDensity();
        initData();
        initView();
        initListener();
    }

    private void initImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(9);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }

    private void initListener() {
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPhotoActivity.this, ImageGridActivity.class);
                startActivityForResult(intent, GET_PHOTO);
                // TODO Auto-generated method stub
//                if (finish.getText().equals("编辑")) {
//                    if (imageList.size() >=0) {
//                        isDelete = true;
//                        sendMessage.setText("确定删除");
//                        sendMessage.setVisibility(View.VISIBLE);
//                        finish.setText("取消");
////                        adapter.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(MyPhotoActivity.this, "没有可删除的照片。。", Toast.LENGTH_SHORT).show();
//                    }
//                } else if (finish.getText().equals("取消")) {
////                    if (updateImage.size() > 0) {
////                        for (int i = 0; i < updateImage.size(); i++) {
////                            if (imageList.contains(updateImage.get(i))) {
////                                imageList.remove(updateImage.get(i));
////                            }
////                        }
////                    }
//                    finish.setText("编辑");
//                    sendMessage.setVisibility(View.GONE);
////                    adapter.notifyDataSetChanged();
//                    isDelete = false;
//                }
            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    if (imageList.size() < 9) {
//                        Intent intent = new Intent(mexiangce.this, GetImageActivity.class);
//                        Custom.picsize = (9 - imageList.size());
//                        startActivityForResult(intent, GET_PHOTO);
                        Intent intent = new Intent(MyPhotoActivity.this, ImageGridActivity.class);
                        startActivityForResult(intent, GET_PHOTO);
                    } else {
                        Toast.makeText(myapplication, "最多8张图片", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    CheckBox ck = (CheckBox) view.findViewById(R.id.deletePic1);
//                    if (isDelete) {
//                        String rtd = imageList.get(position).path;
//                        if (ck.isChecked()) {
//                            ck.setChecked(false);
//                        } else {
//                            ck.setChecked(true);
//                        }
//
//                        if (!deleteImage.contains(rtd)) {
//                            deleteImage.add(imageList.get(position));
//                        } else {
//                            deleteImage.remove(imageList.get(position));
//                        }
//                    } else {
//                        //Custom.picsize = 9;
////                        Intent intent = new Intent(mexiangce.this, ScanBlogImageActivity.class);
////                        imageList.remove("null");
////                        intent.putStringArrayListExtra("bigImages", new ArrayList<String>(imageList));
////                        intent.putExtra("position", position - 1);
////                        startActivity(intent);
////                        imageList.add(0, "null");
//                    }
                }
            }
        });
    }

    private void initData() {
        imageItem = new ImageItem();
        imageItem.width = R.drawable.add_image;
        imageList.add(0, imageItem);
    }

    private void initView() {
        sendMessage = (Button) findViewById(R.id.sendpic);
        gv = (GridView) findViewById(R.id.main_gridView);
        gv.setColumnWidth(width / 3);
        gv.setMinimumHeight((int) (width + 10 * density));
        adapter = new MyPhotoActivity_GridViewAdapter(this, (ArrayList<ImageItem>) imageList, width);
        gv.setAdapter(adapter);
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("相册");
        finish = (TextView) findViewById(R.id.addinformationset);
    }

    private void initDensity() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        density = getResources().getDisplayMetrics().density;
        width = (int) (dm.widthPixels - 30 * density);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == GET_PHOTO) {
                imageList = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                if(imageList.size()>0){
                    adapter.setImageList(imageList);
                }
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
