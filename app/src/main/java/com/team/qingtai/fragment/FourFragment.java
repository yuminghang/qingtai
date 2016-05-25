package com.team.qingtai.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.activity.FourFragment_Activitys.GuanLianTa;
import com.team.qingtai.activity.FourFragment_Activitys.MyCollectionActivity;
import com.team.qingtai.activity.FourFragment_Activitys.MyPhotoActivity;
import com.team.qingtai.activity.FourFragment_Activitys.settingActivity;
import com.team.qingtai.activity.LoginActivity;

import java.util.ArrayList;

public class FourFragment extends Fragment implements View.OnClickListener {
    private SimpleDraweeView headImage, backGroundImage;
    private View view;
    private RelativeLayout mer2, mer3, mer4, mer5;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Fresco.initialize(getActivity());
        view = inflater.inflate(R.layout.fourfragment_layout, container, false);
        headImage = (SimpleDraweeView) view.findViewById(R.id.touxiang);
        headImage.setImageURI(Uri.parse("res:///" + R.drawable.initavatar));
        backGroundImage = (SimpleDraweeView) view.findViewById(R.id.meBackGroundImage);
        initViews();
        return view;
    }

    private void initViews() {
        mer2 = (RelativeLayout) view.findViewById(R.id.meR2);
        mer3 = (RelativeLayout) view.findViewById(R.id.meR3);
        mer4 = (RelativeLayout) view.findViewById(R.id.meR4);
        mer5 = (RelativeLayout) view.findViewById(R.id.meR5);
        mer2.setOnClickListener(this);
        mer3.setOnClickListener(this);
        mer4.setOnClickListener(this);
        mer5.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        updateinfor();
        Log.e("zsdzxd", "OnResume");
        super.onResume();
    }

    private void updateinfor() {
        // 屏幕匹配
        long heigth = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        RelativeLayout.LayoutParams para = (RelativeLayout.LayoutParams) backGroundImage.getLayoutParams();
        para.height = (int) (heigth * 1 / 3);
        backGroundImage.setLayoutParams(para);

        RelativeLayout.LayoutParams para1 = (RelativeLayout.LayoutParams) headImage.getLayoutParams();
        long meheight = para1.height;
        para1.topMargin = (int) (heigth * 1 / 3 - meheight / 2);
        headImage.setLayoutParams(para1);
        headImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.meR2:
                if (MyApplication.getInstance().isLogin()) {
                    Intent intent1 = new Intent(getActivity(), GuanLianTa.class);
                    intent1.putExtra("fromwhere", "native");
                    startActivity(intent1);
                } else {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
                break;
            case R.id.meR3:
                if (MyApplication.getInstance().isLogin()) {
                    Intent intent2 = new Intent(getActivity(), MyPhotoActivity.class);
//                    ArrayList<String> imagePathList = new ArrayList<String>();
//                    imagePathList.add("null");
                    // intent2.putStringArrayListExtra("paths", imagePathList);
                    startActivity(intent2);
                } else {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
                break;
            case R.id.meR4:
                if (MyApplication.getInstance().isLogin()) {
                    // Intent intent3 = new
                    // Intent(getActivity(),otherUserZhuye.class);
                    Intent intent3 = new Intent(getActivity(), MyCollectionActivity.class);
                    // intent3.putExtra("userId", 30);
                    startActivity(intent3);
                } else {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
                break;
            case R.id.meR5:
                if (MyApplication.getInstance().isLogin()) {
                    Intent intent4 = new Intent(getActivity(), settingActivity.class);
                    startActivity(intent4);
                } else {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
                break;
//            case R.id.viewiner4change:
//                if (myapp.getIsLoad()) {
//                    Intent intent5 = new Intent(getActivity(), meInfor.class);
//                    intent5.putExtra("fromwhere", "noload");
//                    startActivity(intent5);
//                } else {
//                    notload();
//                }
//                break;
//            case R.id.mebackImage:
//                if (myapp.getIsLoad()) {
//                    Intent intent1 = new Intent(getActivity(), mezhuye.class);
//                    int id = myapp.getMyUserId();
//                    intent1.putExtra("id", id);
//                    Log.d("123", "my id==" + id);
//                    intent1.putExtra("isme", true);
//                    startActivity(intent1);
//                } else {
//                    notload();
//                }
//                break;
            case R.id.touxiang:
                if (!MyApplication.getInstance().isLogin()) {
//				Intent intent1 = new Intent(getActivity(), mezhuye.class);
//				int id=myapp.getMyUserId();
//				intent1.putExtra("id", id);
//				intent1.putExtra("isme", true);
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    Toast.makeText(getActivity(), "已经登录！测试用，将来再改", Toast.LENGTH_SHORT).show();
                }
        }
    }
}