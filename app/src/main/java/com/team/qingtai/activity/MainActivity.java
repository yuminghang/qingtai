package com.team.qingtai.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.adapter.MainActivity_MyFrageStatePagerAdapter;
import com.team.qingtai.fragment.FourFragment;
import com.team.qingtai.fragment.OneFragment;
import com.team.qingtai.fragment.ThreeFragment;
import com.team.qingtai.fragment.TwoFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private ArrayList<Fragment> fragmentList;
    private LinearLayout image11;
    private LinearLayout image21;
    private LinearLayout image31;
    private LinearLayout image41;
    private ImageView image1, image2, image3, image4;
    private ViewPager vPager;
    private long exitTime;
    public MainActivity_MyFrageStatePagerAdapter adapter;

    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication.getInstance().addActivity(this);

        initStatusBar();
        initMainView();
    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.top_color);//通知栏所需颜色
    }

    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private void initMainView() {
        image11 = (LinearLayout) findViewById(R.id.iv1);
        image21 = (LinearLayout) findViewById(R.id.iv2);
        image31 = (LinearLayout) findViewById(R.id.iv3);
        image41 = (LinearLayout) findViewById(R.id.iv4);
        image1 = (ImageView) findViewById(R.id.iv11);
        image2 = (ImageView) findViewById(R.id.iv21);
        image3 = (ImageView) findViewById(R.id.iv31);
        image4 = (ImageView) findViewById(R.id.iv41);
        image1.setOnClickListener(new MyOnClickListener(0));
        image2.setOnClickListener(new MyOnClickListener(1));
        image3.setOnClickListener(new MyOnClickListener(2));
        image4.setOnClickListener(new MyOnClickListener(3));
        image11.setOnClickListener(new MyOnClickListener(0));
        image21.setOnClickListener(new MyOnClickListener(1));
        image31.setOnClickListener(new MyOnClickListener(2));
        image41.setOnClickListener(new MyOnClickListener(3));

        fragmentList = new ArrayList<Fragment>();
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();

        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);
        fragmentList.add(threeFragment);
        fragmentList.add(fourFragment);

        vPager = (ViewPager) findViewById(R.id.viewPager);
        vPager.setOffscreenPageLimit(4);
        vPager.setOnPageChangeListener(new PageChanger());


        int width = getWindowManager().getDefaultDisplay().getWidth();

        adapter = new MainActivity_MyFrageStatePagerAdapter(getSupportFragmentManager(), fragmentList);
        vPager.setAdapter(adapter);
    }

    class MyOnClickListener implements View.OnClickListener {

        private int index = 0;

        public MyOnClickListener(int index) {
            this.index = index;
        }

        @Override
        public void onClick(View v) {
            vPager.setCurrentItem(index, false);
        }

    }


    public class PageChanger implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {

            switch (arg0) {
                case 0:
                    image1.setImageDrawable(getResources().getDrawable(R.drawable.information_sel));
                    image2.setImageDrawable(getResources().getDrawable(R.drawable.homework));
                    image3.setImageDrawable(getResources().getDrawable(R.drawable.look));
                    image4.setImageDrawable(getResources().getDrawable(R.drawable.me));
                    break;
                case 1:
                    image2.setImageDrawable(getResources().getDrawable(R.drawable.homework_sel));
                    image1.setImageDrawable(getResources().getDrawable(R.drawable.information));
                    image3.setImageDrawable(getResources().getDrawable(R.drawable.look));
                    image4.setImageDrawable(getResources().getDrawable(R.drawable.me));
                    break;
                case 2:
                    image3.setImageDrawable(getResources().getDrawable(R.drawable.look_sel));
                    image2.setImageDrawable(getResources().getDrawable(R.drawable.homework));
                    image1.setImageDrawable(getResources().getDrawable(R.drawable.information));
                    image4.setImageDrawable(getResources().getDrawable(R.drawable.me));
                    break;
                case 3:
                    image4.setImageDrawable(getResources().getDrawable(R.drawable.me_sel));
                    image2.setImageDrawable(getResources().getDrawable(R.drawable.homework));
                    image3.setImageDrawable(getResources().getDrawable(R.drawable.look));
                    image1.setImageDrawable(getResources().getDrawable(R.drawable.information));
                    break;
            }
        }
    }

    //连续点击两次退出应用
    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再点击一次退出应用", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
