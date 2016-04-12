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

public class page2 extends Activity {
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
                page2.this.onBackPressed();
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
        pagertop.setText("女票又发火了？或者情绪低落到为一点小事就痛哭流涕？她或许并不清楚体内激素水平变化对情绪的影响，也搞不懂为什么有时候会看起来会娇羞可人，有时候却冷若冰霜？现在我们将为你仔细解读这个周期，更好的了解女生。 ");


        iv.setImageResource(R.drawable.paper1);
        title.setText("读懂大姨妈期间的女孩子");
        title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        from.setText("小嗯");
        pagerbottm1.setText("第一天到第七天（第一周即经期）：最敏感的一周");
        pagerbottm1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/ziti.TTF");
        pagerbottm2.setTypeface(face);
        String str = "这几天女性荷尔蒙大量流失，女生会极易疲倦，容易伤风感冒。根据调查显示，28%的女性在月经期内生病的可能性较平日更高，约有超过70%的女性感受到大姨妈之痛，伴随的症状还有胃痉挛和腹泻。经历这个时期时，要注意保暖和休息，此阶段女生的身材较其他时间会更加苗条，体态优美，皮肤也在一天天变得细嫩起来。";
        pagerbottm2.setText(str);
        pagerbottm3.setText("第八天到第十四天（第二周）：最性感的一周");
        pagerbottm3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        pagerbottm4.setText("这个时期女生荷尔蒙因为上周的大量流失，现在开始慢慢增加，皮肤也呈现前所未有的完美光泽。 月经刚刚结束时，雌激素的产生会日益恢复，血管里也日益丰富和饱含血液。这段时间女生会感觉状态特别良好，可以完成很多极具挑战性的工作。更神奇的是，即使你没有足够多的睡眠，这几天女生的皮肤仍能难以置信的红润、有光泽。 愉快的心情全写在女生的脸上，身边的人也会感受到了快乐。这段时期口才特佳，感官亦较为敏锐。");
        pagerbottm5.setText("第十五天到第二十二天（第三周）：爱撒娇的一周");
        pagerbottm5.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pagerbottm6.setTypeface(face);
        pagerbottm6.setText(
                "排卵后孕激素上升，女生会更喜欢的是温情脉脉的疼爱，变得小鸟依人，很容易感动，也很喜欢依赖，你可能会发现自己的女朋友忽然变得爱撒娇了，那一点儿也不奇怪。此时女生的身体和心理状况处于一个相对稳定的状态，不会感到情绪特别高涨，也不会特别沮丧，非常适合女生开始身体素质训练、皮肤养护计划等，往往可达到事半功倍的效果。");
        pagerbottm7.setText("第二十三天到第三十天（第四周）：最躁动的一周");
        pagerbottm7.setTypeface(face);
        pagerbottm7.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pagerbottm8.setTypeface(face);
        pagerbottm8.setText("这个时期女生雌、孕激素的分泌量逐渐减少，是处于情绪的最低潮期，易出现脾气暴躁、易怒、紧张、情绪波动。这个时期是女性身体很不稳定的时期，不要乱吃东西，很多人生理期痛就是因为在第四周吃了很多生冷的食物。女生要多吃能增加大豆黄铜素和女性荷尔蒙的食物，多补充营养，为下一周大量荷尔蒙流失做准备。最好喝些豆浆，玫瑰花茶，也可以吃一些粗粮，并且喝一些帮助清除体内垃圾的饮料，比如富含益生菌的酸奶和排毒的蜂蜜、金银花、菊花等。");
        pagerbottm9.setVisibility(View.GONE);
        pagerbottm10.setVisibility(View.GONE);
        pagerbottm11.setVisibility(View.GONE);
        pagerbottm12.setVisibility(View.GONE);
    }


}
