package com.example.pc.xumuapp.yunwei.view;

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
        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    //设置SP
//                    SettingPre.setSwitchFiled(isChecked);
//                    mSwith.setSwitchTextAppearance(getmContext(),R.style.switch_text_true_blue);
//                    baseUtil.LongLoge("if:"+isChecked);
//                    showToast("选择自动保存！");
                    aSwitch1.setChecked(true);

                }else{
                    aSwitch1.setChecked(true);
                    //设置SP
//                    SettingPre.setSwitchFiled(isChecked);
//                    mSwith.setSwitchTextAppearance(getmContext(),R.style.switch_text_false_gray);
//                    baseUtil.LongLoge("else:"+isChecked);
//                    showToast("取消自动保存！");

                }

            }
        });
    }

    /**
     * 网络访问
     */
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

        equipmentStatusPersenter.GetEquipmentStatus(body,headmap);
    }

    /**
     * 网络访问回调
     * @param call
     * @param response
     * @throws IOException
     */
    @Override
    public void GetEquipmentStatusSuccess(EquipmentstatusModel equipmentstatusModel) {
        if (equipmentstatusModel.isSuccess()){

            if (equipmentstatusModel.getData().getSwitch1().equals("0")){
                aSwitch1.setChecked(true);
            }else {
                aSwitch1.setChecked(false);
            }
            if (equipmentstatusModel.getData().getSwitch2() == "0"){
                aSwitch2.setChecked(true);
            }else {
                aSwitch2.setChecked(false);
            }
            if (equipmentstatusModel.getData().getSwitch3() == "0"){
                aSwitch3.setChecked(true);
            }else {
                aSwitch3.setChecked(false);
            }
            if (equipmentstatusModel.getData().getSwitch4() == "0"){
                aSwitch4.setChecked(true);
            }else {
                aSwitch4.setChecked(false);
            }
            if (equipmentstatusModel.getData().getSwitch5() == "1"){
                aSwitch5.setChecked(true);
            }else {
                aSwitch5.setChecked(false);
            }
            if (equipmentstatusModel.getData().getSwitch6() == "0"){
                aSwitch6.setChecked(true);
            }else {
                aSwitch6.setChecked(false);
            }
//        if (equipmentstatusModel.getData().getIsAuto() == "0"){
//            aSwitch6.setChecked(true);
//        }else {
//            aSwitch6.setChecked(false);
//        }
        }


    }

    @Override
    public void GetEquipmentStatusError(Throwable e) {

    }

    @Override
    public void OrderSuccess(OrderModel gatherModel) {

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
