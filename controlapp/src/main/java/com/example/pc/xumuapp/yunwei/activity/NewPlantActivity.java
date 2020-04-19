package com.example.pc.xumuapp.yunwei.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.utils.SpUtils;
import com.example.pc.xumuapp.yunwei.model.PlantModel;
import com.example.pc.xumuapp.yunwei.presenter.NewPlantPersenter;
import com.example.pc.xumuapp.yunwei.view.NewPlantView;
import com.google.gson.Gson;

import java.util.HashMap;

import okhttp3.RequestBody;

public class NewPlantActivity extends AppCompatActivity implements NewPlantView {
    private NewPlantPersenter plantPersenter = new NewPlantPersenter(this);
    private EditText taskNumber;
    private EditText quantity;
    private EditText begintime;
    private EditText endtime;
    private Button update_btn;
    private TextView titlelab;
    private ImageView back_btn;
    private String work_type;
//    可变lab
    private TextView change_lab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plant);
        Intent intent = getIntent();
        work_type = intent.getStringExtra("type");
        initview();
    }

    public void initview(){
        titlelab = findViewById(R.id.nav_title);
        change_lab = findViewById(R.id.title_lab);
        switch (work_type){
            case "0":
                titlelab.setText("新增种植");
                change_lab.setText("种植详细信息");
                break;
            case "1":
                titlelab.setText("新增采收");
                change_lab.setText("采收详细信息");
                break;
            case "2":
                titlelab.setText("新增加工");
                change_lab.setText("加工详细信息");
                break;
            case "3":
                titlelab.setText("新增包装");
                change_lab.setText("包装详细信息");
                break;
        }

        back_btn = findViewById(R.id.iv_back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        taskNumber = findViewById(R.id.renwuhao);
        quantity = findViewById(R.id.finishnum);
        begintime = findViewById(R.id.begintime);
        endtime = findViewById(R.id.endtime);
        update_btn = findViewById(R.id.bt_queren);
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetValue();
            }
        });
    }
    public void GetValue(){

        Gson gson=new Gson();
        HashMap<String, String> paramsMap = new HashMap<>();
      /**  "taskNumber": "wo-0001",
                "beginTime": "2019-10-24",
                "endTime": "2019-10-24",
                "unitDict": "pcs",
                "quantity": "2",
       **/

        paramsMap.put("taskNumber",taskNumber.getText().toString());
        paramsMap.put("beginTime",begintime.getText().toString());
        paramsMap.put("endTime",endtime.getText().toString());
        paramsMap.put("quantity",quantity.getText().toString());
//        paramsMap.put("unitDict","pcs");
        paramsMap.put("userToken", SpUtils.GetConfigString(this,"userToken"));
        String strEntity = gson.toJson(paramsMap);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("token", SpUtils.GetConfigString(this,"userToken"));
        headmap.put("Content-Type","application/json");
//
        plantPersenter.PostNewPlant(body,headmap,work_type);
    }
    @Override
    public void GetLoginSuccess(PlantModel.NewPlantBean plantModel) {
        if(plantModel.isSuccess()){
//            Toast.makeText(this,"提交成功", Toast.LENGTH_SHORT).show();
            Toast.makeText(this,plantModel.getErrorMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this,plantModel.getErrorMessage(), Toast.LENGTH_SHORT).show();        }
    }

    @Override
    public void GetLoginError(Throwable e) {

    }
}
