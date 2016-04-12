package com.team.qingtai.activity.Twofragment_Activitys;

/**
 * Created by ymh on 2016/4/12.
 */

import com.facebook.drawee.view.SimpleDraweeView;
import com.team.qingtai.MyApplication;
import com.team.qingtai.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class knownews extends Activity {

    private RelativeLayout back;
    private TextView finish;
    private TextView title;
    private ListView lv;
    private String[] titles;
    private int[] imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knownews);
        MyApplication.getInstance().addActivity(this);
        title = (TextView) findViewById(R.id.addinformationtitle);
        finish = (TextView) findViewById(R.id.addinformationset);
        back = (RelativeLayout) findViewById(R.id.addinformationback);
        finish.setVisibility(Button.GONE);
        title.setText("姨妈说");
        lv = (ListView) findViewById(R.id.knownewslv);

        lv.setDividerHeight(6);
        titles = new String[]{"姨妈知多少", "读懂大姨妈期间的女孩子", "缓解姨妈痛的方法"};
        imageId = new int[]{R.drawable.konw1, R.drawable.konw2, R.drawable.konw3};
        lv.setAdapter(new adapter());
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                switch (position) {
                    case 0:
                        startActivity(new Intent(knownews.this, page.class));
                        break;
                    case 1:
                        startActivity(new Intent(knownews.this, page2.class));
                        break;
                    case 2:
                        startActivity(new Intent(knownews.this, page3.class));
                        break;
                }

            }
        });
    }

    public class adapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 3;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.tiexinnuanbaolistview, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.iv = (SimpleDraweeView) convertView.findViewById(R.id.knownewsimage);
                viewHolder.name = (TextView) convertView.findViewById(R.id.knownewstitle);
                viewHolder.name.setText(titles[position]);
                viewHolder.iv.setImageURI(Uri.parse("res:///" + imageId[position]));
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            return convertView;
        }

    }


    public class ViewHolder {
        SimpleDraweeView iv;
        TextView name;
    }
}

