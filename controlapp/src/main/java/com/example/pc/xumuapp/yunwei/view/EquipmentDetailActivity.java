package com.example.pc.xumuapp.yunwei.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.Tools.OkHttpUtils;
import com.example.pc.xumuapp.adapter.CarlistDetailAdapter;
import com.example.pc.xumuapp.newAdded.AddCarinfoActivity;
import com.example.pc.xumuapp.newAdded.model.CarlistdetaliModel;
import com.example.pc.xumuapp.utils.SpUtils;
import com.example.pc.xumuapp.yunwei.model.EquipmentstatusModel;
import com.example.pc.xumuapp.yunwei.model.OrderModel;
import com.example.pc.xumuapp.yunwei.presenter.EquipmentStatusPersenter;
import com.example.pc.xumuapp.yunwei.presenter.OrderPersenter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.RequestBody;
import okhttp3.Response;


public class EquipmentDetailActivity extends AppCompatActivity implements OrderView{

    OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
    private ListView mainlistview;
    private Context context;
    private ArrayList<CarlistdetaliModel> mainlist = new ArrayList<CarlistdetaliModel>();
    ImageView back_btn;
    TextView rigth_btn;
    TextView title_lab;
    private String equipmentid = "";
    private String userCode = "";
    private String titlelab = "";
    private String phone_num = "";
    Switch aSwitch1;
    Switch aSwitch2;
    Switch aSwitch3;
    Switch aSwitch4;
    Switch aSwitch5;
    Switch aSwitch6;
    Switch aSwitch0;
    TextView textview1;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    TextView textview5;
    TextView textview6;

    Switch selectSwitchBtn;
    String btnStatus = "0";

    private ProgressDialog progressDialog;

