package com.example.samsung.myandroid;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import java.util.*;
/**
 * Created by samsung on 2015/4/21.
 */
public class two extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Button btn3=(Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txt =(EditText)findViewById(R.id.editText3);
                EditText txt2 =(EditText)findViewById(R.id.editText4);
                EditText txt3 =(EditText)findViewById(R.id.editText5);
                EditText txt4 =(EditText)findViewById(R.id.editText6);
                EditText txt5 =(EditText)findViewById(R.id.editText7);
                String username = txt.getText().toString();
                String password = txt2.getText().toString();
                String iphone =txt3.getText().toString();
                String city =txt4.getText().toString();
                String region =txt5.getText().toString();
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);
                params.put("iphone", iphone);
                params.put("city", city);
                params.put("region", region);
                List list = new ArrayList();
                list.add(params);
                try {
                    HttpParams httpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(httpParams,5000); //设置连接超时为5秒
                    HttpClient client = new DefaultHttpClient(httpParams); // 生成一个http客户端发送请求对象
                    String urlString ="http://10.0.2.2:8080/testhttp1/TestServlet";
                    HttpPost httpPost = new HttpPost(urlString); //设定请求方式
                    if (list!=null && list.size()!=0) {
                        //把键值对进行编码操作并放入HttpEntity对象中
                        httpPost.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
                    }
                    HttpResponse httpResponse = client.execute(httpPost); // 发送请求并等待响应
                    // 判断网络连接是否成功
                    if (httpResponse.getStatusLine().getStatusCode() != 200) {
                        System.out.println("wrong！!!!");

                    }
                    HttpEntity entity = httpResponse.getEntity(); // 获取响应里面的内容
                    //inputStream = entity.getContent();  // 得到服务气端发回的响应的内容（都在一个流里面）
                    // 得到服务气端发回的响应的内容（都在一个字符串里面）
                    // String strResult = EntityUtils.toString(entity);
                } catch (Exception e) {
                    System.out.println("wrong！");
                }


            }
        });
    }
}
