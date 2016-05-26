package com.team.qingtai.activity.FourFragment_Activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
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

public class NewPasswordActivity extends BaseActivity {
    private EditText new1, new2;
    private Button submit;
    private RequestQueue rq;
    private ImageView iv2;
    //  private MyApplication myApplication;
    private String nowName;
    private RelativeLayout back;
    private TextView title;
    private Boolean twiceloadsame, twice;
    private TextView wrongtips;
    public String connecturi = "115.28.70.57";
    private CustomProgressDlg mProgressDialog;
    private String emailName;
    private TextView addinformationset;
    private String emailname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        receiveIntent();
        initView();
        setListener();
    }

    private void receiveIntent() {
        Intent intent = getIntent();
        intent.getStringExtra("email");
        emailname = intent.getStringExtra("email");
    }

    private void initView() {
        addinformationset = (TextView) findViewById(R.id.addinformationset);
        addinformationset.setVisibility(View.GONE);
        title = (TextView) findViewById(R.id.addinformationtitle);
        title.setText("设置新密码");
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        wrongtips = (TextView) findViewById(R.id.changepasswrongtip);
        iv2 = (ImageView) findViewById(R.id.testpasswordformaticon1);
        new1 = (EditText) findViewById(R.id.setnewpassword);
        new2 = (EditText) findViewById(R.id.repeatnewpassword);
        submit = (Button) findViewById(R.id.confirmchangepassword);
    }

    private void setListener() {
        new1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                iv2.setVisibility(ImageView.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Pattern pattern = Pattern.compile("^([0-9|A-Z|a-z]{6,20})");
                Matcher matcher = pattern.matcher(new1.getText().toString());
                if (matcher.matches()) {
                    iv2.setBackgroundResource(R.drawable.skin_check_icon);
                    iv2.setVisibility(ImageView.VISIBLE);
                } else {
                    iv2.setBackgroundResource(R.drawable.msp_error);
                    iv2.setVisibility(ImageView.VISIBLE);
                }
            }
        });
        new2.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                wrongtips.setVisibility(View.GONE);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                if (new2.getText().toString().equals(new1.getText().toString())) {
                    twiceloadsame = true;
                    wrongtips.setVisibility(View.GONE);
                } else {
                    wrongtips.setVisibility(View.VISIBLE);
                    twiceloadsame = false;
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (twiceloadsame) {
                    Pattern pattern = Pattern.compile(
                            "^(([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$)|^([0-9|A-Z|a-z]{6,20})");
                    Matcher matcher = pattern.matcher(new1.getText().toString());
                    if (matcher.matches()) {
                        mProgressDialog = CustomProgressDlg.show(NewPasswordActivity.this, "正在提交...", false, null);
                        mProgressDialog.setCanceledOnTouchOutside(false);
                        changeCode(nowName);
                    } else {
                        Toast.makeText(getApplicationContext(), "格式不正确", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(NewPasswordActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // **************************8用户名和新密码
    public void changeCode(String name) {
        JSONObject jso = new JSONObject();
        try {
            jso.put("version", "v1.0").put("data", new JSONObject().put("email", emailName)
                    .put("password", new1.getText().toString()));
        } catch (Exception e) {

        }
        JsonObjectRequest jsorequest = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "findPassword/updataPassword.php", jso,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        mProgressDialog.dismiss();
                        // TODO Auto-generated method stub
                        Log.d("nuanbaotext", "修改密码:" + response.toString());
                        try {
                            if (response.getInt("code") == 0) {
                                setToastBytTime(NewPasswordActivity.this, "密码修改成功", 1000);
                            } else {
                                setToastBytTime(NewPasswordActivity.this, "密码错误", 1000);
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
                Toast.makeText(NewPasswordActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
        MyApplication.requestQueue.add(jsorequest);
    }


    public void setToastBytTime(Context c, String info, int time) {
        final Toast toast = Toast.makeText(c, info, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                toast.cancel();
                finish();
            }
        }, time);
    }

}
