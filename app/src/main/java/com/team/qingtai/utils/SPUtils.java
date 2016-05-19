package com.team.qingtai.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ymh on 2016/5/19.
 */
public class SPUtils {
    public static void savePreference(Context context, String SPName, String key, String value) {
        SharedPreferences preference = context.getSharedPreferences(SPName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
