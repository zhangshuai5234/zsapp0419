package com.example.pc.xumuapp.yunwei.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.adapter.GdListAdapter;
import com.example.pc.xumuapp.retrofit.ProgressDialogHandler;
import com.example.pc.xumuapp.utils.SpUtils;
import com.example.pc.xumuapp.yunwei.model.GongdanModel;
import com.example.pc.xumuapp.yunwei.model.gdListModel;
import com.example.pc.xumuapp.yunwei.presenter.GongdanPersenter;
import com.example.pc.xumuapp.yunwei.view.gongdanView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;

public class    GongdanActivity extends AppCompatActivity implements gongdanView {

    private ProgressDialogHandler progressDialogHandler = new ProgressDialogHandler(GongdanActivity.this, null, true);
    private GongdanPersenter gongdanPersenter = new GongdanPersenter(this);
    private TextView titlelab;
    private ImageView backBtn;
    private ListView mainListView;
    private List<gdListModel.RecordsBean> mainlist = new ArrayList<gdListModel.RecordsBean>();
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gongdan);
        context = this;
        initview();
//        GetValue();
    }
    public void initview(){
        titlelab = findViewById(R.id.nav_title);
        titlelab.setText("未完成工单");
        backBtn = findViewById(R.id.iv_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mainListView = findViewById(R.id.mainlist);
    }

    public void GetValue(){

        Gson gson=new Gson();
        HashMap<String,Object> paramsMap = new HashMap<>();
        HashMap<String,String> paramsMap1 = new HashMap<>();
        paramsMap.put("entity",paramsMap1);
        paramsMap.put("userToken", SpUtils.GetConfigString(this,"userToken"));
        String strEntity = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("token", SpUtils.GetConfigString(this,"userToken"));
        headmap.put("Content-Type","application/json");

        gongdanPersenter.GetGongdanList(body,headmap);
    }

    @Override
    public void GetLoginSuccess(GongdanModel gongdanModel) {
        if (gongdanModel.getSuccess().equals("true")){
            gdListModel gdListModel =  gongdanModel.getData();
//            for (int i = 0; i < gdListModel.getRecords().size(); i++){
//
//            }
            mainlist = gdListModel.getRecords();
                if (mainlist.size() != 0){
                    GdListAdapter adapter = new GdListAdapter(context,mainlist);

                    mainListView.setAdapter(adapter);

                }
        }else {

        }
    }

    @Override
    public void GetLoginError(Throwable e) {

    }
}
