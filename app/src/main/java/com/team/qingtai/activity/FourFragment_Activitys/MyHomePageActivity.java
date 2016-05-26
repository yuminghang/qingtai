package com.team.qingtai.activity.FourFragment_Activitys;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.adapter.MyHomePageActivity_ListAdapter;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;
import com.team.qingtai.bean.MyHomePageBean;
import com.team.qingtai.view.CircleImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyHomePageActivity extends BaseActivity {

    private ListView listView;
    private View headView;
    private TextView nickname;
    private TextView introduce;
    private ImageView backImageView;
    private CircleImageView touxiang;
    private MyHomePageBean data;
    private List<MyHomePageBean.DataEntity> list = new ArrayList<>();
    private MyHomePageActivity_ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home_page);
        initView();
        getHeadViewData();
        getBlodData();
    }

    private void getBlodData() {
        JSONObject articles = new JSONObject();
        try {
            articles.put("version", "v1.0").put("data",
                    new JSONObject().put("user_id", MyApplication.getInstance().getUid()).put("start_index", 0).put("number", 10));
            Log.d("123", articles.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "article/get_user_articles.php", articles,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub
                        try {
                            int code = response.getInt("code");
                            if (code == 0) {
                                praseData(response);
//                                CacheArticles(response);
//                            } else {
//                                adapter.finishLoad(CommunityListAdapter.STATE_NONET);
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                adapter.finishLoad(CommunityListAdapter.STATE_NONET);
            }
        });
        MyApplication.requestQueue.add(stringRequest);
    }

    private void praseData(JSONObject response) {
        Gson gson = new Gson();

        data = gson.fromJson(response.toString(), MyHomePageBean.class);
        for (int i = 0; i < data.getData().size(); i++) {
            list.add(data.getData().get(i));
        }
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        headView = View.inflate(MyHomePageActivity.this, R.layout.myavatar, null);
        listView.addHeaderView(headView);
        adapter = new MyHomePageActivity_ListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    public void getHeadViewData() {
        JSONObject jso = new JSONObject();
        try {
            jso.put("version", "v1.0").put("id", MyApplication.getInstance().getUid());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        JsonObjectRequest js = new JsonObjectRequest(Request.Method.POST,
                Urls.BaseUrl + "user/get_user_info.php", jso,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub
                        JSONObject infor = new JSONObject();
                        try {
                            infor = response.getJSONObject("data");
                            loadHeadView(infor.getString("avatar").toString());
                            Log.d("nuanbaotext", "otherUserZhuye 转到主页获取个人信息:" + response.toString());
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        MyApplication.requestQueue.add(js);
    }

    private void loadHeadView(String url) {
        nickname = (TextView) headView.findViewById(R.id.nickName1);
        touxiang = (CircleImageView) headView.findViewById(R.id.touxiang);
        introduce = (TextView) headView.findViewById(R.id.introduceText1);
        backImageView = (ImageView) headView.findViewById(R.id.mebackImage1);
        Glide.with(MyHomePageActivity.this).load(Urls.MiddleImageUrl + url).into(touxiang);
    }
}
