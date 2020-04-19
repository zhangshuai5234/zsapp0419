package com.example.pc.xumuapp.newAdded;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.Tools.OkHttpUtils;
import com.example.pc.xumuapp.adapter.CarlistDetailAdapter;
import com.example.pc.xumuapp.newAdded.model.CarlistdetaliModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;


public class CarListDetailActivity extends AppCompatActivity implements OkHttpUtils.MyNetCall {

    OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
    private ListView mainlistview;
    private Context context;
    private ArrayList<CarlistdetaliModel> mainlist = new ArrayList<CarlistdetaliModel>();
    ImageView back_btn;
    TextView rigth_btn;
    TextView title_lab;
    private String carId = "";
    private String userCode = "";
    private String titlelab = "";
    private String phone_num = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_list_detail);
        context = this;

        Intent intent = getIntent();
        carId = intent.getStringExtra("carId");
        userCode = intent.getStringExtra("usercode");
        titlelab = intent.getStringExtra("username");
        phone_num = intent.getStringExtra("phone");

        initview();
//        netGetValue();
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
    }

    /**
     * 网络访问
     */
    public void netGetValue() {

        String url = "http://39.107.152.122/fm/app/install/api/user/carList?userCode=";

        okHttpUtils.getDataAsyn(url.concat(userCode),this);
    }

    /**
     * 网络访问回调
     * @param call
     * @param response
     * @throws IOException
     */
    public void success(Call call, Response response) throws IOException {
//        Log.d("1", "onResponse: "onResponse + response.body().string());
        try {
            JSONObject jsonObjects = new JSONObject(response.body().string());
            JSONObject jsondata = jsonObjects.getJSONObject("data");
            JSONArray jsonArray = jsondata.getJSONArray("fmUserCarList");

            mainlist.clear();

            for ( int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                CarlistdetaliModel carlistdetaliModel = new CarlistdetaliModel();
                carlistdetaliModel.setCarId(jsonObject.getString("carId"));
//                carlistdetaliModel.setTimeStr(jsonObject.getString("carId"));
//                carListModel.setCarCount(jsonObject.getString("carId"));
//                carListModel.setImgUrl(jsonObject.getString("carId"));
                mainlist.add(carlistdetaliModel);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        if (mainlist.size() != 0){


            mainlistview.post(new Runnable() {
                @Override
                public void run() {

                    CarlistDetailAdapter adapter = new CarlistDetailAdapter(context,mainlist);

                    mainlistview.setAdapter(adapter);
                }
            });

        }
    }

    public void failed(Call call, IOException e){

    }
    /**
     dp转px方法
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
