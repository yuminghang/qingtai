package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
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
import com.team.qingtai.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MyPhotoActivity extends BaseActivity {
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
    public static List<String> mImageList = new ArrayList<>();// 用来保存展示图片的地址
    public static List<ImageItem> imageResult = new ArrayList<>();// 用来保存展示图片的地址
    public static List<String> deleteImage = new ArrayList<>();// 用来保存需要删除的图片地址
    private List<String> updateImage = new ArrayList<>();// 用来保存要上传的图片；
    private Boolean isDelete;
    private float density;
    private ImageItem imageItem;
    private ImagePicker imagePicker;
    private CheckBox cb;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_photo);
        Fresco.initialize(this);
        initImagePicker();
        initDensity();
        initData();
        initView();
        setListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("asdsa", "出来啦！！");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("asdsa", "消失啦！！");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mImageList.clear();
        updateImage.clear();
        deleteImage.clear();
    }

    private void initImagePicker() {
        imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(8);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(200);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(200);//保存文件的高度。单位像素
    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mImageList.clear();
                updateImage.clear();
                deleteImage.clear();
                finish();
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (finish.getText().equals("编辑")) {
                    if (mImageList.size() > 1) {
                        finish.setText("取消");
                        sendMessage.setText("确定删除");
                        sendMessage.setVisibility(View.VISIBLE);
                        MyPhotoActivity_GridViewAdapter.isDelete = true;
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(MyPhotoActivity.this, "没有可编辑的照片。。", Toast.LENGTH_SHORT).show();
                    }
                } else if (finish.getText().equals("取消")) {
                    if (updateImage.size() > 0) {
                        while (updateImage.size() > 0) {
                            if (mImageList.contains(updateImage.get(updateImage.size() - 1))) {
                                mImageList.remove(updateImage.get(updateImage.size() - 1));
                                updateImage.remove(updateImage.size() - 1);
                            }
                        }
                        Log.e("size", updateImage.size() + "");
                    }
                    finish.setText("编辑");
                    sendMessage.setVisibility(View.GONE);
                    MyPhotoActivity_GridViewAdapter.isDelete = false;
                    adapter.notifyDataSetChanged();
                }
            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    if (mImageList.size() < 9) {
//                        Intent intent = new Intent(mexiangce.this, GetImageActivity.class);
//                        Custom.picsize = (9 - imageList.size());
//                        startActivityForResult(intent, GET_PHOTO);
                        isDelete = false;
                        imagePicker.setSelectLimit(9 - mImageList.size());    //选中数量限制
                        Intent intent = new Intent(MyPhotoActivity.this, ImageGridActivity.class);
                        startActivityForResult(intent, GET_PHOTO);
                    } else {
                        Toast.makeText(MyPhotoActivity.this, "最多8张图片", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    cb = (CheckBox) view.findViewById(R.id.deletePic1);
                    //删除状态
                    if (isDelete) {
//                        String rtd = imageList.get(position).path;
                        if (cb.isChecked()) {
                            cb.setChecked(false);
                        } else {
                            cb.setChecked(true);
                        }
                        if (!deleteImage.contains(mImageList.get(position))) {
                            deleteImage.add(mImageList.get(position));
                        } else {
                            deleteImage.remove(mImageList.get(position));
                        }
                    } else {
                        //非删除状态
//                        //Custom.picsize = 9;
////                        Intent intent = new Intent(mexiangce.this, ScanBlogImageActivity.class);
////                        imageList.remove("null");
////                        intent.putStringArrayListExtra("bigImages", new ArrayList<String>(imageList));
////                        intent.putExtra("position", position - 1);
////                        startActivity(intent);
////                        imageList.add(0, "null");
//                    }
                        Toast.makeText(MyPhotoActivity.this, "查看照片！！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("nuanbaotext", "deleteImage:" + deleteImage.toString());
                if (sendMessage.getText().equals("确定删除") || sendMessage.getText().equals("重新删除")) {
                    if (deleteImage.size() > 0) {
//                        String deleteString = new String();
//                        for (String str : deleteImage) {
//                            if (str == null) {
//                                continue;
//                            }
//                            String[] getarray = str.split("\\.");
//                            deleteString = deleteString + getarray[0] + ",";
//
//                        }
//                        deleteString = deleteString.replace("null", "");
//                        Log.d("nuanbaotext", "deleteString:" + deleteString.toString());
//                        mProgressDialog = CustomProgressDlg.show(mexiangce.this, "正在删除...", false, null);
//                        mProgressDialog.setCanceledOnTouchOutside(false);
//                        deleteImage(deleteString);
//                        sendMessage.setVisibility(View.GONE);
                        for (String path : deleteImage) {
                            Log.e("asdsad", path);
                        }
                    } else {
                        Toast.makeText(MyPhotoActivity.this, "请选择要删除的照片。。", Toast.LENGTH_SHORT).show();
                    }
                }
                if (sendMessage.getText().equals("上传图片") || sendMessage.getText().equals("重新上传")) {
//                    isDelete = false;
//                    if (updateImage.size() > 0) {
//                        uploadavatarImgae(updateImage);
//                        mProgressDialog = CustomProgressDlg.show(mexiangce.this, "正在上传...", false, null);
//                        mProgressDialog.setCanceledOnTouchOutside(false);
//                    }
//                    sendMessage.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initData() {
        imageItem = new ImageItem();
        mImageList.add(0, "res://" + MyPhotoActivity.this.getPackageName() + "/" + R.drawable.add_image);
    }

    private void initView() {
        sendMessage = (Button) findViewById(R.id.sendpic);
        gv = (GridView) findViewById(R.id.main_gridView);
        gv.setColumnWidth(width / 3);
        gv.setMinimumHeight((int) (width + 10 * density));
        adapter = new MyPhotoActivity_GridViewAdapter(this, width);
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
                imageResult = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                for (ImageItem result : imageResult) {
//                    mImageList.add(result.path);
                    Log.e("adasd", result.size + "");
                }
                if (imageResult.size() > 0) {
                    for (ImageItem result : imageResult) {
                        mImageList.add(result.path);
                        updateImage.add(result.path);
                        Log.e("adasd", result.size + "");
                        Log.e("adasd", updateImage.toArray() + "");
                    }
                    finish.setText("取消");
                    isDelete = false;
                    sendMessage.setVisibility(View.VISIBLE);
                    sendMessage.setText("上传图片");
                    adapter.notifyDataSetChanged();
                }
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
