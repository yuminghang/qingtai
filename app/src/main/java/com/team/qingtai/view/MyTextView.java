package com.team.qingtai.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {

	public MyTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		// TODO Auto-generated constructor stub
		Typeface type = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/ziti.TTF");
    	this.setTypeface(type);
	}

	public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		Typeface type = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/ziti.TTF");
    	this.setTypeface(type);
		// TODO Auto-generated constructor stub
	}

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Typeface type = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/ziti.TTF");
    	this.setTypeface(type);
		// TODO Auto-generated constructor stub
	}

	public MyTextView(Context context) {
		super(context);
		Typeface type = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/ziti.TTF");
    	this.setTypeface(type);
		// TODO Auto-generated constructor stub
	}

}