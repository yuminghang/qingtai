package com.team.qingtai.view;

/**
 * Created by ymh on 2016/5/19.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by ymh on 2016/5/6.
 */
public class MyGridView extends GridView {

    public MyGridView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
