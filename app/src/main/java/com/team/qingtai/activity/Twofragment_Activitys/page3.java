package com.team.qingtai.activity.Twofragment_Activitys;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class page3 extends Activity {
    private ImageView iv;
    private TextView title, from, pagertop, pagerbottm1, pagerbottm4, pagerbottm3, pagerbottm5,
            pagerbottm6, pagerbottm7, pagerbottm2, pagerbottm8, pagerbottm9, pagerbottm10, pagerbottm11, pagerbottm12;
    private RelativeLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paper);
        MyApplication.getInstance().addActivity(this);

        back = (RelativeLayout) findViewById(R.id.addinformationback);
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                page3.this.onBackPressed();
            }
        });
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

        pagertop.setText("大姨妈一来，很少能雁过无痕，不带走一片云彩，多数情况都是让你的小公举翻江倒海，折腾到死去活来，那么问题来了，姨妈痛到底是怎么回事儿？ ");


        iv.setImageResource(R.drawable.page3);
        title.setText("缓解姨妈痛的方法");
        title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        from.setText("小嗯");
        pagerbottm1.setText("1、什么是姨妈痛？");
        pagerbottm1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/ziti.TTF");
        pagerbottm2.setTypeface(face);
        String str = "姨妈痛即痛经，是因为在大姨妈前后或期间，女生身体发虚，寒气比较多，受凉时，血液为了让身体迅速回温，快将体温分散到全身各处，而子宫对温度变化更敏感，温度降低后就会收缩引起痛经，严重的话会剧烈腹痛，面色苍白，手足冰冷，甚至昏厥。痛经常持续数小时或l—2天，一般经血畅流后，腹痛缓解。";
        pagerbottm2.setText(str);
        pagerbottm3.setText("2、怎么缓解？");
        pagerbottm3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        pagerbottm4.setText("不同女生痛的也不是同一种经，对症缓解，效果当然更好。");
        pagerbottm5.setText("A.阳虚内寒型");
        pagerbottm5.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pagerbottm6.setTypeface(face);
        pagerbottm6.setText(
                "特征：经期怕冷、手脚凉、腰腹凉，伴有腰酸腿软的症状；\n方法：\n1、每天泡一杯红茶生姜，加入新鲜的生姜，驱寒气；\n2、少吃生冷的食物，必须暂时告别冰激凌和各种冷饮，多吃温性的食物，干姜、红糖等；\n3、注意保暖，保持身体暖和将加速血液循环，可在小腹热敷垫或放上暖宝宝，还可以多喝热的药草茶或热柠檬汁；\n4、体育锻炼是暖身活血的，尤其在月经来临前夕，走路或从事其它适度的运动，将使你在月经期间较舒服；");
        pagerbottm7.setText("B.气滞血瘀型");
        pagerbottm7.setTypeface(face);
        pagerbottm7.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pagerbottm8.setTypeface(face);
        pagerbottm8.setText("特征：姨妈前或姨妈期间，胸口、肚子胀痛，心烦易怒；\n方法：\n1、食疗可以吃益母草煮鸡蛋，多吃点玫瑰花，山楂（不要太酸）、陈皮、佛手之类的理气活血的东西，少吃酸涩的东西，杏子、梅子之类的，酸涩的食物会收敛滞气；\n2、一定要控制好脾气，气滞血瘀，这几天生气对身体损伤很大；\n3、早起早睡不要熬夜啦，无论哪一种痛经类型，很大一部分都是“坏的生活习惯”造成的，这就要求女生健康生活，作息规律，保证睡眠；");

        pagerbottm9.setText("C.气血虚弱型");
        pagerbottm9.setTypeface(face);
        pagerbottm9.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        pagerbottm10.setTypeface(face);
        pagerbottm10.setText("特征：姨妈期间小肚子绵绵作痛，脸色苍白或蜡黄，头晕眼花，精神差，疲惫；\n方法：\n1、多吃补气血的食物，红枣、蜂蜜、乌鸡、牛羊肉之类的；\n2、尽量少吃苦的酸的食物，如果你能亲自下厨给她熬个红枣粥就再好不过了；\n3、每天坚持泡脚，跑到身体微微出汗为宜，可以改善身体血液循环驱逐寒冷，促进代谢；");


        pagerbottm11.setText("D.肝肾气虚损型");
        pagerbottm11.setTypeface(face);
        pagerbottm11.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        pagerbottm12.setTypeface(face);
        pagerbottm12.setText("特征：姨妈走后一两日出现腰酸腿软，小腹隐痛不适，或有潮热，头晕耳鸣\n方法：\n1、不要熬夜节食，拒绝饮酒和咖啡，推荐丹参煲鸡蛋；\n2、不要做剧烈运动，防止过度劳累；\n3、要好好调节心情不要闷闷不乐的；\n4、再推荐给大家一套揉肚子法，超级有效而且还有增进感情的好处哟，先将两手搓热，然后将两手放在女生小腹部，先由上至下按摩60次左右，再从左至右按摩60次，最后转圆按摩60次，以局部皮肤红润为宜，每日早晚各一次。\n\n\n最后，女生如果还是很难受，可以去买止痛药或者看医生，要多多关心女生。\n");
    }

}
