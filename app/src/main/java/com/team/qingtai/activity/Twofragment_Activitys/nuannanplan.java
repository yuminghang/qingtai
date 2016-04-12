package com.team.qingtai.activity.Twofragment_Activitys;

import android.app.Activity;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

/**
 * Created by ymh on 2016/4/12.
 */
public class nuannanplan extends Activity {
    private ImageView iv;
    private TextView title, from, pagertop, pagerbottm1, pagerbottm4, pagerbottm3, pagerbottm5, pagerbottm6,
            pagerbottm7, pagerbottm2, pagerbottm8, pagerbottm9, pagerbottm10, pagerbottm11, pagerbottm12;
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
        titt.setText("变形计");
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        iv = (ImageView) findViewById(R.id.pagerimage);
        LayoutParams lp = (LayoutParams) iv.getLayoutParams();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int height = (int) (screenWidth / 1.7);
        lp.width = screenWidth;
        lp.height = height;
        iv.setLayoutParams(lp);

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
        String t = null;
        String aut = null;
        String be = null;
        String t1 = null;
        String t2 = null;
        String t3 = null;
        String t4 = null;
        String t5 = null;
        String n1 = null;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        String n5 = null;
        iv.setScaleType(ScaleType.CENTER_INSIDE);
        iv.setBackgroundResource(R.drawable.nuanbaojihuaimage);
        t = "变形计";
        aut = "小嗯";
        be = "无论她平时多折腾、多暴躁、多像个磨人的小妖精，可是一旦大姨妈来串门，她就好像是孙猴子被念了紧箍咒一般，如果这个时候作为男票的你只会说“多喝点热水吧”，那你的下场只有一个——再次沦为单身狗！面对如此脆弱又极易引爆的美少女，做为百分百暖男的你，可以做些什么呢？";
        t1 = "大姨妈前两天";
        n1 = " 1、阻止她参与剧烈运动，经期前的剧烈运动会影响女生经期的正常循环；\n 2、不要让她吃太冰、辣等刺激性食物，很多大姨妈来临之后的疼痛就是由于这几天的刺激性饮食；";
        t2 = "大姨妈时间";
        n2 = "\n 保暖：\n 1、说一百万次多喝热水，不如一次把冲好的红糖姜水递到她手上；\n 2、给她准备热水袋、暖宝宝或暖宝贴放小肚子上；\n 3、督促她穿暖和一点，不可以淋雨，大姨妈时期不能受凉；\n 4、抱抱给她温暖，或者把手搓热来帮她捂小肚子。\n\n 饮食：\n 1、不要让她吃辛辣生冷等刺激性的食物，点餐的时候要细心的为她考虑到；\n 2、火锅啊、麻辣烫、冰激凌啊等等都是不能吃的，她再怎么想吃撒娇都不可以，这个时候可不能惯着她；\n 3、送红枣、阿胶枣、黑糖话梅等补气活血的食物给她，或者你亲自下厨给她熬个爱心粥，简直不能再暖；\n\n 暖心：\n 1、大姨妈来了她会有点儿小脾气，可不是她故意的哦，要耐心的爱护包容她；\n 2、不惹她生气，记得这个时候放低自己迁就她一下也没啥；\n 3、逗她开心，送送花、送送礼物、讲讲段子等等；\n 4、带她去喜欢的地方，看美丽的风景，吃好吃的东西；\n 5、心疼她太累，可以替她做她当天必须完成的任务；\n\n 冷水：\n 1、女生经期接触冷水不好，所以洗衣服、袜子、做饭这些活要全给包了；\n 2、准备些湿巾，一起出去需要洗手的时候用湿巾代替冷水\n\n 学习：\n 1、了解跟大姨妈有关的知识，弄清楚她是哪种痛，买一些相应的止痛药；\n 2、学会计算经期，了解她常用的卫生巾的牌子，日用还是夜用，长的还是短的，如果缺了就大胆去买，不用不好意思；\n\n 陪伴：\n 1、大姨妈随时都可能会痛，记得经常主动给亲爱的她打电话去关心；\n 2、在知道她难受的时候，不要让她一个人，陪伴她身边；\n 3、睡前轻轻地和她说晚安，这个阶段不可以熬夜，提醒她好好休息；";
        n3 = "  好好的爱护她，就像爱护小公主，女生是很感性的，她可以清楚的感受到所有这些事情背后，你那么爱她的那颗心";
        pagerbottm12.setVisibility(View.GONE);
        pagerbottm11.setVisibility(View.GONE);
        pagerbottm10.setVisibility(View.GONE);
        pagerbottm9.setVisibility(View.GONE);
        pagerbottm8.setVisibility(View.GONE);
        pagerbottm7.setVisibility(View.GONE);
        pagerbottm5.setVisibility(View.GONE);
        set(t, aut, be, t1, t2, t3, t4, t5, n1, n2, n3, n4, n5);

    }

    public void set(String t, String aut, String be, String t1, String t2, String t3, String t4, String t5, String n1,
                    String n2, String n3, String n4, String n5) {
        pagertop.setText(be);
        title.setText(t);
        title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        from.setText(aut);
        pagerbottm1.setText(t1);
        pagerbottm1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/ziti.TTF");
        pagerbottm2.setTypeface(face);
        pagerbottm2.setText(n1);
        pagerbottm3.setText(t2);
        pagerbottm3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        pagerbottm4.setText(n2);
        pagerbottm5.setText(t3);
        pagerbottm5.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pagerbottm6.setTypeface(face);
        pagerbottm6.setText(n3);
        pagerbottm7.setTypeface(face);
        pagerbottm7.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pagerbottm7.setText(t4);
        pagerbottm8.setTypeface(face);
        pagerbottm8.setText(n4);

        pagerbottm9.setText(t5);
        pagerbottm9.setTypeface(face);
        pagerbottm9.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        pagerbottm10.setTypeface(face);
        pagerbottm10.setText(n5);

    }
}
