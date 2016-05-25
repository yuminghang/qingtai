package com.team.qingtai;

import android.app.Activity;
import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.team.qingtai.utils.SPUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ymh on 2016/4/12.
 */
public class MyApplication extends Application {
    private List<Activity> activityList = new LinkedList<Activity>();
    private String cookie;
    private int uid;
    private boolean isLogin;
    public static MyApplication instance;
    public static RequestQueue requestQueue;

    public boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }



    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


    public MyApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
    }

    public static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }


    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    public void setcookie(String cookie) {
        this.cookie = cookie;
//        SPUtils.savePreference(MyApplication.getInstance(), "my_cookie", "cookie", cookie);
    }

    public String getCookie() {
        return cookie;
    }

}
