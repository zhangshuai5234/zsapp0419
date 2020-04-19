package com.example.pc.xumuapp.mvp_charge.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.Tools.OkHttpUtils;
import com.example.pc.xumuapp.adapter.ChargeDetailAdapter;
import com.example.pc.xumuapp.newAdded.model.CarListModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


public class ChargeDetailActivity extends AppCompatActivity implements OkHttpUtils.MyNetCall {

    ListView mainlistview;
    OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
    private List<CarListModel> mainlist = new ArrayList<CarListModel>();
    Context context;
    ImageView leftbtn;
    String titlelab;
    private TextView nav_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_detail);

        Intent intent = getIntent();
        titlelab = intent.getStringExtra("username");

        context = this;
        initview();
        netGetValue();

    }

    public void initview(){

        mainlistview = findViewById(R.id.chargedetaillist);
        leftbtn = findViewById(R.id.iv_back);
        nav_title = findViewById(R.id.nav_title);

        nav_title.setText(titlelab);

        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    /**
     * 网络访问
     */
    public void netGetValue() {

        String url = "http://39.107.152.122/fm/app/install/api/user/carList?userCode=ttest_zxjz";

        okHttpUtils.getDataAsyn(url,this);
    }

    /**
     * 网络访问回调方法
     * @param call
     * @param response
     * @throws IOException
     */


    public void success(Call call, Response response) throws IOException{
//        Log.d("1", "onResponse: " + response.body().string());
        try {
            JSONObject jsonObjects = new JSONObject(response.body().string());
            JSONObject jsondata = jsonObjects.getJSONObject("data");
            JSONArray jsonArray = jsondata.getJSONArray("fmUserCarList");

            mainlist.clear();

            for ( int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                CarListModel carListModel = new CarListModel();
                carListModel.setUserName(jsonObject.getString("carId"));
                carListModel.setPhonNum(jsonObject.getString("carId"));
                carListModel.setCarCount(jsonObject.getString("carId"));
                carListModel.setImgUrl(jsonObject.getString("carId"));

                mainlist.add(carListModel);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        if (mainlist.size() != 0){


            mainlistview.post(new Runnable() {
                @Override
                public void run() {

                    ChargeDetailAdapter adapter = new ChargeDetailAdapter(context,mainlist);

                    mainlistview.setAdapter(adapter);
                }
            });


        }
    }

    public void failed(Call call, IOException e){

    }


}
