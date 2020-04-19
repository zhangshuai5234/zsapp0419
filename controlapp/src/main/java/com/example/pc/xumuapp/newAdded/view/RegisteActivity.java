package com.example.pc.xumuapp.newAdded.view;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.JSONObject;

//import com.example.agricultureainstall.AgricultureUpgradeActivity;
//import com.example.agricultureainstall.BaseActivity;
//import com.example.agricultureainstall.MuneActivity;
//import com.example.agricultureainstall.PhotouploadActivity;
//import com.example.agricultureainstallnew.R;
////import com.lnpdit.AgriMachineNew.http.ISoapService;
//import com.example.agricultureainstall.Updatecoop;
//import com.example.agricultureainstall.Updatefarmcoop;
//import com.example.agricultureainstall.UploadPictureActivityOne;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.Tools.OkHttpUtils;

import okhttp3.Call;
import okhttp3.Response;


public class RegisteActivity extends AppCompatActivity implements OkHttpUtils.MyNetCall {



        private OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        private ImageView bank;
        private TextView link_length1,link_length2,lowBarPloughHeight,plough_ground_height,jiju_type,sensor1_tv,
                sensor2_tv,sensor3_tv;
        private Button bt_next,photo_btn;
        private Context context;

        private String sensor1_tvstr = "";//1号传感器安装方向显示文字
        private String sensor2_tvstr = "";//2号传感器安装方向显示文字
        private String sensor3_tvstr = "";//3号传感器安装方向显示文字

        private String sensor1_str = "";//1号传感器安装方向
        private String sensor2_str = "";//2号传感器安装方向
        private String sensor3_str = "";//3号传感器安装方向
        private String xialagan_str = "";//下拉杆长度
        private String linkploughheight_str = "";//下拉杆机具连接点到犁尖长度
        private String linkgroundheight_str = "";//下拉杆机具连接点到地面垂直高度
        private String ploughgroundheight_str = "";//犁尖到地面垂直高度
        private String jijutype = "";//机具类型
        private String jijutypetv = "";//机具类型
        private String spworktype = "";//
        private String sphez = "";//
        private String spshu1 = "";//
        private String spshu3 = "";//
        private String spshu4 = "";//
        private String circleradius = "";//圆形耙半径
        private String Machine_spacing = "";//机具两侧犁尖高度
        private String sensor2l = "";//2号传感器位置
        private String carId = "";
        ImageView back_btn;
        TextView title_lab;
        String Installation = "";// 安装指令

        String[][] itme = new String[13][10];// 机具安装指令参数



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            context = this;
            setContentView(R.layout.registe_layout);

            // setContentView(R.layout.activity_addframinfors);
            //上一页传来的确认信息
            Intent in = getIntent();

            sensor1_tvstr = in.getStringExtra("sensor1tv");//1号传感器安装方向显示文字
            sensor2_tvstr = in.getStringExtra("sensor2tv");//2号传感器安装方向显示文字
            sensor3_tvstr = in.getStringExtra("sensor3tv");//3号传感器安装方向显示文字
            sensor1_str = in.getStringExtra("sensor1");//1号传感器安装方向
            sensor2_str = in.getStringExtra("sensor2");//2号传感器安装方向
            sensor3_str = in.getStringExtra("sensor3");//3号传感器安装方向
            xialagan_str = in.getStringExtra("xialagan");//下拉杆长度
            linkploughheight_str = in.getStringExtra("linkploughheight");//下拉杆机具连接点到犁尖长度
            linkgroundheight_str = in.getStringExtra("linkgroundheight");//下拉杆机具连接点到地面垂直高度
            ploughgroundheight_str = in.getStringExtra("ploughgroundheight");//犁尖到地面垂直高度
            jijutype = in.getStringExtra("jijutype");//机具类型
            jijutypetv = in.getStringExtra("jijutypetv");//机具类型文字显示
            spworktype = in.getStringExtra("spworktype");
            sphez = in.getStringExtra("sphez");
//            spshu1 = in.getStringExtra("spshu1");
//            spshu3 = in.getStringExtra("spshu3");
//            spshu4 = in.getStringExtra("spshu4");
//            sensor2l = in.getStringExtra("sensor2l");

