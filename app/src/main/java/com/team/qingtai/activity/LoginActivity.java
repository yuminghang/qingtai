package com.team.qingtai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.activity.FourFragment_Activitys.FindPasswordActivity;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;
import com.team.qingtai.bean.loginresponse;
import com.team.qingtai.view.CustomProgressDlg;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private CustomProgressDlg mProgressDialog;
    private TextView zhaomima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        zhaomima = (TextView) findViewById(R.id.zhaomima);
        zhaomima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, FindPasswordActivity.class));
            }
        });
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
                    String version = data.getVersion();
                    version = version.replace("v", "");
                    MyApplication.getInstance().setVersion(Double.parseDouble(version));
                    getuserInfo(0);
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

    private void getuserInfo(final int isme) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("version", "v1.0");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "user/get_user_info.php", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("123", "手动登录：response user info-> " + response.toString());
                try {
                    int code = response.getInt("code");
                    Log.d("123", "code:" + code);
                    if (code == 0) {
                        Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                        JSONObject obj = response.getJSONObject("data");
//                        myapplication.setNickname(obj.getString("nickname"));
//                        myapplication.setAvatar(obj.getString("avatar"));
                        MyApplication.getInstance().setUid(obj.getInt("id"));
                        MyApplication.getInstance().setIsLogin(true);
//                        myapplication.setIntroduce(obj.getString("sign"));
//                        myapplication.setHobby(obj.getString("hobby"));
//                        myapplication.setLocation(obj.getString("location"));
//
//                        spE = getSharedPreferences("setting", MODE_PRIVATE).edit();
//                        spE.putString("nickname", obj.getString("nickname"));
//                        spE.putString("avatar", obj.getString("avatar"));
//                        spE.putString("sign", obj.getString("sign"));
//                        spE.putInt("userId", obj.getInt("id"));
//                        spE.putString("hobby", obj.getString("hobby"));
//                        spE.putString("location", obj.getString("location"));
//
//                        if (isme == 0) {
//                            spE.putString("thirdId", uid);
//                            spE.putString("password", null);
//                            spE.putString("username", null);
//                            DateFormat df = new SimpleDateFormat("yy-MM-dd");
//                            spE.putString("lastLoadTime", df.format(new Date()));
//                        } else {
//                            spE.putString("thirdId", null);
//                            spE.putString("password", usercode.getText().toString());
//                            spE.putString("username", username.getText().toString());
//                            DateFormat df = new SimpleDateFormat("yy-MM-dd");
//                            spE.putString("lastLoadTime", df.format(new Date()));
//                        }
//
//
//                        if (obj.getInt("gender") == 0) {
//                            myapplication.setGender("boy");
//                            spE.putString("gender", "boy");
//                        } else {
//                            myapplication.setGender("girl");
//                            spE.putString("gender", "girl");
//                        }
//                        int related_id = obj.getInt("relate_id");
//                        if (related_id == 0) {
//                            spE.putInt("Match", 0);
//                        } else {
//                            spE.putInt("Match", 2);
//                            getmatcherinfor(related_id);
//                            spE.putInt("Match_id", related_id);
//                        }
//
//                        if (obj.getInt("gender") == 0) {
//                            String circle = obj.getString("period");
//                            String tianshu = obj.getString("duration");
//                            String last_time = obj.getString("last_time");
//
//                            last_time = last_time.replace(" 00:00:00", "");
//                            if (!circle.equals("0") && !tianshu.equals("0")) {
//                                Log.d("nuanbaotext", "姨妈日期本地数据库已经修改");
//                                spE.putString("YMdays", tianshu);
//                                spE.putString("YMcircle", circle);
//                                spE.putString("YMlastTime", last_time);
//                            }
//                        }
//
//                        spE.commit();
//                        myapplication.setSessionId(sessionId);
//                        myapplication.setIsLoad(true);
//                        showToastBytTime(getApplicationContext(), "登录成功", 1000);
                        if (mProgressDialog != null) {
                            mProgressDialog.dismiss();
                        }
                    } else {
                        // Toast.makeText(getApplicationContext(),
                        // "获取用户信息失败", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
                        if (mProgressDialog != null) {
                            mProgressDialog.dismiss();
                        }
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    // Toast.makeText(getApplicationContext(),
                    // "获取用户信息失败", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
                    if (mProgressDialog != null) {
                        mProgressDialog.dismiss();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("123", error.getMessage(), error);
                Toast.makeText(getApplicationContext(), "请检查网络连接", Toast.LENGTH_SHORT).show();
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                headers.put("Content-Type", "application/json; charset=UTF-8");
                headers.put("Cookie", MyApplication.getInstance().getCookie());
                return headers;
            }
        };
        MyApplication.requestQueue.add(jsonRequest);
    }

}