    private EquipmentStatusPersenter equipmentStatusPersenter = new EquipmentStatusPersenter(this);
    private OrderPersenter orderPersenter = new OrderPersenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_list_detail);
        context = this;

        Intent intent = getIntent();
        equipmentid = intent.getStringExtra("equipmentid");


        initview();
        netGetValue();
    }

    /**
     * initview
     */
    public void initview(){

        textview1 = findViewById(R.id.tv1);
        textview2 = findViewById(R.id.tv2);
        textview3 = findViewById(R.id.tv3);
        textview4 = findViewById(R.id.tv4);
        textview5 = findViewById(R.id.tv5);
        textview6 = findViewById(R.id.tv6);

        back_btn = (ImageView) findViewById(R.id.iv_back);
        rigth_btn = (TextView) findViewById(R.id.nav_edit);
        title_lab = (TextView) findViewById(R.id.nav_title);

        title_lab.setText(titlelab);

        rigth_btn.setVisibility(View.VISIBLE);
        rigth_btn.setText("新增主机");
        Drawable drawable = getResources().getDrawable(R.drawable.add_default);
//        drawable.setBounds(0,0,17,17);
        drawable.setBounds(0,0,dip2px(context,17),dip2px(context,17));
        rigth_btn.setCompoundDrawables(drawable,null,null,null);

        rigth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name",titlelab);
                intent.putExtra("phone",phone_num);

                intent.setClass(context,AddCarinfoActivity.class);
                context.startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        aSwitch1 = findViewById(R.id.switch1);
        aSwitch2 = findViewById(R.id.switch2);
        aSwitch3 = findViewById(R.id.switch3);
        aSwitch4 = findViewById(R.id.switch4);
        aSwitch5 = findViewById(R.id.switch5);
        aSwitch6 = findViewById(R.id.switch6);
        aSwitch0 = findViewById(R.id.switch0);

    }

    public  void  setSwitchListener() {

        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectSwitchBtn = (Switch) buttonView;
                if (buttonView.isPressed())
                {
                   postOrder(selectSwitchBtn);

                }else{

                }

            }
        });
        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectSwitchBtn = (Switch) buttonView;
                if (buttonView.isPressed())
                {
                    postOrder(selectSwitchBtn);

                }else{

                }

            }
        });
        aSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectSwitchBtn = (Switch) buttonView;
                if (buttonView.isPressed())
                {
                    postOrder(selectSwitchBtn);

                }else{

                }

            }
        });
        aSwitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectSwitchBtn = (Switch) buttonView;
                if (buttonView.isPressed())
                {
                    postOrder(selectSwitchBtn);

                }else{

                }

            }
        });
        aSwitch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectSwitchBtn = (Switch) buttonView;
                if (buttonView.isPressed())
                {
                    postOrder(selectSwitchBtn);

                }else{

                }

            }
        });
        aSwitch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectSwitchBtn = (Switch) buttonView;
                if (buttonView.isPressed())
                {
                    postOrder(selectSwitchBtn);

                }else{

                }

            }
        });
        aSwitch0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectSwitchBtn = (Switch) buttonView;
                if (buttonView.isPressed())
                {
                    postOrder(selectSwitchBtn);

                }else{

                }

            }
        });

    }
    /**
     * 网络访问
     */

    public void postOrder(Switch switchbtn){
        if (!switchbtn.isChecked()){
            btnStatus = "0";
        }else {
            btnStatus = "1";
        }
        Gson gson=new Gson();
        HashMap<String,Object> paramsMap = new HashMap<>();
//                    HashMap<String,String> paramsMap1 = new HashMap<>();
//                    paramsMap1.put("equipmentId",equipmentid);
        paramsMap.put("equipmentId",equipmentid);
        if (switchbtn.getTag().equals("0")){
            paramsMap.put("tunnel","6");
            paramsMap.put("topic","isAuto");
        }else {
            paramsMap.put("tunnel",switchbtn.getTag());
            paramsMap.put("topic","switch");
        }

        paramsMap.put("tunnelValue",btnStatus);

        paramsMap.put("userToken", SpUtils.GetConfigString(context,"userToken"));
        String strEntity = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("token", SpUtils.GetConfigString(context,"userToken"));
        headmap.put("Content-Type","application/json");
        progressDialog.show();
        orderPersenter.PostOrder(body,headmap);
    }
    public void netGetValue() {

        Gson gson=new Gson();
        HashMap<String,Object> paramsMap = new HashMap<>();
        HashMap<String,String> paramsMap1 = new HashMap<>();
        paramsMap1.put("equipmentId",equipmentid);
        paramsMap.put("entity",paramsMap1);
        paramsMap.put("userToken", SpUtils.GetConfigString(context,"userToken"));
        String strEntity = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("token", SpUtils.GetConfigString(context,"userToken"));
        headmap.put("Content-Type","application/json");
        progressDialog = ProgressDialog.show(context,"Loading....","正在获取设备信息");
        equipmentStatusPersenter.GetEquipmentStatus(body,headmap);
    }

    /**
     * 网络访问回调
     * @param
     * @param
     * @throws IOException
     */
    @Override
    public void GetEquipmentStatusSuccess(EquipmentstatusModel equipmentstatusModel) {
        Toast.makeText(context, equipmentstatusModel.getErrorMessage(), Toast.LENGTH_LONG).show();
//        String str1 = (String)equipmentstatusModel.getData().getTemperature();
//        温度
        textview1.setText(String.valueOf(equipmentstatusModel.getData().getTemperature()) + "℃");
//        湿度
        textview2.setText(String.valueOf(equipmentstatusModel.getData().getHumidity()) + "%");
//        氮气
        textview3.setText(String.valueOf(equipmentstatusModel.getData().getAmmoniaContent()));
//        风速
        textview4.setText(String.valueOf(equipmentstatusModel.getData().getGasFlow()));
//        硫化氢
        textview5.setText(String.valueOf(equipmentstatusModel.getData().getHydrogenSulfideContent()));
//        co2
        textview6.setText(String.valueOf(equipmentstatusModel.getData().getCarbonDioxideContent()));

        if (equipmentstatusModel.isSuccess()){

            if (equipmentstatusModel.getData().getSwitch1().equals("0")){
                aSwitch1.setChecked(false);
//                aSwitch1.isChecked();
            }else {
                aSwitch1.setChecked(true);
            }
            if (equipmentstatusModel.getData().getSwitch2().equals("0")){
                aSwitch2.setChecked(false);
            }else {
                aSwitch2.setChecked(true);
            }
            if (equipmentstatusModel.getData().getSwitch3().equals("0")){
                aSwitch3.setChecked(false);
            }else {
                aSwitch3.setChecked(true);
            }
            if (equipmentstatusModel.getData().getSwitch4().equals("0")){
                aSwitch4.setChecked(false);
            }else {
                aSwitch4.setChecked(true);
            }
            if (equipmentstatusModel.getData().getSwitch5().equals("0")){
                aSwitch5.setChecked(false);
            }else {
                aSwitch5.setChecked(true);
            }
            if (equipmentstatusModel.getData().getSwitch6().equals("0")){
                aSwitch6.setChecked(false);
            }else {
                aSwitch6.setChecked(true);
            }
        if (equipmentstatusModel.getData().getIsAuto().equals("0")){
            aSwitch0.setChecked(false);
        }else {
            aSwitch0.setChecked(true);
        }
            setSwitchListener();
            if (progressDialog != null) {
                progressDialog.cancel();
            }
        }else {
            if (progressDialog != null) {
                progressDialog.cancel();
            }
        }


    }

    @Override
    public void GetEquipmentStatusError(Throwable e) {

    }

    @Override
    public void OrderSuccess(OrderModel gatherModel) {
        Toast.makeText(context, gatherModel.getErrorMessage(), Toast.LENGTH_LONG).show();
        if (gatherModel.isSuccess()){

            if (progressDialog != null) {
                progressDialog.cancel();
            }
        }else {
            if (progressDialog != null) {
                progressDialog.cancel();
            }
            if (btnStatus == "0"){
                selectSwitchBtn.setChecked(false);
            }else {
                selectSwitchBtn.setChecked(true);
            }

        }
    }

    @Override
    public void OrderError(Throwable e) {

    }
    //    public void success(Call call, Response response) throws IOException {
////        Log.d("1", "onResponse: "onResponse + response.body().string());
//        try {
//            JSONObject jsonObjects = new JSONObject(response.body().string());
//            JSONObject jsondata = jsonObjects.getJSONObject("data");
//            JSONArray jsonArray = jsondata.getJSONArray("fmUserCarList");
//
//            mainlist.clear();
//
//            for ( int i = 0; i < jsonArray.length(); i++){
//                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//                CarlistdetaliModel carlistdetaliModel = new CarlistdetaliModel();
//                carlistdetaliModel.setCarId(jsonObject.getString("carId"));
////                carlistdetaliModel.setTimeStr(jsonObject.getString("carId"));
////                carListModel.setCarCount(jsonObject.getString("carId"));
////                carListModel.setImgUrl(jsonObject.getString("carId"));
//                mainlist.add(carlistdetaliModel);
//            }
//
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//        if (mainlist.size() != 0){
//
//
//            mainlistview.post(new Runnable() {
//                @Override
//                public void run() {
//
//                    CarlistDetailAdapter adapter = new CarlistDetailAdapter(context,mainlist);
//
//                    mainlistview.setAdapter(adapter);
//                }
//            });
//
//        }
//    }
//
//    public void failed(Call call, IOException e){
//
//    }
    /**
     dp转px方法
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
