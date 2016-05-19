package com.team.qingtai.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;
import com.team.qingtai.bean.loginresponse;
import com.team.qingtai.utils.SPUtils;
import com.team.qingtai.view.CustomProgressDlg;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private CustomProgressDlg mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (NetUtils.isConnected(LoginActivity.this)) {
                if (name.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    mProgressDialog = CustomProgressDlg.show(LoginActivity.this, "正在登录...", false, null);
                    mProgressDialog.setCanceledOnTouchOutside(false);
                    loadserver(name.getText().toString(), password.getText().toString());
                }
//                } else {
//                    Toast.makeText(LoginActivity.this, "请检查网络连接", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    private void loadserver(final String name, final String password) {
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, Urls.LoginUrl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                loginresponse data = gson.fromJson(response.toString(), loginresponse.class);
                if (data.getCode() == 0) {
                    Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                    if (mProgressDialog != null) {
                        mProgressDialog.dismiss();
                    }
                    LoginActivity.this.finish();
                } else {
                    Toast.makeText(LoginActivity.this, "登陆失败！", Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "请检查网络连接", Toast.LENGTH_SHORT).show();
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                Map<String, String> map = new HashMap<String, String>();
                map.put("username", name.trim());
                map.put("password", password.trim());
                return map;
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String dataString = new String(response.data, "UTF-8");

                    Map<String, String> responseHeaders = response.headers;
                    String cookieVal = responseHeaders.get("Set-Cookie");
                    if (cookieVal != null) {
                        String sessionId = cookieVal.substring(0, cookieVal.indexOf(";"));
                        MyApplication.getInstance().setcookie(sessionId);
                    }
                    return Response.success(dataString, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                }
            }
        };
        MyApplication.requestQueue.add(stringRequest);
    }
}
