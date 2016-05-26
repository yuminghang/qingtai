package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;
import com.team.qingtai.view.CustomProgressDlg;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPasswordActivity extends BaseActivity {

    private TextView title;
    private RelativeLayout back;
    private TextView addinformationset;
    private TextView email;
    private Button send;
    private ImageView iv1;
    private Boolean emailnamebo;
    private CustomProgressDlg mProgressDialog;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        initView();
        setListener();
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.showright1);
        addinformationset = (TextView) findViewById(R.id.addinformationset);
        addinformationset.setVisibility(View.GONE);
        email = (TextView) findViewById(R.id.email);
        title = (TextView) findViewById(R.id.addinformationtitle);
        send = (Button) findViewById(R.id.send);
        title.setText("找回密码");
        back = (RelativeLayout) findViewById(R.id.addinformationback);
    }

    private void setListener() {
        email.setSingleLine(true);
        email.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                iv1.setVisibility(ImageView.GONE);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                Pattern pattern = Pattern.compile("^(([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$)");
                Matcher matcher = pattern.matcher(email.getText().toString());
                if (matcher.matches()) {
                    iv1.setBackgroundResource(R.drawable.skin_check_icon);
                    iv1.setVisibility(ImageView.VISIBLE);
                    emailnamebo = true;
                } else {
                    iv1.setBackgroundResource(R.drawable.msp_error);
                    iv1.setVisibility(ImageView.VISIBLE);
                    emailnamebo = false;
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")) {
                    Toast.makeText(FindPasswordActivity.this, "信息未填写完整", Toast.LENGTH_SHORT).show();
                } else if (!emailnamebo) {
                    Toast.makeText(FindPasswordActivity.this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ((!(email.getText().toString().isEmpty())) && (count == 0)) {
                    //testPassword();
                    findPasswords();
                    mProgressDialog = CustomProgressDlg.show(FindPasswordActivity.this, "正在提交...", false, null);
                    mProgressDialog.setCanceledOnTouchOutside(false);
                }
            }
        });
    }

    private void findPasswords() {
        JSONObject json = new JSONObject();
        try {
            json.put("version", "v1.0").put("data", new JSONObject().put("email", email.getText().toString())
                    //json.put("version", "v1.0").put("email", email.getText().toString()
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsp = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "findPassword/sendEmail.php", json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub
                        Log.d("nuanbaotext", "找回结果：" + response.toString());
                        count = 1;
                        mProgressDialog.dismiss();
                        try {
                            if ((Integer) response.get("code") == 0) {

                                setToastBytTime(FindPasswordActivity.this, "提交成功", 1000);

                            } else {
                                count = 0;
                                showExitDlg();
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                mProgressDialog.dismiss();
                Toast.makeText(FindPasswordActivity.this, "请检查网路连接", Toast.LENGTH_SHORT).show();
            }
        });
        MyApplication.requestQueue.add(jsp);
    }

    private void showExitDlg() {
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.submitemail_error_dialog);
        TextView ok = (TextView) window.findViewById(R.id.add_blog_alertdlg_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dlg.dismiss();
            }
        });
    }

    public void setToastBytTime(Context c, String info, int time) {
        final Toast toast = Toast.makeText(c, info, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                toast.cancel();
                Intent intent = new Intent(FindPasswordActivity.this, VerifyCodeActivity.class);
                intent.putExtra("email", email.getText().toString());
                startActivity(intent);
                finish();
            }
        }, time);
    }
}
