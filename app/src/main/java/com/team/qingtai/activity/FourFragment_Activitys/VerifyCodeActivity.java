package com.team.qingtai.activity.FourFragment_Activitys;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
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

public class VerifyCodeActivity extends BaseActivity {

    private EditText verifyCode;
    private TextView title;
    private RelativeLayout back;
    private Button submit;
    private CustomProgressDlg mProgressDialog;
    private int count = 0;
    private String emailname;
    private TextView addinformationset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);
        receiveIntent();
        initView();
    }

    private void receiveIntent() {
        Intent intent = getIntent();
        intent.getStringExtra("email");
        emailname = intent.getStringExtra("email");
    }

    private void initView() {
        addinformationset = (TextView) findViewById(R.id.addinformationset);
        addinformationset.setVisibility(View.GONE);
        verifyCode = (EditText) findViewById(R.id.verifycode);
        //  myApplication.addActivity(this);
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("找回密码");
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        submit = (Button) findViewById(R.id.confirm_verifycode);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if ((!verifyCode.getText().toString().isEmpty()) && (count == 0)) {
                    findPasswords();
                    mProgressDialog = CustomProgressDlg.show(VerifyCodeActivity.this, "正在提交...", false, null);
                    mProgressDialog.setCanceledOnTouchOutside(false);
                } else {
                    //Toast.makeText(FindPassword.this, "信息未填写完整", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void findPasswords() {
        count = 1;
        JSONObject json = new JSONObject();
        try {
            json.put("version", "v1.0").put("data", new JSONObject().put("email", emailname).put("verCode", verifyCode.getText().toString().trim()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsp = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "findPassword/returnVercode.php", json,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub
                        Log.d("nuanbaotext", "验证码结果：" + response.toString());
                        mProgressDialog.dismiss();
                        try {
                            if ((Integer) response.get("code") == 0) {
                                setToastBytTime(VerifyCodeActivity.this, "验证码正确", 1000);
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
                count = 0;
                mProgressDialog.dismiss();
                Toast.makeText(VerifyCodeActivity.this, "请检查网路连接", Toast.LENGTH_SHORT).show();
            }
        });
        MyApplication.requestQueue.add(jsp);
    }

    private void showExitDlg() {
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.verifyerror);
        // MyTextView cancle=(MyTextView) window.findViewById(R.id.add_blog_alertdlg_cancle);
        TextView ok = (TextView) window.findViewById(R.id.add_blog_alertdlg_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Intent intent = new Intent(VerifyCodeActivity.this, NewPasswordActivity.class);
                intent.putExtra("email_1", emailname);
                startActivity(intent);
                finish();
            }
        }, time);
    }
}
