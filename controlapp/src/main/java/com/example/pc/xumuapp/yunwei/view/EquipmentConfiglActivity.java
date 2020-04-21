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
import com.example.pc.xumuapp.yunwei.presenter.EquipmentStatusPersenter;
import com.example.pc.xumuapp.yunwei.presenter.OrderPersenter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.RequestBody;


public class EquipmentConfiglActivity extends AppCompatActivity implements OrderView{


    private Context context;
    private ArrayList<CarlistdetaliModel> mainlist = new ArrayList<CarlistdetaliModel>();
    ImageView back_btn;
    TextView rigth_btn;
    TextView title_lab;
    private String equipmentid = "";
    private String userCode = "";
    private String titlelab = "参数配置";
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
    EditText bianpin_edit1;
    EditText bianpin_edit2;
    Button updatebtn1;
    Button updatebtn2;

    Switch selectSwitchBtn;
    String btnStatus = "0";

    private ProgressDialog progressDialog;

    private EquipmentStatusPersenter equipmentStatusPersenter = new EquipmentStatusPersenter(this);
    private OrderPersenter orderPersenter = new OrderPersenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.equipmentconfig_layout);
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

        rigth_btn.setVisibility(View.GONE);
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
        orderPersenter.PostOrder(body,headmap);
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

    }

    @Override
    public void GetEquipmentStatusError(Throwable e) {
        Toast.makeText(context, "网络访问失败", Toast.LENGTH_LONG).show();
        progressDialog.cancel();
    }

    @Override
    public void OrderSuccess(OrderModel gatherModel) {
        Toast.makeText(context, gatherModel.getErrorMessage(), Toast.LENGTH_LONG).show();

    }

    @Override
    public void OrderError(Throwable e) {
        Toast.makeText(context, "网络访问失败", Toast.LENGTH_LONG).show();
        progressDialog.cancel();
    }

    /**
     dp转px方法
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
