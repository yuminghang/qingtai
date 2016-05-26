package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jauker.widget.BadgeView;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class guanyuapp extends BaseActivity implements View.OnClickListener {
    private TextView title, edit;
    private RelativeLayout back;
    private RelativeLayout xieyi, weixin, weibo, pingfen, versionupdate;
    private String m_appNameStr = "qingtai.apk";
    Handler m_mainHandler;
    private ProgressDialog m_progressDlg;
    private BadgeView bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanyuapp);
        initViews();
        setListener();
    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        xieyi.setOnClickListener(this);
        weixin.setOnClickListener(this);
        weibo.setOnClickListener(this);
        pingfen.setOnClickListener(this);
        versionupdate.setOnClickListener(this);
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("关于青苔");
        edit = (TextView) findViewById(R.id.addinformationset);
        edit.setVisibility(View.GONE);
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        xieyi = (RelativeLayout) findViewById(R.id.userxieyi);
        weixin = (RelativeLayout) findViewById(R.id.ourweixin);
        weibo = (RelativeLayout) findViewById(R.id.ourweibo);
        pingfen = (RelativeLayout) findViewById(R.id.guanyupingfen);
        versionupdate = (RelativeLayout) findViewById(R.id.versionupdate);
        m_mainHandler = new Handler();
        m_progressDlg = new ProgressDialog(this);
        m_progressDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        m_progressDlg.setIndeterminate(false);
        m_progressDlg.setCancelable(false);
        bv = new BadgeView(this);
        bv.setTargetView(versionupdate);
        bv.setMaxHeight(20);
        bv.setMaxWidth(20);
        bv.setBackground(10, Color.parseColor("#FF0000"));
        bv.setTextColor(getResources().getColor(R.color.viewfinder_laser));
        bv.setBadgeGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        bv.setBadgeMargin(0, 0, 40, 0);
    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        Intent in1 = new Intent(guanyuapp.this, ouraddressconnect.class);
        switch (v.getId()) {
            case R.id.userxieyi:
                startActivity(new Intent(guanyuapp.this, userxieyi.class));
                break;
            case R.id.guanyupingfen:
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.ourweixin:
                in1.putExtra("name", "微博");
                startActivity(in1);
                break;
            case R.id.ourweibo:
                in1.putExtra("name", "微信");
                startActivity(in1);
                break;
            case R.id.versionupdate:
                checkUpdate();
                break;
            default:
                break;
        }
    }

    private void checkUpdate() {
        double m_newVerCode = MyApplication.getInstance().getVersion();
//        double m_newVerCode =2.0;  //测试新版本
        double vercode = 0.0;
        try {
            vercode = Double.parseDouble(MyApplication.getVerName(guanyuapp.this));
        } catch (RuntimeException e) {
            e.printStackTrace();
            vercode = MyApplication.getVerCode(guanyuapp.this);
        }
        if (m_newVerCode > vercode) {
            doNewVersionUpdate();
        } else {
            notNewVersionDlgShow();
        }
    }


    private void notNewVersionDlgShow() {
        String verName = MyApplication.getVerName(this);
        String str = "当前版本:" + verName + "\n已是最新版，无需更新!";
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.guanyuapp_not_update_layout);
        TextView cancle = (TextView) window.findViewById(R.id.guanyuapp_update_cancle);
        TextView title = (TextView) window.findViewById(R.id.guanyuapp_update_title);
        title.setText(str);
        cancle.setText("确定");

        cancle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dlg.cancel();
            }
        });
    }

    private void doNewVersionUpdate() {
        String verName = MyApplication.getVerName(this);
        String str = "当前版本：" + verName + "\n发现新版本,是否更新";

        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.add_blog_alertdlg_layout);
        TextView cancle = (TextView) window.findViewById(R.id.add_blog_alertdlg_cancle);
        TextView ok = (TextView) window.findViewById(R.id.add_blog_alertdlg_ok);
        TextView title = (TextView) window.findViewById(R.id.add_blog_alertdlg_title);
        title.setText(str);
        cancle.setText("立即更新");
        ok.setText("暂不更新");
        cancle.setTextColor(getResources().getColor(R.color.top_color));
        ok.setTextColor(getResources().getColor(R.color.textColor));
        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                bv.setVisibility(View.VISIBLE);
                dlg.cancel();
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                m_progressDlg.setTitle("正在下载");
                m_progressDlg.setMessage("请稍候...");
                downFile(Urls.BaseUrl + "qingtaifinalone.apk");
            }
        });
    }

    private void downFile(final String url) {
        m_progressDlg.show();
        new Thread() {
            public void run() {
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(url);
                HttpResponse response;
                try {
                    response = client.execute(get);
                    HttpEntity entity = response.getEntity();
                    long length = entity.getContentLength();

                    m_progressDlg.setMax((int) length);

                    InputStream is = entity.getContent();
                    FileOutputStream fileOutputStream = null;
                    if (is != null) {
                        File file = new File(Environment.getExternalStorageDirectory(), m_appNameStr);
                        fileOutputStream = new FileOutputStream(file);
                        byte[] buf = new byte[1024];
                        int ch = -1;
                        int count = 0;
                        while ((ch = is.read(buf)) != -1) {
                            fileOutputStream.write(buf, 0, ch);
                            count += ch;
                            if (length > 0) {
                                m_progressDlg.setProgress(count);
                            }
                        }
                    }
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    down();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void down() {
        m_mainHandler.post(new Runnable() {
            public void run() {
                m_progressDlg.cancel();
                update();
            }
        });
    }

    void update() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory(), m_appNameStr)),
                "application/vnd.android.package-archive");
        startActivity(intent);
    }

}