            circleradius = in.getStringExtra("circleradius");
            Machine_spacing = in.getStringExtra("Machine_spacing");

            spshu3 = "0";
            spshu1 = "0";
            spshu4 = "0";
            circleradius = "0";
            sensor2l = "0";
            carId = in.getStringExtra("carId");

            initView();

        }

        public void initView() {
            back_btn = findViewById(R.id.iv_back);
            title_lab = findViewById(R.id.nav_title);
            title_lab.setText("安装信息确认");
            back_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

//            bank.setClickable(true);

            plough_ground_height = (TextView) findViewById(R.id.plough_ground_height);
            link_length1 = (TextView) findViewById(R.id.link_length1);// 下拉杆长度
            link_length2 = (TextView) findViewById(R.id.link_length2);// 下拉杆机具连接点到犁尖长度
            lowBarPloughHeight = (TextView) findViewById(R.id.lowBarPloughHeight);
            jiju_type = (TextView) findViewById(R.id.jiju_type);
            sensor1_tv = (TextView) findViewById(R.id.sensor1_tv);
            sensor2_tv = (TextView) findViewById(R.id.sensor2_tv);
            sensor3_tv = (TextView) findViewById(R.id.sensor3_tv);

            plough_ground_height.setText(ploughgroundheight_str);
            link_length1.setText(xialagan_str);
            link_length2.setText(linkploughheight_str);
            lowBarPloughHeight.setText(linkgroundheight_str);
            jiju_type.setText(jijutypetv);
            sensor1_tv.setText(sensor1_tvstr);
            sensor2_tv.setText(sensor2_tvstr);
            sensor3_tv.setText(sensor3_tvstr);

            bt_next = (Button) findViewById(R.id.bt_next);// 确认安装



            bt_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int aa = 0;
                    if (Machine_spacing.matches("^[0-9]*$")
                            && !Machine_spacing.equals("")) {
                        if (link_length1.getText().toString().trim().matches("^[0-9]*$")
                                && !link_length1.getText().toString().trim().equals("")) {
                            if (link_length2.getText().toString().trim().matches("^[0-9]*$")
                                    && !link_length2.getText().toString().trim().equals("")) {
                                if (lowBarPloughHeight.getText().toString().trim().matches("^[0-9]*$")
                                        && !lowBarPloughHeight.getText().toString().trim().equals("")) {
                                    if (plough_ground_height.getText().toString().trim().matches("^[0-9]*$")
                                            && !plough_ground_height.getText().toString().trim().equals("")) {
                                        aa = 1;
                                    }else {

//								diaiogs("是否执行安转流程？");

//								new TcpThendle().start();
                                    }
                                }
                            }
                        }
                    }
                    if (aa == 0) {
                        Toast.makeText(RegisteActivity.this, "信息有误无法安装", Toast.LENGTH_SHORT).show();
                    }else{
                        String[] b = { "0000", "0000", "0000", "0000", "0000", "0000", "0000", "0000", "00"+spworktype, "0000" };
                        String[] a = { link_length1.getText().toString().trim(), link_length2.getText().toString().trim(),
                                plough_ground_height.getText().toString().trim(),
                                lowBarPloughHeight.getText().toString().trim(), "000" + spshu1, "000" + sensor2l, "0000",
                                "0000", "00"+spworktype, "0000" };
                        String[] c = { link_length1.getText().toString().trim(), link_length2.getText().toString().trim(),
                                plough_ground_height.getText().toString().trim(),
                                lowBarPloughHeight.getText().toString().trim(), "000" + spshu1, "000" + sensor2l,
                                circleradius, "0000", "00"+spworktype, "0000" };
                        itme[0] = a;
                        itme[1] = a;
                        itme[2] = a;
                        itme[3] = b;
                        itme[4] = b;
                        itme[5] = a;
                        itme[6] = c;
                        itme[7] = c;
                        itme[8] = a;
                        itme[9] = a;
                        itme[10] = a;
                        itme[11] = a;
                        itme[12] = a;

//				Installation = "$," + carId + ",20,$ONET," + "20," + "1," + "0000" + "," + jijutype + "," + spshu3
//						+ "," + sensor2_str + "," + spshu4;
                        Installation = "$LNPDIT," + "20," + "1," + "0" + "," + jijutype + "," + spshu3
                                + "," + sensor2_str + "," + spshu4;

                        for (int i = 0; i < 10; i++) {
                            if(jijutype.equals("A")){
                                while (itme[10][i].length() < 4) {
                                    itme[10][i] = "0" + itme[10][i];
                                }
                                Installation = Installation + "," + itme[10][i];
                            }else if(jijutype.equals("B")){
                                while (itme[11][i].length() < 4) {
                                    itme[11][i] = "0" + itme[11][i];
                                }
                                Installation = Installation + "," + itme[11][i];
                            }else if(jijutype.equals("C")){
                                while (itme[12][i].length() < 4) {
                                    itme[12][i] = "0" + itme[12][i];
                                }

                                Installation = Installation + "," + itme[12][i];
                            }else{
                                while (itme[Integer.parseInt(jijutype)][i].length() < 4) {
                                    itme[Integer.parseInt(jijutype)][i] = "0" + itme[Integer.parseInt(jijutype)][i];
                                }
                                Installation = Installation + "," + itme[Integer.parseInt(jijutype)][i];
                            }
                        }
                        String[] property_va = new String[] { carId,Installation };
//                        soapService .sjzhilingPost(property_va);
                        netGetinfowithCarid(carId,Installation);

                    }

                }
            });
