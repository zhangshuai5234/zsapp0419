package com.example.pc.xumuapp.yunwei.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.Tools.OkHttpUtils;
import com.example.pc.xumuapp.newAdded.AddCarinfoActivity;
import com.example.pc.xumuapp.newAdded.model.CarlistdetaliModel;
import com.example.pc.xumuapp.utils.SpUtils;
import com.example.pc.xumuapp.yunwei.model.EquipmentstatusModel;
import com.example.pc.xumuapp.yunwei.model.OrderModel;
import com.example.pc.xumuapp.yunwei.model.ParameterModel;
import com.example.pc.xumuapp.yunwei.presenter.EquipmentStatusPersenter;
import com.example.pc.xumuapp.yunwei.presenter.OrderPersenter;
import com.example.pc.xumuapp.yunwei.presenter.ParameterPersenter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.RequestBody;


public class EquipmentConfiglActivity extends AppCompatActivity implements ParameterView{


    private Context context;
    private ArrayList<CarlistdetaliModel> mainlist = new ArrayList<CarlistdetaliModel>();
    ImageView back_btn;
    TextView rigth_btn;
    TextView title_lab;
    private String equipmentid = "";
    private String userCode = "";
    private String titlelab = "参数配置";
    private String phone_num = "";
    EditText ammoniaContentLowerLimit;
    EditText ammoniaContentUpperLimit;
    EditText carbonDioxideContentLowerLimit;
    EditText carbonDioxideContentUpperLimit;
    EditText dustContentLowerLimit;
    EditText dustContentUpperLimit;
    EditText frequencyLowerLimit;
    EditText frequencyUpperLimit;
    EditText gasFlowLowerLimit;
    EditText gasFlowUpperLimit;
    EditText humidityLowerLimit;
    EditText humidityUpperLimit;
    EditText hydrogenSulfideContentLowerLimit;
    EditText hydrogenSulfideContentUpperLimit;
    EditText temperatureLowerLimit;
    EditText temperatureUpperLimit;

    Switch selectSwitchBtn;
    String btnStatus = "0";

    private ProgressDialog progressDialog;

    private ParameterPersenter parameterPersenter = new ParameterPersenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.equipmentconfig_layout);
        context = this;

        Intent intent = getIntent();
        equipmentid = intent.getStringExtra("id");


        initview();
        netGetValue();
    }

    /**
     * initview
     */
    public void initview(){

        ammoniaContentLowerLimit = findViewById(R.id.ammoniaContentLowerLimit);
        ammoniaContentUpperLimit = findViewById(R.id.ammoniaContentUpperLimit);
        carbonDioxideContentLowerLimit = findViewById(R.id.carbonDioxideContentLowerLimit);
        carbonDioxideContentUpperLimit = findViewById(R.id.carbonDioxideContentUpperLimit);
        dustContentLowerLimit = findViewById(R.id.dustContentLowerLimit);
        dustContentUpperLimit = findViewById(R.id.dustContentUpperLimit);
        frequencyLowerLimit = findViewById(R.id.frequencyLowerLimit);
        frequencyUpperLimit = findViewById(R.id.frequencyUpperLimit);
        gasFlowLowerLimit = findViewById(R.id.gasFlowLowerLimit);
        gasFlowUpperLimit = findViewById(R.id.gasFlowUpperLimit);
        humidityLowerLimit = findViewById(R.id.humidityLowerLimit);
        humidityUpperLimit = findViewById(R.id.humidityUpperLimit);
        hydrogenSulfideContentLowerLimit = findViewById(R.id.hydrogenSulfideContentLowerLimit);
        hydrogenSulfideContentUpperLimit = findViewById(R.id.hydrogenSulfideContentUpperLimit);
        temperatureLowerLimit = findViewById(R.id.temperatureLowerLimit);
        temperatureUpperLimit = findViewById(R.id.temperatureUpperLimit);

        back_btn = (ImageView) findViewById(R.id.iv_back);
        rigth_btn = (TextView) findViewById(R.id.nav_edit);
        title_lab = (TextView) findViewById(R.id.nav_title);

        title_lab.setText(titlelab);

        rigth_btn.setVisibility(View.GONE);

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

    }
    /**
     *  变频器网络访问方法
     *  uuivertornetValue()
     * **/
    public void uuivertornetValue(String editstr){


        Gson gson=new Gson();
        HashMap<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("equipmentId",equipmentid);
        paramsMap.put("tunnel","1");
        paramsMap.put("topic","uuivertor");
        paramsMap.put("tunnelValue",editstr);
        paramsMap.put("userToken", SpUtils.GetConfigString(context,"userToken"));
        String strEntity = gson.toJson(paramsMap);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("token", SpUtils.GetConfigString(context,"userToken"));
        headmap.put("Content-Type","application/json");

        progressDialog.show();
        parameterPersenter.GetParameter(body,headmap);
    }

    /**
     *  switch 的监听方法
     *  setSwitchListener()
     * **/
    public  void  setSwitchListener() {


    }
    /**
     * 网络访问
     */

    public void postOrder(Switch switchbtn){

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
        parameterPersenter.GetParameter(body,headmap);
    }

    /**
     * 网络访问回调
     * @param
     * @param
     * @throws IOException
     */
    @Override
    public void GetParameterSuccess(ParameterModel parameterModel) {
        if (progressDialog != null) {
            progressDialog.cancel();
        }
        if (parameterModel.getSuccess().equals("true")){
            ammoniaContentLowerLimit.setText(parameterModel.getData().getAmmoniaContentLowerLimit());
            ammoniaContentUpperLimit.setText(parameterModel.getData().getAmmoniaContentUpperLimit());
            carbonDioxideContentLowerLimit.setText(parameterModel.getData().getCarbonDioxideContentLowerLimit());
            carbonDioxideContentUpperLimit.setText(parameterModel.getData().getCarbonDioxideContentUpperLimit());
            dustContentLowerLimit.setText(parameterModel.getData().getDustContentLowerLimit());
            dustContentUpperLimit.setText(parameterModel.getData().getDustContentUpperLimit());
            frequencyLowerLimit.setText(parameterModel.getData().getFrequencyLowerLimit());
            frequencyUpperLimit.setText(parameterModel.getData().getFrequencyUpperLimit());
            gasFlowLowerLimit.setText(parameterModel.getData().getGasFlowLowerLimit());
            gasFlowUpperLimit.setText(parameterModel.getData().getGasFlowUpperLimit());
            humidityLowerLimit.setText(parameterModel.getData().getHumidityLowerLimit());
            humidityUpperLimit.setText(parameterModel.getData().getHumidityUpperLimit());
            hydrogenSulfideContentLowerLimit.setText(parameterModel.getData().getHydrogenSulfideContentLowerLimit());
            hydrogenSulfideContentUpperLimit.setText(parameterModel.getData().getHydrogenSulfideContentUpperLimit());
            temperatureLowerLimit.setText(parameterModel.getData().getTemperatureLowerLimit());
            temperatureUpperLimit.setText(parameterModel.getData().getTemperatureUpperLimit());
        }
    }

    @Override
    public void GetParameterError(Throwable e) {

    }



    /**
     dp转px方法
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
