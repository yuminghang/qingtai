package com.team.qingtai.activity.Twofragment_Activitys;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

public class page extends Activity {
    private ImageView iv;
    private TextView title, from, pagertop, pagerbottm1, pagerbottm4, pagerbottm3, pagerbottm5,
            pagerbottm6, pagerbottm7, pagerbottm2, pagerbottm8, pagerbottm9, pagerbottm10, pagerbottm11, pagerbottm12;
    private RelativeLayout back;
    private TextView titt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paper);
        MyApplication.getInstance().addActivity(this);

        back = (RelativeLayout) findViewById(R.id.addinformationback);
        titt = (TextView) findViewById(R.id.addinformationtitle);
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                page.this.onBackPressed();
            }
        });
        titt.setText("文章");

        iv = (ImageView) findViewById(R.id.pagerimage);

        title = (TextView) findViewById(R.id.pagertitle);
        from = (TextView) findViewById(R.id.pagerfrom);
        pagertop = (TextView) findViewById(R.id.pagerestop);
        pagerbottm1 = (TextView) findViewById(R.id.pageresbottom1);
        pagerbottm2 = (TextView) findViewById(R.id.pageresbottom2);
        pagerbottm3 = (TextView) findViewById(R.id.pageresbottom3);
        pagerbottm4 = (TextView) findViewById(R.id.pageresbottom4);
        pagerbottm5 = (TextView) findViewById(R.id.pageresbottom5);
        pagerbottm6 = (TextView) findViewById(R.id.pageresbottom6);
        pagerbottm7 = (TextView) findViewById(R.id.pageresbottom7);
        pagerbottm8 = (TextView) findViewById(R.id.pageresbottom8);
        pagerbottm9 = (TextView) findViewById(R.id.pageresbottom9);
        pagerbottm10 = (TextView) findViewById(R.id.pageresbottom10);
        pagerbottm11 = (TextView) findViewById(R.id.pageresbottom11);
        pagerbottm12 = (TextView) findViewById(R.id.pageresbottom12);
        pagertop.setText("这个亲戚如雷贯耳，虽然说并不和你沾亲带故的，但是本着女票最大原则，该知道的还是得知道！");
        // LayoutParams lv = (LayoutParams) iv.getLayoutParams();
        //
        // iv.setLayoutParams(lv);
        iv.setImageResource(R.drawable.paper1);
        title.setText("姨妈知多少");
        title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        from.setText("小嗯");
        pagerbottm1.setText("大姨妈");
        pagerbottm1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/ziti.TTF");
        pagerbottm2.setTypeface(face);
        String htmlText = "%s";
        String str = "即月经，也被叫做例假、来事儿等，是女生生理上的循环周期。女生性成熟卵巢会排出卵子，卵子在输卵管内没有受精，就会达到子宫，植入子宫内膜，子宫内膜在排卵期后的两周左右脱落而出血，这就是月经流血的原因。卵子排卵周期是28天，只要卵巢还在排卵，并且没有受精，月经就会28天来一次。";
        pagerbottm2.setText(str);
        pagerbottm3.setText("月经周期应该如何计算？");
        pagerbottm3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        pagerbottm4.setText("很简单，如果每月1日月经造访，那么到下个月“她”再次来敲门时所间隔的天数，就是一个完整的月经周期。");
        pagerbottm5.setText("数字档案");
        pagerbottm5.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pagerbottm6.setTypeface(face);
        pagerbottm6.setText(
                "一次正常月经的时间为2~8天不等 ，正常月经周期为28～35天，周期长短可因人而异，提前或错后7～10天可视为正常范围。女性的排卵日期一般在下次大姨妈来前的14天左右。从下次大姨妈来的第1天算起，减去14天就是排卵日，排卵日及它的前5天和后4天加在一起称为排卵期。除了月经期和排卵期，其余的时间都是安全期。");
        pagerbottm7.setText("THE END!");
        pagerbottm7.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pagerbottm8.setVisibility(View.GONE);
        pagerbottm9.setVisibility(View.GONE);
        pagerbottm10.setVisibility(View.GONE);
        pagerbottm11.setVisibility(View.GONE);
        pagerbottm12.setVisibility(View.GONE);
    }

}
