package com.team.qingtai.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.lzy.imagepicker.bean.ImageItem;
import com.team.qingtai.base.FormImage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ymh on 2016/5/24.
 */
public class PostUploadRequest extends Request<String> {

    private Response.Listener<String> mListener;
    /*请求 数据通过参数的形式传入*/
    private List<FormImage> mListItem;

    private String BOUNDARY = "--------------520-13-14"; //数据分隔线
    private String MULTIPART_FORM_DATA = "multipart/form-data";

    private int type;
    // private int referenceId;

    public PostUploadRequest(int type, String url, List<FormImage> listItem, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, errorListener);
        // TODO Auto-generated constructor stub
        this.mListener = listener;
        setShouldCache(false);
        mListItem = listItem;
        this.type = type;
        // this.referenceId=referenceId;
        //设置请求的响应事件，因为文件上传需要较长的时间，所以在这里加大了，设为5秒
        setRetryPolicy(new DefaultRetryPolicy(180000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        // TODO Auto-generated method stub
        try {
            String dataString = new String(response.data, "UTF-8");
            return Response.success(dataString, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(String response) {
        // TODO Auto-generated method stub
        mListener.onResponse(response);
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        // TODO Auto-generated method stub
        if (mListItem == null || mListItem.size() == 0) {
            return super.getBody();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int N = mListItem.size();
        String[] myfile = new String[N];
        myfile[0] = "";
        for (int j = 1; j < myfile.length; j++) {
            myfile[j] = j + "";
        }
        FormImage formImage;
        for (int i = 0; i < N; i++) {

            formImage = mListItem.get(i);
            StringBuffer sb = new StringBuffer();
            /*第一行*/
            //`"--" + BOUNDARY + "\r\n"`
            sb.append("--" + BOUNDARY);
            sb.append("\r\n");
            /*第二行*/
            //Content-Disposition: form-data; name="参数的名称"; filename="上传的文件名" + "\r\n"
            sb.append("Content-Disposition: form-data;");
            sb.append(" name=\"");
            sb.append(formImage.getmName() + myfile[i]);
            sb.append("\"");
            sb.append("; filename=\"");
            sb.append(formImage.getmFileName());
            sb.append("\"");
            sb.append("\r\n");
            /*第三行*/
            //Content-Type: 文件的 mime 类型 + "\r\n"
            sb.append("Content-Type: ");
            sb.append(formImage.getmMime());
            sb.append("\r\n");
            /*第四行*/
            //"\r\n"
            sb.append("\r\n");
            try {
                bos.write(sb.toString().getBytes("utf-8"));
                /*第五行*/
                //文件的二进制数据 + "\r\n"
                bos.write(formImage.getValue());
                bos.write("\r\n".getBytes("utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*结尾行*/
            //`"--" + BOUNDARY + "--" + "\r\n"`
//            String endLine = "--" + BOUNDARY + "--" + "\r\n";
//            try {
//                bos.write(endLine.toString().getBytes("utf-8"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }


        setParams(bos, "type", this.type);
        return bos.toByteArray();
    }

    @Override
    public String getBodyContentType() {
        return MULTIPART_FORM_DATA + "; boundary=" + BOUNDARY;
    }

    private void setParams(ByteArrayOutputStream bos, String name, int value) {
        StringBuffer sb = new StringBuffer();
        /*第一行*/
        //`"--" + BOUNDARY + "\r\n"`
        sb.append("--" + BOUNDARY);
        sb.append("\r\n");
        /*第二行*/
        //Content-Disposition: form-data; name="name" "\r\n"
        sb.append("Content-Disposition: form-data;");
        sb.append(" name=\"");
        sb.append(name);
        sb.append("\"");
        sb.append("\r\n");
        /*第三行*/
        // "\r\n"
        sb.append("\r\n");
        /*第四行*/
        //"\r\n"
        sb.append(value);
        sb.append("\r\n");
        try {
            bos.write(sb.toString().getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    /*结尾行*/
        //`"--" + BOUNDARY + "--" + "\r\n"`
        String endLine = "--" + BOUNDARY + "--" + "\r\n";
        try {
            bos.write(endLine.toString().getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

