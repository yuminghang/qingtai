package com.team.qingtai.activity.FourFragment_Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;
import com.team.qingtai.adapter.MyCollectionActivity_ListAdapter;
import com.team.qingtai.api.Urls;
import com.team.qingtai.base.BaseActivity;
import com.team.qingtai.bean.CollectionBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCollectionActivity extends BaseActivity {

    private ListView listView;
    private JSONObject myjson;
    private List<CollectionBean.DataEntity> list = new ArrayList<CollectionBean.DataEntity>();
    private TextView addinformationtitle;
    private TextView addinformationset;
    private RelativeLayout addinformationback;
    private Button scan_blog_oper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        System.out.println("----------------qqq-----" + Thread.currentThread().getId());
        initView();
        getDataFromServer();
    }

    private void initView() {
        addinformationtitle = (TextView) findViewById(R.id.addinformationtitle);
        addinformationset = (TextView) findViewById(R.id.addinformationset);
        scan_blog_oper = (Button) findViewById(R.id.scan_blog_oper);
        scan_blog_oper.setVisibility(View.VISIBLE);
        scan_blog_oper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        addinformationback = (RelativeLayout) findViewById(R.id.addinformationback);
        addinformationback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        addinformationset.setVisibility(View.GONE);
        addinformationtitle.setText("我的收藏");
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyCollectionActivity.this, ScanCollectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("pos", list.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(MyCollectionActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getDataFromServer() {
        try {
            myjson = new JSONObject();
            JSONObject son = new JSONObject();
            son.put("number", 20);
            son.put("start_index", 0);
            myjson.put("data", son);
            myjson.put("version", "v1.0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, Urls.CollectionUrl, myjson,
                new Response.Listener<JSONObject>() {
                    //此方法运行在UI线程
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("sadasdsad", "response -> " + response.toString());
                        Gson gson = new Gson();
                        CollectionBean collectionBean = gson.fromJson(response.toString(), CollectionBean.class);
                        list = collectionBean.getData();
                        listView.setAdapter(new MyCollectionActivity_ListAdapter(MyCollectionActivity.this, list));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("sada1sdsad", error.getMessage(), error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                headers.put("Content-Type", "application/json; charset=UTF-8");
                headers.put("cookie", MyApplication.getInstance().getCookie());
                return headers;
            }
        };
        MyApplication.getInstance().requestQueue.add(jsonRequest);
    }
}
