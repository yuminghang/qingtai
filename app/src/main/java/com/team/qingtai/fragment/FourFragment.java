package com.team.qingtai.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.team.qingtai.R;

public class FourFragment extends Fragment {
    private SimpleDraweeView headImage, backImage;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Fresco.initialize(getActivity());
        View view = inflater.inflate(R.layout.fourfragment_layout, container, false);
        headImage = (SimpleDraweeView) view.findViewById(R.id.touxiang);
        headImage.setImageURI(Uri.parse("res:///" + R.drawable.initavatar));
        backImage = (SimpleDraweeView) view.findViewById(R.id.mebackImage);
        return view;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        updateinfor();
        super.onResume();
    }

    private void updateinfor() {
        // 屏幕匹配
        long heigth = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        RelativeLayout.LayoutParams para = (RelativeLayout.LayoutParams) backImage.getLayoutParams();
        para.height = (int) (heigth * 1 / 3);
        backImage.setLayoutParams(para);

        RelativeLayout.LayoutParams para1 = (RelativeLayout.LayoutParams) headImage.getLayoutParams();
        long meheight = para1.height;
        para1.topMargin = (int) (heigth * 1 / 3 - meheight / 2);
        headImage.setLayoutParams(para1);
    }

}