package com.team.qingtai;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ymh on 2016/4/12.
 */
public class MyApplication extends Application {
    private List<Activity> activityList = new LinkedList<Activity>();
    public static MyApplication instance;

    public MyApplication() {

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
}
