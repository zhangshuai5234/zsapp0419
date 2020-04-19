package com.example.pc.xumuapp.yunwei.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.adapter.PlantAdapter;
import com.example.pc.xumuapp.retrofit.ProgressDialogHandler;
import com.example.pc.xumuapp.utils.SpUtils;
import com.example.pc.xumuapp.yunwei.model.PlantModel;
import com.example.pc.xumuapp.yunwei.presenter.PlantPersenter;
import com.example.pc.xumuapp.yunwei.view.PlantView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;


public class PlantActivity extends AppCompatActivity implements PlantView {

    private ProgressDialogHandler progressDialogHandler = new ProgressDialogHandler(PlantActivity.this, null, true);
    private PlantPersenter plantPersenter = new PlantPersenter(this);
    private TextView titlelab;
    private ImageView backBtn;
    private ListView mainListView;
    private List<PlantModel.DataBean> mainlist = new ArrayList<PlantModel.DataBean>();
    private Context context;

    private TextView edit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gongdan);
        context = this;
        initview();
        GetValue();
    }
    public void initview(){
        titlelab = findViewById(R.id.nav_title);
        titlelab.setText("种植");
        backBtn = findViewById(R.id.iv_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mainListView = findViewById(R.id.mainlist);
        edit_btn = findViewById(R.id.nav_edit);
        edit_btn.setVisibility(View.VISIBLE);
        edit_btn.setText("新增种植");
        Drawable drawable = getResources().getDrawable(R.drawable.add_default);
//        drawable.setBounds(0,0,17,17);
        drawable.setBounds(0,0,dip2px(context,17),dip2px(context,17));
        edit_btn.setCompoundDrawables(drawable,null,null,null);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_order = new Intent();
                intent_order.putExtra("type","0");
                intent_order.setClass(context, NewPlantActivity.class);
                startActivity(intent_order);
            }
        });
    }
    /**
     dp转px方法
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    public void GetValue(){

        Gson gson=new Gson();
        HashMap<String, Object> paramsMap = new HashMap<>();
        HashMap<String,String> paramsMap1 = new HashMap<>();
        paramsMap.put("entity",paramsMap1);
        paramsMap.put("userToken", SpUtils.GetConfigString(this,"userToken"));
        String strEntity = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("token", SpUtils.GetConfigString(this,"userToken"));
        headmap.put("Content-Type","application/json");

        plantPersenter.GetPlantList(body,headmap);
    }

    @Override
    public void GetLoginSuccess(PlantModel plantModel) {
        if (plantModel.isSuccess()){

            mainlist = plantModel.getData();
            if (mainlist.size() != 0){
                PlantAdapter adapter = new PlantAdapter(context,mainlist);
                mainListView.setAdapter(adapter);

            }
        }else {

        }
    }

    @Override
    public void GetLoginError(Throwable e) {

    }
}
