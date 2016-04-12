package com.team.qingtai.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.team.qingtai.R;
import com.team.qingtai.activity.Twofragment_Activitys.fortest;
import com.team.qingtai.activity.Twofragment_Activitys.knownews;
import com.team.qingtai.activity.Twofragment_Activitys.nuannanplan;
import com.team.qingtai.utils.DensityUtils;
import com.team.qingtai.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment implements View.OnClickListener {
    private SimpleDraweeView tv1, tv2, tv3;
    private MyViewPager viewPager;
    private ArrayList<SimpleDraweeView> mImageViewList;
    private static int[] mImageIds = new int[]{R.drawable.two_pic1, R.drawable.two_pic2, R.drawable.two_pic3};
    private int len;
    private List<View> viewList = new ArrayList<View>();
    private View viewBluePoint;// 小圆点
    private int mPointWidth;// 圆点间的距离
    private LinearLayout llPointGroup;
    private float lastPos = -1;
    private boolean isScroll;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.twofragment_layout, container, false);
        viewPager = (MyViewPager) view.findViewById(R.id.ViewPagershows);
        tv1 = (SimpleDraweeView) view.findViewById(R.id.view21);
        tv2 = (SimpleDraweeView) view.findViewById(R.id.view22);
        tv3 = (SimpleDraweeView) view.findViewById(R.id.view23);
        tv2.setImageURI(Uri.parse("res://" + getActivity().getPackageName() + "/" + R.drawable.nuannanjihua));
        tv3.setImageURI(Uri.parse("res://" + getActivity().getPackageName() + "/" + R.drawable.qinqi));
        tv1.setImageURI(Uri.parse("res://" + getActivity().getPackageName() + "/" + R.drawable.sweetheart));

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);


        WindowManager win = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        int width = win.getDefaultDisplay().getWidth();
        float density = getResources().getDisplayMetrics().density;
        width = (int) (width - 20 * density);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewPager.getLayoutParams();
        params.width = width;
        params.height = (int) (width / 2.5);
        viewPager.setLayoutParams(params);
        viewPager.setOffscreenPageLimit(3);
        RelativeLayout.LayoutParams param1 = (RelativeLayout.LayoutParams) tv1.getLayoutParams();
        param1.width = width;
        param1.height = (int) (width / 1.77);
        tv1.setLayoutParams(param1);
        RelativeLayout.LayoutParams param2 = (RelativeLayout.LayoutParams) tv2.getLayoutParams();
        param2.width = width;
        param2.height = (int) (width / 1.77);
        tv2.setLayoutParams(param2);
        RelativeLayout.LayoutParams param3 = (RelativeLayout.LayoutParams) tv3.getLayoutParams();
        param3.width = width;
        param3.height = (int) (width / 1.77);
        tv3.setLayoutParams(param3);
        initViewPager();
        initPointGroup(view);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view21:
                startActivity(new Intent(getActivity(), knownews.class));
                break;
            case R.id.view22:
                startActivity(new Intent(getActivity(), nuannanplan.class));
                break;
            case R.id.view23:
                startActivity(new Intent(getActivity(), fortest.class));
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initViewPager() {
        mImageViewList = new ArrayList<SimpleDraweeView>();
        for (int i = 0; i < mImageIds.length; i++) {
            SimpleDraweeView iv = new SimpleDraweeView(getActivity());
            iv.getHierarchy().setActualImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY);
            iv.setImageURI(Uri.parse("res://" + getActivity().getPackageName() + "/" + mImageIds[i]));
            mImageViewList.add(iv);
        }
        viewPager.setAdapter(new PagerAdapter() {

            //viewpager中的组件数量
            @Override
            public int getCount() {
                return mImageIds.length;
            }

            //滑动切换的时候销毁当前的组件
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mImageViewList.get(position));
            }

            //每次滑动的时候生成的组件
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mImageViewList.get(position));
                return mImageViewList.get(position);
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
                Log.e("test", arg0 + " ");

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.e("caonima", position + " " + positionOffset + " " + positionOffsetPixels);
//                if (position == mImageIds.length - 1 && lastPos == positionOffset && !isScroll) {
//                    viewPager.setCurrentItem(0);
//                    isScroll = true;
//                } else if (position == 0 && lastPos == positionOffset && !isScroll) {
//                    viewPager.setCurrentItem(mImageIds.length - 1);
//                    isScroll = true;
//                }
//                lastPos = positionOffset;
            }

            @Override
            public void onPageSelected(int arg0) {
                if (arg0 == 0) {
                    len = 0;
                } else {
                    len = mPointWidth * arg0;
                }
                isScroll = false;
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewBluePoint
                        .getLayoutParams();// 获取当前红点的布局参数
                params.leftMargin = len;// 设置左边距
                params.bottomMargin = DensityUtils.dp2px(getActivity(), 2);
                viewBluePoint.setLayoutParams(params);// 重新给小红点设置布局参数
            }
        });
    }

    private void initPointGroup(View view) {
        llPointGroup = (LinearLayout) view.findViewById(R.id.point_group_LinearLayout);
        viewBluePoint = view.findViewById(R.id.blue_point_View);
        // 初始化引导页的小圆点
        for (int i = 0; i < mImageIds.length; i++) {
            View point = new View(getActivity());
            point.setBackgroundResource(R.drawable.dot_gray);// 设置引导页默认圆点

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    DensityUtils.dp2px(getActivity(), 8), DensityUtils.dp2px(getActivity(), 8));
            if (i > 0) {
                params.leftMargin = DensityUtils.dp2px(getActivity(), 5);// 设置圆点间隔
            }

            point.setLayoutParams(params);// 设置圆点的大小

            llPointGroup.addView(point);// 将圆点添加给线性布局
            // 获取视图树, 对layout结束事件进行监听
            llPointGroup.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {

                        // 当layout执行结束后回调此方法
                        @Override
                        public void onGlobalLayout() {
                            llPointGroup.getViewTreeObserver()
                                    .removeGlobalOnLayoutListener(this);
                            mPointWidth = llPointGroup.getChildAt(1).getLeft()
                                    - llPointGroup.getChildAt(0).getLeft();
                        }
                    });
        }
    }
}