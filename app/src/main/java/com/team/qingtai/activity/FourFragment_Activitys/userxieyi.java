package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

public class userxieyi extends Activity {
    private TextView title, edit;
    private RelativeLayout back;
    private TextView from, pagertop, pagerbottm1, pagerbottm4, pagerbottm3, pagerbottm5, pagerbottm6,
            pagerbottm7, pagerbottm2, pagerbottm8, pagerbottm9, pagerbottm10, pagerbottm11, pagerbottm12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_userxieyi);
        MyApplication.getInstance().addActivity(this);
        initViews();
        setListener();
        initData();
    }

    private void initData() {
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
        String t6 = null;
        String n6 = null;
        t = "青苔服务使用协议";
        be = "欢迎您使用青苔软件及服务。\n\n青苔在此特别提醒用户认真阅读、充分理解本《服务使用协议》，特别是免除或者限制青苔责任的免责条款及对用户的使用规则条款。除非您已阅读并接受本协议的所有条款，否则您无权下载、安装或使用本软件及相关服务。当您注册成功，无论是进入青苔，还是在青苔上发布任何内容。我们将视您已完全接受本协议项下的全部条款。";
        t1 = "使用规则";
        n1 = "  1.用户注册成功后，青苔将给予每一位用户唯一账号，由用户设置其密码。该账号和密码由用户负责保管并对其在该账号下的一切行为承担法律责任。\n  2.用户有责任妥善保管注册帐号信息及帐号密码的安全，用户需要对注册帐号以及密码下的行为承担法律责任。用户同意在任何情况下不使用其他成员的帐号或密码。在您怀疑他人在使用您的帐号或密码时，您同意立即通知青苔。\n  用户须对在青苔上的注册信息的真实性、合法性、有效性承担全部责任，用户不得冒充他人；不得利用他人的名义传播任何信息；不得恶意使用注册帐号导致其他用户误认；否则青苔有权立即停止提供服务，收回青苔帐号并由用户独自承担由此而产生的一切法律责任。\n  4.用户须承诺不得以任何方式利用青苔直接或间接从事违反法律或社会公德的行为。如发现此类事件发生，青苔有权对其内容予以删除，而由用户自己的行为造成的任何影响和责任甚至违法行为由用户自行承担。\n  5.青苔保留因业务发展需要，单方面对本服务的全部或部分服务内容在任何时候不经任何通知的情况下变更、暂停、限制、终止或撤销青苔服务的权利，用户需了解并承担此风险。\n  用户应遵守本协议的各项条款，正确、适当地使用本服务，如因用户违反本协议中的任何条款，青苔有权依据协议终止对违约用户帐号提供服务。同时，青苔保留在任何时候收回帐号、用户名的权利\n  7.青苔禁止用户利用青苔提供的服务制作、上传、复制、发表如下内容：\n    1)反对宪法所确定的基本原则的；\n    2)危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；\n    3)损害国家荣誉和利益的；\n    4)煽动民族仇恨、民族歧视，破坏民族团结的；\n    5)破坏国家宗教政策，宣扬邪教和封建迷信的；\n    6)散布谣言，扰乱社会秩序，破坏社会稳定的；\n    7)散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；\n    8)侮辱或者诽谤他人，侵害他人合法权益的；\n    9)含有法律、行政法规禁止的其他内容的信息。\n  8.青苔有权对用户使用青苔的情况进行审核和监督，对违反有关法律规定或本协议约定的行为，如侵犯、妨害、威胁任何人权利或安全的内容，假冒他人的行为，青苔有权依法停止传输任何前述内容，并有权依其自行判断对违反本条款的任何人士采取适当的法律行动，包括但不限于从青苔服务中删除具有违法性、侵权性、不当性等内容，终止违反者的成员资格，阻止其使用产品的全部或部分服务，并且依据法律法规保存有关信息并向有关部门报告等。";
        t2 = "隐私保护";
        n2 = "尊重用户个人隐私信息的私有性将是青苔的一贯原则，青苔将通过技术手段，强化内部管理机制等措施保护用户的个人隐私信息，除法律或有法律赋予权限的政府部门要求或用户同意等原因外，青苔承诺未经用户同意不对外公开或向第三方透露用户个人隐私信息。同时，为了运营和改善青苔的技术和服务，青苔将可能会自行收集使用或向第三方提供用户的非个人隐私信息，这将有助于青苔向用户提供更好的用户体验和提高产品的服务质量。";
        t3 = "知识产权";
        n3 = " 青苔鼓励用户创作作品，将作品投入青苔的官方邮箱（3322053240@qq.com），同时青苔尊重用户原创作品的内容。青苔将保护知识产权作为管护生存和发展的重要指标，承诺将保护知识产权作为青苔运营的基本原则之一。";
        t4 = "举报机制";
        n4 = "1.处理原则\n\n  青苔作为一款提供社区服务的产品，对言论自由和用户与用户，用户与企业之间权利的平衡给予高度的重视。依据法律法规对违法信息及个人进行删除，警告等措施是青苔社区的法定义务。青苔目前未与任何第三方机构合作开展此项业务。\n2.受理范围\n\n 受理青苔社区内侵犯企业或个人合法权益的侵权举报，包括但不限于涉及个人隐私、造谣、诽谤、恐吓及商业侵权。\n\n   个人隐私：发表的内容中直接或间接涉及他人身份信息，如姓名、家庭住址、证件号码、工作单位、私人电话等详细个人资料；\n\n    造谣、诽谤、恐吓：发表的内容中指明（包括你自然人和企业）的直接谩骂、侮辱、恐吓、恶意中伤、诽谤等；\n\n    商业侵权：发表的内容泄露企业商业机密或根据保密协议不能公开的内容。\n\n3.举报条件\n\n用户一经发现青苔上存在侵犯自身合法权益的内容，请立即与青苔取得联系（3322053240@qq.com）。为了保证问题及时有效地得到解决，用户提交的信息和材料务必真实有效，完整清晰，否则将不予受理。请用户参考以下格式：\n\n    权利人对涉及侵权内容拥有商标权、著作权和其他依法可以行使权利的权属证明；如果举报人非权利人，请举报人提供代表企业进行举报的书面授权证明\n\n    举报人需充分、明确地描述侵权者的侵权行为，提供涉及侵权内容在青苔上的具体页面地址，指明侵权内容中哪些内容侵犯了上述所提及到的合法权益\n\n    请权利人提供详细的联络信息，包括姓名、身份证复印件（针对自然人）、单位登记证明复印件（针对单位）、通信地址、联系电话、电子邮箱；\n\n4.处理流程\n\n  青苔承诺自收到举报的七个工作日内给予处理并回复。\n\n  如果青苔已将删除或处理的内容出现在百度、谷歌等搜索引擎，这是因为搜索引擎自带缓存，青苔无权处理，因此不接受申请。\n\n  用户在青苔中的任何行为所引起的法律纠纷，由事件方自行处理解决，与青苔无关。";
        t5 = "免责声明";
        n5 = "用户由于违反本《协议》或相关的服务条款的规定所导致或产生的任何第三方损害的，将由用户独立承担责任；青苔因此遭受损失的，用户也应一并赔偿\n\n2.青苔不保证用户发表的言论的正确性，请用户对其他网友的评论，回答等言论谨慎处理。\n\n3.用户在青苔发表的任何言论仅代表用户个人立场和观点，与青苔无关。发表者需对自己的任何言论负责，由此引发的一切纠纷，将由发表者承担全部法律责任及连带责任。青苔不承担任何法律及连带责任。\n\n4.用户因第三方如电信部门的通讯线路故障、技术问题、网络、电脑故障、系统不稳定性及其他各种不可抗力原因而遭受的一切损失，或因技术故障等不可抗事件影响到服务的正常运行的，青苔承诺在第一时间内与相关单位配合，及时处理进行修复，但用户因此而遭受的一切损失，青苔不承担任何责任。\n\n5.本产品提供的服务同大多数互联网产品服务一样，受包括但不限于用户原因、网络服务质量、社会环境等因素的差异影响，可能受到各种安全问题的侵扰，如他人利用用户的资料，造成现实生活中的骚扰；用户下载安装的其它软件或访问的其他网站中含有“特洛伊木马”等病毒，威胁到用户的手机信息和数据的安全，继而影响本服务的正常使用等等。用户应加强信息安全及使用者资料的保护意识，要注意加强密码保护，以免遭致损失和骚扰。";
        t6 = "协议修改";
        n6 = "1.根据互联网的发展和有关的法律、法规及规范性文件的变化，或者因业务发展需要，青苔有权修改或变更本协议。一旦协议内容发生变动，青苔将会第一时间公布修改后的协议内容，提醒用户查看修改的协议条款。\n\n2.如果不同意修改后的相关条款内容，用户有权并应当停止使用青苔。如果用户继续使用青苔，则视为用户已接受青苔对本协议相关条款所做的修改。";
        set(t, aut, be, t1, t2, t3, t4, t5, n1, n2, n3, n4, n5, t6, n6);
    }

    public void set(String t, String aut, String be, String t1, String t2, String t3, String t4, String t5, String n1,
                    String n2, String n3, String n4, String n5, String t6, String n6) {
        pagertop.setText(be);

        title.setText(t);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        from.setText(aut);
        from.setVisibility(View.GONE);
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

        pagerbottm11.setTypeface(face);
        pagerbottm11.setText(t6);

        pagerbottm12.setTypeface(face);
        pagerbottm12.setText(n6);

    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setVisibility(View.GONE);
        edit = (TextView) findViewById(R.id.addinformationset);
        edit.setVisibility(View.GONE);
        back = (RelativeLayout) findViewById(R.id.addinformationback);
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
    }
}