//            photo_btn.setOnClickListener(this);
        }

        @Override
        protected void onResume() {
            // TODO Auto-generated method stub
            super.onResume();

        }

        @Override
        protected void onDestroy() {
            // TODO Auto-generated method stub
            super.onDestroy();
        }

        class TcpThendle extends Thread {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                super.run();
                try {
                    String[] b = { "0000", "0000", "0000", "0000", "0000", "0000", "0000", "0000", "00"+spworktype, "0000" };
                    String[] a = { link_length1.getText().toString().trim(), link_length2.getText().toString().trim(),
                            plough_ground_height.getText().toString().trim(),
                            lowBarPloughHeight.getText().toString().trim(), "000" + spshu1, "000" + sensor2l, "0000",
                            "0000", "00"+spworktype, "0000" };
                    String[] c = { link_length1.getText().toString().trim(), link_length2.getText().toString().trim(),
                            plough_ground_height.getText().toString().trim(),
                            lowBarPloughHeight.getText().toString().trim(), "000" + spshu1, "000" + sensor2l,
                            circleradius, "0000", "00"+spworktype, "0000" };
                    itme[0] = a;
                    itme[1] = a;
                    itme[2] = a;
                    itme[3] = b;
                    itme[4] = b;
                    itme[5] = a;
                    itme[6] = c;
                    itme[7] = c;
                    itme[8] = a;
                    itme[9] = a;
                    itme[10] = a;
                    itme[11] = a;
                    itme[12] = a;

                    Installation = "$," + carId + ",20,$ONET," + "20," + "1," + "0000" + "," + jijutype + "," + spshu3
                            + "," + sensor2_str + "," + spshu4;
                    for (int i = 0; i < 10; i++) {
                        if(jijutype.equals("A")){
                            while (itme[10][i].length() < 4) {
                                itme[10][i] = "0" + itme[10][i];
                            }
                            Installation = Installation + "," + itme[10][i];
                        }else if(jijutype.equals("B")){
                            while (itme[11][i].length() < 4) {
                                itme[11][i] = "0" + itme[11][i];
                            }
                            Installation = Installation + "," + itme[11][i];
                        }else if(jijutype.equals("C")){
                            while (itme[12][i].length() < 4) {
                                itme[12][i] = "0" + itme[12][i];
                            }
                            Installation = Installation + "," + itme[12][i];
                        }else{
                            while (itme[Integer.parseInt(jijutype)][i].length() < 4) {
                                itme[Integer.parseInt(jijutype)][i] = "0" + itme[Integer.parseInt(jijutype)][i];
                            }
                            Installation = Installation + "," + itme[Integer.parseInt(jijutype)][i];
                        }

                    }
//				 Message msg = new Message();
//				 msg.arg1 = 1;
//				 msg.obj = Installation;
//				 mThirdHandler.sendMessage(msg);
                    Socket socket = new Socket("47.93.172.242", 5550);
                    // 设置5秒之后即认为是超时
                    socket.setSoTimeout(5000);
                    // 发送数据给服务端
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(Installation.getBytes("UTF-8"));
                    socket.shutdownOutput();
                    // 读取数据
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String line = br.readLine();
                    // 打印读取到的数据
                    Log.e("Add", ">>>>>>>>>>>>>>>>>>>>>>>>>" + line);
                    br.close();
                    socket.close();

                } catch (UnknownHostException e) {
                    // TODO Auto-generated catch block
                    Log.e("UnknownHost", "来自服务器的数据");
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("IOException", "来自服务器的数据");
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    public void netGetinfowithCarid(String carid,String installation){
        String neturl = "http://39.107.152.122/fm/Command/send?carId="+carid+"&commandContent="+installation;

//        okHttpUtils.getDataAsyn(neturl,this);
        okHttpUtils.postDataAsyn(neturl,null,this);
    }
//        @Override
//        public void onClick(View v) {
//            // TODO Auto-generated method stub
//            super.onClick(v);
//            switch (v.getId()) {
//                case R.id.bank:
//                    finish();
//                    break;
//                case R.id.photo_btn:
//                    Intent intent = new Intent();
//                    intent.putExtra("carid", carId);//............
//                    intent.setClass(FarmMachineyInstallationActivity.this, UploadPictureActivityOne.class);
//                    startActivity(intent);
//                    break;
//                case R.id.bt_next:
//                    int aa = 0;
//                    if (Machine_spacing.matches("^[0-9]*$")
//                            && !Machine_spacing.equals("")) {
//                        if (link_length1.getText().toString().trim().matches("^[0-9]*$")
//                                && !link_length1.getText().toString().trim().equals("")) {
//                            if (link_length2.getText().toString().trim().matches("^[0-9]*$")
//                                    && !link_length2.getText().toString().trim().equals("")) {
//                                if (lowBarPloughHeight.getText().toString().trim().matches("^[0-9]*$")
//                                        && !lowBarPloughHeight.getText().toString().trim().equals("")) {
//                                    if (plough_ground_height.getText().toString().trim().matches("^[0-9]*$")
//                                            && !plough_ground_height.getText().toString().trim().equals("")) {
//                                        aa = 1;
//                                    }else {
//
////								diaiogs("是否执行安转流程？");
//
////								new TcpThendle().start();
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    if (aa == 0) {
//                        Toast.makeText(FarmMachineyInstallationActivity.this, "信息有误无法安装", Toast.LENGTH_SHORT).show();
//                    }else{
//                        String[] b = { "0000", "0000", "0000", "0000", "0000", "0000", "0000", "0000", "00"+spworktype, "0000" };
//                        String[] a = { link_length1.getText().toString().trim(), link_length2.getText().toString().trim(),
//                                plough_ground_height.getText().toString().trim(),
//                                lowBarPloughHeight.getText().toString().trim(), "000" + spshu1, "000" + sensor2l, "0000",
//                                "0000", "00"+spworktype, "0000" };
//                        String[] c = { link_length1.getText().toString().trim(), link_length2.getText().toString().trim(),
//                                plough_ground_height.getText().toString().trim(),
//                                lowBarPloughHeight.getText().toString().trim(), "000" + spshu1, "000" + sensor2l,
//                                circleradius, "0000", "00"+spworktype, "0000" };
//                        itme[0] = a;
//                        itme[1] = a;
//                        itme[2] = a;
//                        itme[3] = b;
//                        itme[4] = b;
//                        itme[5] = a;
//                        itme[6] = c;
//                        itme[7] = c;
//                        itme[8] = a;
//                        itme[9] = a;
//                        itme[10] = a;
//                        itme[11] = a;
//                        itme[12] = a;
//
////				Installation = "$," + carId + ",20,$ONET," + "20," + "1," + "0000" + "," + jijutype + "," + spshu3
////						+ "," + sensor2_str + "," + spshu4;
//                        Installation = "$LNPDIT," + "20," + "1," + "0" + "," + jijutype + "," + spshu3
//                                + "," + sensor2_str + "," + spshu4;
//
//                        for (int i = 0; i < 10; i++) {
//                            if(jijutype.equals("A")){
//                                while (itme[10][i].length() < 4) {
//                                    itme[10][i] = "0" + itme[10][i];
//                                }
//                                Installation = Installation + "," + itme[10][i];
//                            }else if(jijutype.equals("B")){
//                                while (itme[11][i].length() < 4) {
//                                    itme[11][i] = "0" + itme[11][i];
//                                }
//                                Installation = Installation + "," + itme[11][i];
//                            }else if(jijutype.equals("C")){
//                                while (itme[12][i].length() < 4) {
//                                    itme[12][i] = "0" + itme[12][i];
//                                }
//                                Installation = Installation + "," + itme[12][i];
//                            }else{
//                                while (itme[Integer.parseInt(jijutype)][i].length() < 4) {
//                                    itme[Integer.parseInt(jijutype)][i] = "0" + itme[Integer.parseInt(jijutype)][i];
//                                }
//                                Installation = Installation + "," + itme[Integer.parseInt(jijutype)][i];
//                            }
//                        }
//                        String[] property_va = new String[] { carId,Installation };
//                        soapService .sjzhilingPost(property_va);
//
//                    }
//
//                    break;
//
//                default:
//                    break;
//            }
//        }


    @Override
    public void success(Call call, Response response) {
        try {

//            Log.d("1", response.body().string());

            JSONObject json_objs = new JSONObject(response.body().string());
            if (json_objs.get("result").toString().equals("true")) {


                Toast.makeText(context, json_objs.get("message").toString(), Toast.LENGTH_SHORT).show();
                finish();
            }else{

                Toast.makeText(context, json_objs.get("message").toString(), Toast.LENGTH_SHORT).show();
            }

        } catch ( Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Call call, IOException e) {

    }

//    @SuppressLint("NewApi")
//        @Override
//        public void onEvent(SoapRes obj) {
//            super.onEvent(obj);
//
//            if (obj.getCode().equals(SOAP_UTILS.METHOD.SJZHILING)) {
//                if (obj.getObj() != null) {
//                    try {
//                        JSONObject json_objs = new JSONObject(obj.getObj().toString());
//
//                        if (json_objs.get("result").toString().equals("true")) {
//
//                            finish();
//                            Toast.makeText(context, json_objs.get("message").toString(), Toast.LENGTH_SHORT).show();
//                        }else{
//
//                            Toast.makeText(context, json_objs.get("message").toString(), Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (JSONException e) {
//                        Toast.makeText(FarmMachineyInstallationActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//
//                    }
//                }
//            }
//        }
    }
