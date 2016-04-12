package com.team.qingtai.activity.Twofragment_Activitys;

/**
 * Created by ymh on 2016/4/12.
 */

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class nuannanplan2 extends Activity {
    private ImageView iv, bottomimage;
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
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        iv = (ImageView) findViewById(R.id.pagerimage);
        bottomimage = (ImageView) findViewById(R.id.pagerbottomimage);
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
        int image = 0;
        int bottomimage = 0;
        int i = getIntent().getIntExtra("num", 1);
        switch (i) {
            case 1:
                titt.setText("红糖姜茶");
                t = "红糖姜茶";
                aut = "小嗯";
                be = "现在很多女生体质虚寒、姨妈来的时候常常痛得死去活来，分分钟变身惹人怜爱的弱女子，此时身为男生的你，一定也心疼的不得了。小嗯为你精心推荐，这个时候你可以给她送上一杯暖暖的红糖姜茶，满满的都是爱呀，记得一定要送过去哦！";
                t1 = "红糖养血，生姜驱寒";
                n1 = "两者结合最适合补气活血，温经散寒。红糖姜茶还有预防感冒、暖宫、治痛经的功效。现在普通药店和大型超市都可以买到红糖姜茶的粉剂，小包分装，一包一杯，直接冲饮就好。如果女友喝不惯红糖的味道，也可以买红枣姜茶。当然要是你有时间，也有装备，能亲自下厨给她熬就最好不过了，简直就是最佳男友。\n\n其实做法也很简单，在这里教给大家。\n\n  1)将红糖、去核红枣，少量切片生姜放入熬制的容器中；\n\n  2)注入适量清水（用矿泉水最好）；\n\n  3)盖上盖子后，熬半个小时左右就可以盛出来了；\n\n红糖姜茶一定要趁热喝，最好白天饮用，晚上喝的话会容易上火。加了生姜喝起来会有些辣，是正常的味道，如果女朋友喝不太惯，姜可以再少放些。";
                image = R.drawable.hongtang;
                pagerbottm12.setVisibility(View.GONE);
                pagerbottm11.setVisibility(View.GONE);
                pagerbottm10.setVisibility(View.GONE);
                pagerbottm9.setVisibility(View.GONE);
                pagerbottm8.setVisibility(View.GONE);
                pagerbottm7.setVisibility(View.GONE);
                pagerbottm6.setVisibility(View.GONE);
                pagerbottm5.setVisibility(View.GONE);
                pagerbottm4.setVisibility(View.GONE);
                pagerbottm3.setVisibility(View.GONE);
                set(image, t, aut, be, t1, t2, t3, t4, t5, n1, n2, n3, n4, n5, bottomimage);
                break;
            case 2:
                titt.setText("红枣");
                t = "红枣";
                aut = "小嗯";
                be = "红枣有补气养血，健脾益胃的功效，内含丰富的蛋白质、糖份、胡萝卜素、维生素及磷、钙、铁等，有维生素丸的美称。女生大姨妈期间身体流失大量血液，损失不少铁，那么红枣就是极佳的食补之物。";
                n1 = "红枣可以直接洗净食用，或者用开水冲泡。当然如果方便下厨，还可以熬制爱心红枣粥。在购买时　鲜枣维生素含量更丰富；但是它有时令性，不能常买到，而且多吃可能伤害消化功能。干枣虽然维生素含量下降，但铁含量升高，而且其营养更易吸收，更适合食疗.\n\n\n红枣泡水：将洗好的干枣去核，掰开后放在杯中，加开水冲泡，待大枣泡软，杯中颜色变浅红就可做好了。\n\n\n爱心红枣粥：锅里的米煮开后，放入洗干净的大枣，如果喜欢吃枸杞的话，可以放入几粒枸杞一起煮粥，跟粥一起煮的大枣很甜软，非常滋补。 ";
                image = R.drawable.hongzao;
                pagerbottm12.setVisibility(View.GONE);
                pagerbottm11.setVisibility(View.GONE);
                pagerbottm10.setVisibility(View.GONE);
                pagerbottm9.setVisibility(View.GONE);
                pagerbottm8.setVisibility(View.GONE);
                pagerbottm7.setVisibility(View.GONE);
                pagerbottm6.setVisibility(View.GONE);
                pagerbottm5.setVisibility(View.GONE);
                pagerbottm4.setVisibility(View.GONE);
                pagerbottm3.setVisibility(View.GONE);
                set(image, t, aut, be, t1, t2, t3, t4, t5, n1, n2, n3, n4, n5, bottomimage);
                break;
            case 3:
                titt.setText("暖宝贴");
                t = "暖宝贴";
                aut = "小嗯";
                be = "女生在姨妈期间都会肚子痛，主要是由于宫冷引起的，因此在这期间内注意保暖就显得尤为重要，而暖宝贴正是大姨妈时的保暖利器。";
                n1 = "为了更贴心的照顾女生，小嗯为你贴心提示它的使用方法：\n\n\r  1.首先，要选择有品牌的“暖宝宝”，不能使用“三无产品”。\n\n\r  2.其次，不能直接贴在皮肤上。“暖宝宝”发热的最高温度可达60摄氏度，直接使用在皮肤上5分钟内即可造成低温烫伤。因此，要贴在内衣外侧，将其铺平就可以了。\n\n\r  3.再次，不要把“暖宝宝”长时间贴在同一部位，一方面皮肤在温热状态下不透气，另一方面也防止皮肤烫伤。\n\n\r  4.不适合与其他取暖工具一起使用。如果身上已经贴了“暖宝宝”，千万不要再使用取暖器等设备，以免局部温度过烫灼伤皮肤。\n\n\r  5.不能在睡觉时使用。睡觉时被子能起到保暖作用，使暖宝宝产生的热量不能散发出去，对人体造成损害。而且人体在睡眠时感知能力下降，更容易被烫伤。";
                image = R.drawable.nuanbaobao;
                pagerbottm12.setVisibility(View.GONE);
                pagerbottm11.setVisibility(View.GONE);
                pagerbottm10.setVisibility(View.GONE);
                pagerbottm9.setVisibility(View.GONE);
                pagerbottm8.setVisibility(View.GONE);
                pagerbottm7.setVisibility(View.GONE);
                pagerbottm6.setVisibility(View.GONE);
                pagerbottm5.setVisibility(View.GONE);
                pagerbottm4.setVisibility(View.GONE);
                pagerbottm3.setVisibility(View.GONE);
                set(image, t, aut, be, t1, t2, t3, t4, t5, n1, n2, n3, n4, n5, bottomimage);
                break;
            case 4:
                titt.setText("电暖宝");
                t = "电暖宝";
                aut = "小嗯";
                be = "电暖宝保暖时间长，便携安全，可爱的包装更能满足小女生们的少女心，身为男票的你如果把萌萌的暖宝送给她，温暖就会一直环绕哦。";
                n1 = "下面小嗯为你贴心推荐一些挑选电暖宝的方法：";
                t2 = "购买前仔细看商品说明";
                n2 = "你需要查看包装上的厂家名称、地址和联系资料等相关信息，另外还要看看产品是否具备电器产品的相关认证、检验合格证，如果发现没有或模糊不清，那也很可能是山寨产品，建议大家在购买时看清楚。";
                t3 = "根据电暖宝的面料来挑选";
                n3 = "目前市场上销售的电暖宝面料主要有PVC材料、丝光布材料和绒布材料几种：PVC材料手感较硬，易老化，牢固度一般，加热后烫手，属于低端淘汰产品；丝光布材料手感柔软，牢固度高，加热后烫手度适中，但手感一般，属于中端产品；而绒布材料手感舒适，加热后不烫手，牢固度好，是目前最好的电暖宝采用的面料。";
                t4 = "留意充电线的质量";
                n4 = "首先看充电线的粗细，充电线够粗，那样大电流才有安全通过的保证。另外看长度，充电线的长度不能太短，否则会影响充电，在使用过程中会觉得非常的不方便。最后看看插头的电源触片要有一定的厚度，太薄的质量差，不太安全。而且不要贪图便宜，毕竟一分钱一分货，为了自身的安全买一个既舒适又高质量的电暖宝。";
                image = R.drawable.diannuanbao;
                pagerbottm12.setVisibility(View.GONE);
                pagerbottm11.setVisibility(View.GONE);
                pagerbottm10.setVisibility(View.GONE);
                pagerbottm9.setVisibility(View.GONE);
                set(image, t, aut, be, t1, t2, t3, t4, t5, n1, n2, n3, n4, n5, bottomimage);
                break;
            case 5:
                titt.setText("姨妈巾");
                t = "姨妈巾";
                aut = "小嗯";
                be = "爱不一定要用玫瑰来表达，第一盒男朋友买的卫生巾对女孩来说绝对是一件温暖的事情。小嗯鼓励男生多从生活的细节去关心、照顾自己的女朋友。";
                t2 = "1、最佳男友第一步：了解卫生巾";
                n2 = "生理期是女生身体最脆弱的时候，因此更需要特别的呵护。卫生巾是女生在生理期的“好伙伴”，所以为女朋友购买安全、卫生、可靠的卫生巾变得尤为重要。卫生巾一般由表面层、吸收层和底层三部分构成，表层一般为干爽网面型和轻柔棉面型，中层、底层都以透气材料制成，一般有薄厚、长短、日用夜用等区分； ";
                t3 = "2、最佳男友第二步：购买方法";
                n3 = "  1)首先要了解女朋友的生理问题：量多棉面型不够用，可以考虑网面型，网面独有的漏斗设计可以让吸收量变大，还是不行那就试试夜用加长加厚型；\n\n  2)其次还要知道女朋友的肤质：如果易过敏，不要买含药物、香味的卫生巾了，药用或者带香味的卫生棉成分复杂，香料或者抑菌成分不明，很容易造成过敏；网面型也要慎用，上面的纤维同样容易过敏，产生瘙痒红斑等症状，最好选择真全棉、纯棉表层的卫生巾。\n\n  3)还有要选合适的类型：卫生巾的类型各异，作用也各异，要根据经期的需要适时选择合适的卫生巾，如睡觉要用夜用型，，白天要用日用型，运动时用运动型，柔软又动感，贴身防侧漏，经期末期使用护垫，另外还有缓解痛经、预防炎症等药效的卫生巾也可以选用。\n  最后观察外包装：选购卫生巾时要认清外包装上的品牌、厂家、地址、生产批号、生产日期等，另外为卫生巾的卫生安全最为担忧要观察是否有卫生许可证准销文号";
                n4 = "常用卫生巾品牌如下：";
                t5 = "3、最佳男友第三步：注意事项";
                n5 = "  1)卫生巾干燥存储：卫生巾应放在空气干燥、卫生的环境里，卫生巾受潮后有可能滋生细菌，不应再使用。\n\n  2)使用时注意有效期：任何卫生用品都有生产日期，自然也有有效期，购买卫生巾时不可为了图省事，一次批量购买太多，若卫生巾超过有效期超过期限也就没有无菌的保障，有可能会变质、滋生细菌，所以就不能再使用。";
                pagerbottm12.setVisibility(View.GONE);
                pagerbottm11.setVisibility(View.GONE);
                image = R.drawable.yimajin;
                bottomimage = R.drawable.yimapingpai;

                set(image, t, aut, be, t1, t2, t3, t4, t5, n1, n2, n3, n4, n5, bottomimage);
                break;

            case 6:
                titt.setText("避孕方法");
                t = "避孕方法";
                aut = "小嗯";
                be = "避孕的方法很多，但并不是每一种都安全有效，很多方法都可能会失败，导致意外怀孕。所以避孕一定要选择最安全的方法。在女生易孕期间发生关系的时候要特别注意，因为这个期间的怀孕率是很高的，不要一不留心，毁了两个人。还有在女友的姨妈期间尽量减少性行为，因为这样会给女生很大的压力，也有可能会使她们的身体受到损伤。";
                n1 = "避孕方法繁多，有安全期避孕、工具避孕以及药物避孕等。";
                t2 = "1、安全期避孕  ";
                n2 = "安全期的计算方法：自下次月经前倒数14天，即为排卵期。在排卵期的前5天至后4天的10天内为易孕期，其余时间为安全期。避免在排卵前5天、排卵后5天时间内性生活。注意事项：月经不规律者不适合。意外受孕者较多。";
                t3 = "2、工具避孕";
                n3 = "男性的主要避孕工具是避孕套，相信男生应该都知道这是什么东西吧，不知道那就自己赶快网上查查科普一下。女性也有专用的避孕套，不过使用起来相对麻烦一些。";
                t4 = "3、药物避孕";
                n4 = "根据药物的作用时间分为短效、速效、长效及紧急避孕药和避孕药缓释系统。\n\n  1)复方短效口服避孕药：应用最早、最多。国产的有避孕1号、2号和0号。其他有妈富隆、敏定偶等。  注意事项：服药期间不能漏服，若忘记服药，次日晨应补上。\n\n  2)速效口服避孕药（探亲避孕药）：服用时不受经期限制，在月经周期的任何一天开始服用，都能发挥避孕效果。\n\n  3)紧急避孕药：目前应用较多的是米非司酮和毓婷。两药服用方法相同。  注意事项：首次服药越早越好；确定本周期内仅有一次无保护性性生活；本周期内再有性生活需要严格避孕；紧急避孕不能当作常规避孕。\n\n注意：在使用药物的时候需要特别小心，不要造成不必要的身体伤害。";
                image = R.drawable.biyun;
                pagerbottm12.setVisibility(View.GONE);
                pagerbottm11.setVisibility(View.GONE);
                pagerbottm10.setVisibility(View.GONE);
                pagerbottm9.setVisibility(View.GONE);
                set(image, t, aut, be, t1, t2, t3, t4, t5, n1, n2, n3, n4, n5, bottomimage);
                break;
        }

    }

    public void set(int image, String t, String aut, String be, String t1, String t2, String t3, String t4, String t5, String n1,
                    String n2, String n3, String n4, String n5, int bottoimage) {
        pagertop.setText(be);
        iv.setImageResource(image);
        bottomimage.setImageResource(bottoimage);
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
