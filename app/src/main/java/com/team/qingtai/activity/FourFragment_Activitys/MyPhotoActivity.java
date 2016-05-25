package com.team.qingtai.activity.FourFragment_Activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.loader.GlideImageLoader;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.adapter.MyPhotoActivity_GridViewAdapter;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;
import com.team.qingtai.base.FormImage;
import com.team.qingtai.utils.PostUploadRequest;
import com.team.qingtai.view.CustomProgressDlg;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPhotoActivity extends BaseActivity {
    private int width;
    private GridView gv;
    private RelativeLayout back;
    private TextView title;
    private TextView finish;
    private Button sendMessage;
    MyPhotoActivity_GridViewAdapter adapter;
    protected static final int UPDATEIMAGE = 0;
    private static final int GET_PHOTO = 1;
    public static List<String> mImageList = new ArrayList<>();// 用来保存展示图片的地址
    public static List<String> deleteImage = new ArrayList<>();// 用来保存需要删除的图片地址
    private List<String> updateImage = new ArrayList<>();// 用来保存要上传的图片；
    private static ArrayList<ImageItem> imageResult;//选择照片后返回的图片信息存在这里

    private static Boolean isDelete = false;
    private float density;
    private ImageItem imageItem;
    private ImagePicker imagePicker;
    private CheckBox cb;
    private int flag = 0;
    private CustomProgressDlg mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_photo);
        Fresco.initialize(this);
        mImageList.clear();
        updateImage.clear();
        deleteImage.clear();
        initImagePicker();
        initDensity();
        initData();
        initView();
        setListener();
        getalbum(MyApplication.getInstance().getUid());
    }

    /**
     * 获取相册信息
     *
     * @param uid
     */
    private void getalbum(int uid) {
        Log.d("nuanbaotext", "相册信息下载:" + uid);
        JSONObject json1 = new JSONObject();
        try {
            json1.put("version", "v1.0").put("data", new JSONObject().put("user_id", uid).put("tag", "相册"));
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        JsonObjectRequest jspp = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "pic_cgis/get_photograph.php", json1, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                Log.d("123", "相册信息下载信息:" + response.toString());
                try {
                    String sts = new String();
                    JSONArray jss = response.getJSONArray("data");
                    JSONObject jo = new JSONObject();
                    int n = jss.length();
                    for (int i = 0; i < n; i++) {
                        jo = jss.getJSONObject(i);
                        mImageList.add(jo.getString("pic"));
                        sts = sts + jo.getString("pic") + ",";
                    }
                    Log.d("nuanbaotext", "获取照片路径：" + sts);
                    adapter.notifyDataSetChanged();
                    SharedPreferences.Editor editor = getSharedPreferences("setting", MODE_PRIVATE).edit();
                    editor.putString("pic", sts).commit();

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                Log.d("nuanbaotext", "下载服务器相册反馈信息:" + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                // TODO Auto-generated method stub
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Cookie", MyApplication.getInstance().getCookie());
                return headers;
            }
        };
        MyApplication.requestQueue.add(jspp);
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
                        MyPhotoActivity.isDelete = true;
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
                        Log.e("size", updateImage.size() + "\\32");
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
                        MyPhotoActivity.isDelete = false;
                        imagePicker.setSelectLimit(9 - mImageList.size());    //选中数量限制
                        Intent intent = new Intent(MyPhotoActivity.this, ImageGridActivity.class);
                        startActivityForResult(intent, GET_PHOTO);
                    } else {
                        Toast.makeText(MyPhotoActivity.this, "最多8张图片", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    cb = (CheckBox) view.findViewById(R.id.deletePic1);
                    //删除状态
                    if (MyPhotoActivity.isDelete) {
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
                        String deleteString = new String();
                        for (String str : deleteImage) {
                            str = str.substring(0, str.length() - 4);
                            deleteString = deleteString + str + ",";
                        }
                        deleteString = deleteString.substring(0, deleteString.length() - 1);
                        mProgressDialog = CustomProgressDlg.show(MyPhotoActivity.this, "正在删除...", false, null);
                        mProgressDialog.setCanceledOnTouchOutside(false);
                        deleteMyImage(deleteString);
                        sendMessage.setVisibility(View.GONE);
                        for (String path : deleteImage) {
                            Log.e("asdsad", path);
                        }
                    } else {
                        Toast.makeText(MyPhotoActivity.this, "请选择要删除的照片。。", Toast.LENGTH_SHORT).show();
                    }
                }
                if (sendMessage.getText().equals("上传图片") || sendMessage.getText().equals("重新上传")) {
//                    isDelete = false;
                    if (updateImage.size() > 0) {
                        Log.e("ZSdZDZ", Thread.currentThread().getId() + "");
                        uploadavatarImgae();
                        mProgressDialog = CustomProgressDlg.show(MyPhotoActivity.this, "正在上传...", false, null);
                        mProgressDialog.setCanceledOnTouchOutside(false);
                    }
                    sendMessage.setVisibility(View.GONE);
                }
            }
        });
    }

    private void uploadavatarImgae() {

        List<FormImage> upImageList = new ArrayList<FormImage>();
        for (int i = 0; i < updateImage.size(); i++) {
            FormImage formImage = new FormImage(updateImage.get(i));
            upImageList.add(formImage);
        }
        Log.d("nuanbaotext", "上传图片地址:" + updateImage.toString() + "---" + upImageList.toString());
        Request request = new PostUploadRequest(0, Urls.UPLOAD_Url, upImageList,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // TODO Auto-generated method stub
                        Log.d("nuanbaotext", "上传图片反馈信息 : " + response.toString());
                        Log.e("ZSdZDZ121212", Thread.currentThread().getName() + "");

                        try {
                            JSONObject obj = new JSONObject(response);
                            int code = obj.getInt("code");
                            if (code == 0) {
                                JSONArray jarray = obj.getJSONArray("data");
                                String id = "";
                                for (int i = 0; i < jarray.length(); i++) {
                                    obj = jarray.getJSONObject(i);
                                    id = id + obj.getString("pid") + ",";
                                }
                                if (id.length() > 0) {
                                    id = id.substring(0, id.length() - 1);
                                    Log.d("nuanbaotext", "相册上传中:" + id);
                                    updateUserInformation(id);
                                }
                            } else {
                                Toast.makeText(MyPhotoActivity.this, "图片上传失败", Toast.LENGTH_SHORT).show();
                                finish.setText("取消");
                                isDelete = false;
                                sendMessage.setVisibility(View.VISIBLE);
                                sendMessage.setText("重新上传");
                                mProgressDialog.dismiss();
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            Toast.makeText(MyPhotoActivity.this, "图片上传失败", Toast.LENGTH_SHORT).show();
                            finish.setText("取消");
                            isDelete = false;
                            sendMessage.setVisibility(View.VISIBLE);
                            sendMessage.setText("重新上传");
                            mProgressDialog.dismiss();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Toast.makeText(MyPhotoActivity.this, "请检查网络连接", Toast.LENGTH_SHORT).show();
                finish.setText("取消");
                isDelete = false;
                sendMessage.setVisibility(View.VISIBLE);
                sendMessage.setText("重新上传");
                mProgressDialog.dismiss();

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                // TODO Auto-generated method stub
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Cookie", MyApplication.getInstance().getCookie());
                return headers;
            }
        };
        MyApplication.requestQueue.add(request);
    }

    /**
     * 上传服务器返回的pid，得到pic即图片的网络地址后缀，而前缀是一样的
     *
     * @param avatarpath
     */
    private void updateUserInformation(final String avatarpath) {
        JSONObject json1 = new JSONObject();
        try {
            json1.put("version", "v1.0").put("data", new JSONObject().put("pids", avatarpath).put("tag", "相册"));
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JsonObjectRequest jsp = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "pic_cgis/upload_photograph.php", json1,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub

                        Log.d("nuanbaotext", "上传图片服务器ID服务器反馈:" + response.toString() + avatarpath);
                        try {
                            if ((int) response.get("code") == 0) {
                                JSONArray jsarray = response.getJSONArray("data");
                                String str = new String();
                                String picaddress = new String();
                                for (int i = 0; i < jsarray.length(); i++) {
                                    picaddress = ((JSONObject) jsarray.get(i)).getString("pic");
                                    str = str + picaddress + ",";
                                    mImageList.add(picaddress);
                                }
//
                                SharedPreferences.Editor edit = getSharedPreferences("setting", MODE_PRIVATE).edit();
                                edit.putString("pic", str);
                                edit.commit();
                                while (updateImage.size() > 0) {
                                    if (mImageList.contains(updateImage.get(updateImage.size() - 1))) {
                                        mImageList.remove(updateImage.get(updateImage.size() - 1));
                                        updateImage.remove(updateImage.get(updateImage.size() - 1));
                                    }
                                }

                                adapter.notifyDataSetChanged();
                                mProgressDialog.dismiss();
                                Toast.makeText(MyPhotoActivity.this, "图片上传成功", Toast.LENGTH_SHORT).show();
                                finish.setText("编辑");
                                updateImage.clear();
                            } else {
                                mProgressDialog.dismiss();
                                Toast.makeText(MyPhotoActivity.this, "图片上传失败", Toast.LENGTH_SHORT).show();
                                finish.setText("取消");
                                isDelete = false;
                                sendMessage.setVisibility(View.VISIBLE);
                                sendMessage.setText("重新上传");
                                adapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            mProgressDialog.dismiss();
                            Toast.makeText(MyPhotoActivity.this, "图片上传失败", Toast.LENGTH_SHORT).show();
                            finish.setText("取消");
                            isDelete = false;
                            sendMessage.setVisibility(View.VISIBLE);
                            sendMessage.setText("重新上传");
                            adapter.notifyDataSetChanged();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                mProgressDialog.dismiss();
                Toast.makeText(MyPhotoActivity.this, "请检查网络连接", Toast.LENGTH_SHORT).show();
                finish.setText("取消");
                isDelete = false;
                sendMessage.setVisibility(View.VISIBLE);
                sendMessage.setText("重新上传");
                adapter.notifyDataSetChanged();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                // TODO Auto-generated method stub
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Cookie", MyApplication.getInstance().getCookie());
                return headers;
            }
        };
        MyApplication.requestQueue.add(jsp);
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
                if (imageResult.size() > 0) {
                    for (ImageItem result : imageResult) {
                        mImageList.add(result.path);
                        updateImage.add(result.path);
//                        Log.e("adasdkk", result.size + "");
                        Log.e("adasdkk", updateImage.size() + "");
                        Log.e("adasdkk", updateImage.toString() + "");
                    }
                    finish.setText("取消");
                    isDelete = false;
                    sendMessage.setVisibility(View.VISIBLE);
                    sendMessage.setText("上传图片");
                    adapter.notifyDataSetChanged();
                }
            } else {
                Toast.makeText(MyPhotoActivity.this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void deleteMyImage(final String deleteid) {
        JSONObject json1 = new JSONObject();
        try {
            json1.put("version", "v1.0").put("pids", deleteid);
            Log.d("123", "删除相册：" + deleteid);
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JsonObjectRequest jsp = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "pic_cgis/delete_photograph.php", json1,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub
                        Log.d("123", "删除照片:" + response.toString());
                        try {
                            if (response.getInt("code") == 0) {
                                Toast.makeText(MyPhotoActivity.this, "图片删除成功", Toast.LENGTH_SHORT).show();
//                                SharedPreferences sp = getSharedPreferences("setting", MODE_PRIVATE);
//                                SharedPreferences.Editor spE = sp.edit();
//
//                                String detepic = sp.getString("pic", null);
//                                if (detepic != null) {
//                                    String[] st = deleteid.split(",");
//                                    for (String pic : st) {
//                                        Pattern p = Pattern.compile(pic + ".[a-zA-Z]{2,4},");
//                                        Matcher ma = p.matcher(detepic);
//                                        while (ma.find()) {
//                                            detepic = ma.replaceAll("");
//                                        }
//                                    }
//                                }
                                for (int i = 0; i < deleteImage.size(); i++) {
                                    if (mImageList.contains(deleteImage.get(i))) {
                                        mImageList.remove(deleteImage.get(i));
                                    }
                                }
                                mProgressDialog.dismiss();
                                deleteImage.clear();
                                finish.setText("编辑");
                                isDelete = false;
                                MyPhotoActivity_GridViewAdapter.isDelete = false;
                                adapter.notifyDataSetChanged();
//                                Log.d("nuanbaotext", "剩余的照片" + detepic);
//                                spE.putString("pic", detepic);
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            mProgressDialog.dismiss();
                            sendMessage.setText("重新删除");
                            sendMessage.setVisibility(View.VISIBLE);
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                mProgressDialog.dismiss();
                sendMessage.setText("重新删除");
                sendMessage.setVisibility(View.VISIBLE);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                // TODO Auto-generated method stub
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Cookie", MyApplication.getInstance().getCookie());
                return headers;
            }
        };

        MyApplication.requestQueue.add(jsp);
    }
}
