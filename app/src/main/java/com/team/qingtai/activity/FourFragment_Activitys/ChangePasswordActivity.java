package com.team.qingtai.activity.FourFragment_Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
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

public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {
    EditText oldpassword, newpassword, newpassword2;
    private TextView tip;
    private boolean thesame = false;
    private TextView title;
    private RelativeLayout back;
    private TextView addinformationset;
    private CustomProgressDlg mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initView();
    }

    private void initView() {
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("修改密码");
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        back.setOnClickListener(this);
        addinformationset = (TextView) findViewById(R.id.addinformationset);
        addinformationset.setVisibility(View.GONE);

        tip = (TextView) findViewById(R.id.tip);
        oldpassword = (EditText) findViewById(R.id.oldpassword);
        newpassword = (EditText) findViewById(R.id.newpassword);
        newpassword2 = (EditText) findViewById(R.id.newpassword2);
        newpassword2.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                tip.setVisibility(View.GONE);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                if (!newpassword.getText().toString().trim().equals(newpassword2.getText().toString().trim())) {
                    thesame = false;
                    tip.setVisibility(View.VISIBLE);
                } else {
                    thesame = true;
                    tip.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                if (thesame) {
                    mProgressDialog = CustomProgressDlg.show(ChangePasswordActivity.this, "正在提交...", false, null);
                    mProgressDialog.setCanceledOnTouchOutside(false);
//                    changeCode();
                } else {
                    Toast.makeText(ChangePasswordActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.addinformationback:
                finish();
                break;
            default:
                break;
        }
    }

    public void changeCode(String name) {
        JSONObject jso = new JSONObject();
        try {
            jso.put("version", "v1.0").put("data", new JSONObject().put("username", name)
                    .put("new_password", newpassword.getText()).put("old_password", oldpassword.getText()));
        } catch (Exception e) {

        }
        JsonObjectRequest jsorequest = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "user/reset_password.php", jso,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mProgressDialog.dismiss();
                        // TODO Auto-generated method stub
                        try {
                            if (response.getInt("code") == 0) {
                                Toast.makeText(ChangePasswordActivity.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ChangePasswordActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(ChangePasswordActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
        MyApplication.requestQueue.add(jsorequest);
    }
}
