
package com.example.pc.xumuapp.newAdded.view;

        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Handler;
        import android.os.Message;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.pc.xumuapp.R;
        import com.example.pc.xumuapp.Tools.OkHttpUtils;
        import com.example.pc.xumuapp.newAdded.model.AddcarinfoModel;
        import com.example.pc.xumuapp.newAdded.model.Province;
        import com.example.pc.xumuapp.newAdded.presenter.UpdateCarinfoPresenter;
        import com.example.pc.xumuapp.utils.SpUtils;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import butterknife.BindView;
        import okhttp3.Call;
        import okhttp3.Response;


public class EditCarinfoActivity extends AppCompatActivity  implements OkHttpUtils.MyNetCall, AddCarinfoView {

    private AlertDialog.Builder builder;

    private OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();

    ImageView back_btn;
    TextView title_lab;

    EditText coopname;
    EditText carNum;
    EditText cartype;
    EditText jijuhao;
    EditText tag;
    EditText carbh;
    EditText xialagan;
    EditText depth;
    EditText workwidth;

    Spinner worktype_sp;
    Spinner jijutype_sp;
    Spinner cgq_sp;


    Button queren_btn;

    @BindView(R.id.host_id)
    EditText carid_edit;
    @BindView(R.id.name)
    EditText name_edit;

    @BindView(R.id.phone_edit)
    EditText phone_edit;

    @BindView(R.id.shengfen)
    Spinner province_spinner;

    @BindView(R.id.chengshi)
    Spinner city_spinner;

    @BindView(R.id.xiangzhen)
    Spinner town_spinner;

    @BindView(R.id.quyu)
    Spinner quyu_spinner;

    @BindView(R.id.coop)
    Spinner coop;
    String url = "http://39.107.152.122/fm/app/api/province/listData?parentCode=";
    private String province_url="";
    private String city_url="";
    private String town_url="";
    private String quyu_url="";
    private String coop_url = "";

    private String oldMessage_url = "";

    private String worktype_id = "";
    private String jijutype_id = "";
    private String cgq_id = "";
    private String installUserCode = "";
    private String user_name = "";
    private String phong_num = "";
    private String carid_intent = "";
//    private JSONObject fmCar_obj = new JSONObject();
//    private JSONObject fmCarInfo_obj = new JSONObject();
//    private JSONObject fmCarInstall_obj = new JSONObject();
    private ArrayAdapter<String> adapter;

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO 接收消息并且去更新UI线程上的控件内容
            Bundle b = msg.getData();
            if (msg.what == 1) {

                province_spinner.setSelection(b.getInt("pos"),true);
            }else if (msg.what == 2){
                city_spinner.setSelection(b.getInt("pos"),true);
            }
            super.handleMessage(msg);
        }
    };
    private final static String[] texts = {"张三", "李四", "王五"};

    private final static String[] worktypes =  { "23托管整地", "24托管播种", "25托管防治 ", "26托管收获", "31深松 ", "32水田 ",
            "33秸秆还田 ", "34免耕播种 ", "35植保 ", "36收获 ", "37插秧 ", "38水田旋耕 ", "39水田整地 ", "3A打捆 ", "22托管"};
    private final static String[] jijutypes = { "0深松机", "1旋耕机", "2插秧机", "3牵引式免耕播种机", "4液压式免耕播种机",
            "5翻转犁", "6液压式圆盘耙", "7牵引式圆盘耙","8收获机","9LN型深松机","A植保打药机","B植保流量计","C打捆机" };
    private final static String[] chuangan2s = { "0左侧", "1右侧" };
    private final static String[] coops = {};


    private String[] worktype_ids = {"23","24","25","26","31","32","33","34","35","36","37","38","39","3A","22"};
    private String[] jijutype_ids = {"0","1","2","3","4","5","6","7","8","9LN","A","B","C"};
    private String[] cgq_ids = {"0","1"};
    private String[] coop_ids = {};

    private String province_str = "";// 省
    private String city_str = "";// 市
    private String county_str = "";// 区
    private String towns_str = "";// 乡镇
    private String coop_str = "";

    private String province_id = "";// 省
    private String city_id = "";// 市
    private String county_id = "";// 区
    private String towns_id = "";// 乡镇
    private String coop_id = "";
    private String fmCarId = "";


    private List<Province> provinceList1 = new ArrayList<Province>();
    private List<Province> cityList = new ArrayList<Province>();
    private List<Province> quyuList = new ArrayList<Province>();
    private List<Province> townList = new ArrayList<Province>();
    private List<Province> coopList = new ArrayList<Province>();

    private UpdateCarinfoPresenter updateCarinfoPresenter = new UpdateCarinfoPresenter(this);

    private Context context = this;

    private final static int[] values = {1, 2, 3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addframinfors);

        Intent intent = getIntent();
        user_name = intent.getStringExtra("name");
        phong_num = intent.getStringExtra("phone");
        carid_intent = intent.getStringExtra("carid");
        if (user_name != null||phong_num != null){
            netGetValue();
        }

        initview();

        if (carid_intent!=null){
            netGetinfowithCarid(carid_intent);
        }


    }

    public void initview(){
        back_btn = findViewById(R.id.iv_back);

        TextView edit_btn = findViewById(R.id.nav_edit);
        edit_btn.setVisibility(View.GONE);
        title_lab = findViewById(R.id.nav_title);

        carid_edit = findViewById(R.id.host_id);
        name_edit = findViewById(R.id.name);
        phone_edit = findViewById(R.id.phone_edit);
//        姓名电话赋值
        name_edit.setText(user_name);
        phone_edit.setText(phong_num);
        if (user_name!= null||phong_num!=null){
            name_edit.setFocusable(false);
            phone_edit.setFocusable(false);
            name_edit.setFocusableInTouchMode(false);
            phone_edit.setFocusableInTouchMode(false);
        }

        carNum = findViewById(R.id.car_number);
        cartype = findViewById(R.id.brand);
        jijuhao = findViewById(R.id.jijuhao);
        tag = findViewById(R.id.tag);
        carbh = findViewById(R.id.bianhao);

        xialagan = findViewById(R.id.xialagan);
        depth = findViewById(R.id.now_depth);
        workwidth = findViewById(R.id.fukuan);

        worktype_sp = findViewById(R.id.worktype);
        jijutype_sp = findViewById(R.id.jijutype);
        cgq_sp = findViewById(R.id.chuangan2);

        coopname = findViewById(R.id.coopname);
        coop = findViewById(R.id.coop);
        //提交按钮
        queren_btn = findViewById(R.id.bt_queren);

        province_spinner = findViewById(R.id.shengfen);
        city_spinner = findViewById(R.id.chengshi);
        town_spinner = findViewById(R.id.xiangzhen);
        quyu_spinner = findViewById(R.id.quyu);

        title_lab.setText("新增农机");
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        queren_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carid = carid_edit.getText().toString();
                String username = name_edit.getText().toString();
                String phone = phone_edit.getText().toString();
                String carnum = carNum.getText().toString();
                String cartyep = cartype.getText().toString();
                String jiju = jijuhao.getText().toString();
                String tagstr = tag.getText().toString();
                String carbhstr = carbh.getText().toString();
                String xialastr = xialagan.getText().toString();
                String depthstr = depth.getText().toString();
                String widthstr = workwidth.getText().toString();

//                province_id,city_id,county_id,towns_id,worktype_id,jijutype_id,cgq_id;

                if(carid.equals("")||username.equals("")||phone.equals("")||xialastr.equals("")||depthstr.equals("")
                        ||widthstr.equals("")||province_id.equals("")||city_id.equals("")||coop_id.equals("")){
                    Toast.makeText(context,"有必填项未填写",Toast.LENGTH_SHORT).show();
                }else {
                    Log.d("1", "主机号: " +carid_edit.getText());
                    Log.d("2", "姓名: " +name_edit.getText());
                    Log.d("3", "电话: " +phone_edit.getText());
                    Log.d("4", "车牌号：" +carNum.getText());
                    Log.d("5", "车辆品牌: " +cartype.getText());
                    Log.d("6", "机具号: " +jijuhao.getText());
                    Log.d("7", "标识: " +tag.getText());
                    Log.d("7", "车辆编号: " +carbh.getText());
                    Log.d("7", "下拉杆: " +xialagan.getText());
                    Log.d("7", "作业深度: " +depth.getText());
                    Log.d("7", "幅宽: " +workwidth.getText());
                    Log.d("7", "省份id: " + province_id);
                    Log.d("7", "城市id: " + city_id);
                    Log.d("7", "区域id: " + county_id);
                    Log.d("7", "乡镇id: " + towns_id);
//                    dialog
                    showTwo();
                    installUserCode = SpUtils.GetConfigString(context,"usercode");

                }
            }
        });

        //合作社模糊搜索
        coopname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("1", coopname.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Getcoop(coopname.getText().toString());
            }
        });

//        传感器信息绑定
        setSpinner();

    }

    /**
     * 安卓dialog
     *
     */
//    private void showTwo() {
//
//        builder = new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("提示")
//                .setMessage("是否进行安装流程").setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        //ToDo: 你想做的事情
////                        Toast.makeText(context, "确定按钮", Toast.LENGTH_LONG).show();
////                        发送网络访问
//
//                        PostCarinfo();
//
//                    }
//                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        //ToDo: 你想做的事情
//                        Toast.makeText(context, "关闭按钮", Toast.LENGTH_LONG).show();
//
//                        dialogInterface.dismiss();
//                    }
//                });
//        builder.create().show();
//    }
    private void showTwo() {

        builder = new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("提示").setMessage("是否进行安装流程");
//                .setPositiveButton("保存返回", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        //ToDo: 你想做的事情
//                        Toast.makeText(context, "确定按钮", Toast.LENGTH_LONG).show();
////                        发送网络访问
//
//                        PostCarinfo();
//                    }
//                }).setNegativeButton("进入安装", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        //ToDo: 你想做的事情
//                        Toast.makeText(context, "关闭按钮", Toast.LENGTH_LONG).show();
//                        Log.d("1", "主机号: " +carid_edit.getText());
//                        Log.d("2", "姓名: " +name_edit.getText());
//                        Log.d("3", "电话: " +phone_edit.getText());
//                        Log.d("4", "车牌号：" +carNum.getText());
//                        Log.d("5", "车辆品牌: " +cartype.getText());
//                        Log.d("6", "机具号: " +jijuhao.getText());
//                        Log.d("7", "标识: " +tag.getText());
//                        Log.d("7", "车辆编号: " +carbh.getText());
//                        Log.d("7", "下拉杆: " +xialagan.getText());
//                        Log.d("7", "作业深度: " +depth.getText());
//                        Log.d("7", "幅宽: " +workwidth.getText());
//                        Log.d("7", "省份id: " + province_id);
//                        Log.d("7", "城市id: " + city_id);
//                        Log.d("7", "区域id: " + county_id);
//                        Log.d("7", "乡镇id: " + towns_id);
//
//                        dialogInterface.dismiss();
//                        Intent intent = new Intent();
////                        intent.putExtra("sensor1tv", sensor1tv);//1号传感器安装方向显示文字
////                        intent.putExtra("sensor2tv", sensor2tv);//2号传感器安装方向显示文字
////                        intent.putExtra("sensor3tv", sensor3tv);//3号传感器安装方向显示文字
////                        intent.putExtra("sensor1", spshu3);//1号传感器安装方向
//                        intent.putExtra("sensor2", cgq_id);//2号传感器安装方向
////                        intent.putExtra("sensor3", spshu4);//3号传感器安装方向
//                        intent.putExtra("xialagan", xialagan.getText().toString());//下拉杆长度
////                        intent.putExtra("linkploughheight", link_length2.getText().toString());//下拉杆机具连接点到犁尖长度
////                        intent.putExtra("linkgroundheight", lowBarPloughHeight.getText().toString());//下拉杆机具连接点到地面垂直高度
////                        intent.putExtra("ploughgroundheight", plough_ground_height.getText().toString());//犁尖到地面垂直高度
//                        intent.putExtra("jijutype", jijutype_id);//机具类型
////                        intent.putExtra("jijutypetv", jijutypetv);//机具类型显示文字
//                        intent.putExtra("carId", carid_edit.getText().toString());//主机号
//                        intent.putExtra("spworktype", worktype_id);//
////                        intent.putExtra("sphez", cooperation_id);//
////                        intent.putExtra("spshu1", spshu1);//
////                        intent.putExtra("spshu3", spshu3);//
////                        intent.putExtra("spshu4", spshu4);//
////                        intent.putExtra("circleradius", circleradius.getText().toString().trim());//圆形耙半径
////                        intent.putExtra("Machine_spacing", Machine_spacing.getText().toString().trim());//机具两侧犁尖高度
////                        intent.putExtra("sensor2l", sensor2l);//2号传感器位置
////                        intent.putExtra("type", type);//
//
//                        intent.setClass(AddCarinfoActivity.this, RegisteActivity.class);//......................
//                        startActivity(intent);
//                    }
//                });

        builder.setPositiveButton("保存返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "确定按钮", Toast.LENGTH_LONG).show();
//                        发送网络访问
                PostCarinfo();
            }
        });
        builder.setNeutralButton("进入安装", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "关闭按钮", Toast.LENGTH_LONG).show();
                Log.d("1", "主机号: " +carid_edit.getText());
                Log.d("2", "姓名: " +name_edit.getText());
                Log.d("3", "电话: " +phone_edit.getText());
                Log.d("4", "车牌号：" +carNum.getText());
                Log.d("5", "车辆品牌: " +cartype.getText());
                Log.d("6", "机具号: " +jijuhao.getText());
                Log.d("7", "标识: " +tag.getText());
                Log.d("7", "车辆编号: " +carbh.getText());
                Log.d("7", "下拉杆: " +xialagan.getText());
                Log.d("7", "作业深度: " +depth.getText());
                Log.d("7", "幅宽: " +workwidth.getText());
                Log.d("7", "省份id: " + province_id);
                Log.d("7", "城市id: " + city_id);
                Log.d("7", "区域id: " + county_id);
                Log.d("7", "乡镇id: " + towns_id);

                dialog.dismiss();
                Intent intent = new Intent();
//                        intent.putExtra("sensor1tv", sensor1tv);//1号传感器安装方向显示文字
//                        intent.putExtra("sensor2tv", sensor2tv);//2号传感器安装方向显示文字
//                        intent.putExtra("sensor3tv", sensor3tv);//3号传感器安装方向显示文字
                        intent.putExtra("sensor1", "0");//1号传感器安装方向
                intent.putExtra("sensor2", cgq_id);//2号传感器安装方向
                        intent.putExtra("sensor3", "0");//3号传感器安装方向
                intent.putExtra("xialagan", xialagan.getText().toString());//下拉杆长度
                        intent.putExtra("linkploughheight", "0");//下拉杆机具连接点到犁尖长度
                        intent.putExtra("linkgroundheight", "0");//下拉杆机具连接点到地面垂直高度
                        intent.putExtra("ploughgroundheight", depth.getText().toString());//犁尖到地面垂直高度
                intent.putExtra("jijutype", jijutype_id);//机具类型
//                        intent.putExtra("jijutypetv", jijutypetv);//机具类型显示文字
                intent.putExtra("carId", carid_edit.getText().toString());//主机号
                intent.putExtra("spworktype", worktype_id);//
//                        intent.putExtra("sphez", cooperation_id);//
//                        intent.putExtra("spshu1", spshu1);//
//                        intent.putExtra("spshu3", spshu3);//
//                        intent.putExtra("spshu4", spshu4);//
//                        intent.putExtra("circleradius", circleradius.getText().toString().trim());//圆形耙半径
                        intent.putExtra("Machine_spacing", workwidth.getText().toString().trim());//机具两侧犁尖高度
//                        intent.putExtra("sensor2l", sensor2l);//2号传感器位置
//                        intent.putExtra("type", type);//

                intent.setClass(EditCarinfoActivity.this, RegisteActivity.class);//......................
                startActivity(intent);
            }
        });

        builder.create().show();
    }

    public void PostCarinfo(){

        Map<String,String> carinfomap = new HashMap<String, String>() {{
            put("carId",carid_edit.getText().toString());
            put("owner",name_edit.getText().toString());
            put("ownerPhone",phone_edit.getText().toString());
            put("plateNumber",carNum.getText().toString());
            put("toolId",jijuhao.getText().toString());
            put("flag",tag.getText().toString());
//                        put("车辆编号",carbh.getText().toString());
            put("ploughGroundHeight",depth.getText().toString());
            put("province",province_id);
            put("city",city_id);
            put("county",county_id);
            put("towns",towns_id);
            put("cooperation",carNum.getText().toString());
            put("lowBarLength",xialagan.getText().toString());
            put("sensor2Direction",cgq_id);
            put("workType",worktype_id);
            put("toolType",jijutype_id);
            put("installUserCode",installUserCode);
            put("width",workwidth.getText().toString());
            put("cooperation",coop_id);
            put("fmCarId",fmCarId);
            String mobileImi = SpUtils.GetConfigString(context,"mobileImi");
            put("mobileImi",mobileImi);
        }};
        updateCarinfoPresenter.updatecarinfoData(carinfomap);
    }

    /**
     * 新增农机网络访问结果
     */

    @Override
    public void GetAddCarinfoSuccess( AddcarinfoModel addcarinfoModel) {
//        Log.d("1",addcarinfoModel.getMessage());
        if (addcarinfoModel.getResult().equals("true")){
            if (addcarinfoModel.getMessage().equals("保存成功")){
                Toast.makeText(context,addcarinfoModel.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(context,addcarinfoModel.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void GetAddCarinfoError(Throwable e) {

    }

    public void netGetinfowithCarid(String carid){
        String neturl = "http://39.107.152.122/fm/app/install/api/carInfo?carId=";
        oldMessage_url = neturl.concat(carid);
        okHttpUtils.getDataAsyn(oldMessage_url,this);
    }
    public void netGetValue() {

        String parentCode = "0";
        province_url = url.concat(parentCode);
        okHttpUtils.getDataAsyn(province_url,this);
    }

    public void Getcity(String officeCode){

        city_url = url.concat(officeCode);
        okHttpUtils.getDataAsyn(city_url,this);
    }
    public void Gettown(String officeCode){

        town_url = url.concat(officeCode);
        okHttpUtils.getDataAsyn(town_url,this);
    }
    public void Getquyu(String officeCode){

        quyu_url = url.concat(officeCode);
        okHttpUtils.getDataAsyn(quyu_url,this);
    }

    public void Getcoop(String coopname){

        String coopurl = "http://39.107.152.122/fm/app/api/fmCoop/listData?name=";

        coop_url = coopurl.concat(coopname);

        okHttpUtils.getDataAsyn(coop_url,this);
    }

    public void setSpinner(){
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, texts);
//        //设置下拉列表的风格
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        province_spinner.setAdapter(adapter);
//        province_spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
//        province_spinner.setVisibility(View.VISIBLE);

        //简单的string数组适配器：样式res，数组
        ArrayAdapter<String> wortypeAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,worktypes);
        worktype_sp.setAdapter(wortypeAdapter);
        worktype_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                worktype_id = worktype_ids[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> jijutypeAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,jijutypes);
        jijutype_sp.setAdapter(jijutypeAdapter);
        jijutype_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jijutype_id = jijutype_ids[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> cgqAdapte = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,chuangan2s);
        cgq_sp.setAdapter(cgqAdapte);
        cgq_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cgq_id = cgq_ids[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            //利用数组中的对应位置取得values中需要的值
            int Id = values[arg2];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    public void success(Call call, Response response) throws IOException {
//        Log.d("1", "onResponse: " + response.request().url().toString());
        if (response.request().url().toString().equals(province_url)){
            try {
                JSONObject json_objs = new JSONObject(response.body().string());
//            JSONObject jsonObjects = new JSONObject(response.body().string());
                provinceList1.clear();
                if (json_objs.get("result").toString().equals("true")) {
                    JSONArray json_arr = json_objs.getJSONArray("data");
                    if(json_arr.length()!=0){
                        for(int i=0;i<json_arr.length();i++){
                            if(i==0){
                                Province first=new Province();
                                first.setOfficeName("请选择省份");
                                first.setOfficeCode("");
                                provinceList1.add(first);
                            }
                            Province cpl=new Province();
                            JSONObject jo=(JSONObject) json_arr.get(i);
                            cpl.setOfficeName(jo.getString("officeName"));
                            cpl.setOfficeCode(jo.getString("officeCode"));
                            provinceList1.add(cpl);
                        }
                    }
                }

                testSpinner1();

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(response.request().url().toString().equals(city_url)){
            try {
                JSONObject json_objs = new JSONObject(response.body().string());
//            JSONObject jsonObjects = new JSONObject(response.body().string());
                cityList.clear();
                if (json_objs.get("result").toString().equals("true")) {
                    JSONArray json_arr = json_objs.getJSONArray("data");
                    if(json_arr.length()!=0){
                        for(int i=0;i<json_arr.length();i++){
                            if(i==0){
                                Province first=new Province();
                                first.setOfficeName("请选择城市");
                                first.setOfficeCode("");
                                cityList.add(first);
                            }
                            Province cpl=new Province();
                            JSONObject jo=(JSONObject) json_arr.get(i);
                            cpl.setOfficeName(jo.getString("officeName"));
                            cpl.setOfficeCode(jo.getString("officeCode"));
                            cityList.add(cpl);
                        }
                    }
                }

                setCitySpinner();

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(response.request().url().toString().equals(quyu_url)){
            try {
                JSONObject json_objs = new JSONObject(response.body().string());
//            JSONObject jsonObjects = new JSONObject(response.body().string());
                quyuList.clear();
                if (json_objs.get("result").toString().equals("true")) {
                    JSONArray json_arr = json_objs.getJSONArray("data");
                    if(json_arr.length()!=0){
                        for(int i=0;i<json_arr.length();i++){
                            if(i==0){
                                Province first=new Province();
                                first.setOfficeName("请选择区域");
                                first.setOfficeCode("");
                                quyuList.add(first);
                            }
                            Province cpl=new Province();
                            JSONObject jo=(JSONObject) json_arr.get(i);
                            cpl.setOfficeName(jo.getString("officeName"));
                            cpl.setOfficeCode(jo.getString("officeCode"));
                            quyuList.add(cpl);
                        }
                    }
                }

                setQuyuSpinner();

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(response.request().url().toString().equals(town_url)){
            try {
                JSONObject json_objs = new JSONObject(response.body().string());
//            JSONObject jsonObjects = new JSONObject(response.body().string());
                townList.clear();
                if (json_objs.get("result").toString().equals("true")) {
                    JSONArray json_arr = json_objs.getJSONArray("data");
                    if(json_arr.length()!=0){
                        for(int i=0;i<json_arr.length();i++){
                            if(i==0){
                                Province first=new Province();
                                first.setOfficeName("请选择乡镇");
                                first.setOfficeCode("");
                                townList.add(first);
                            }
                            Province cpl=new Province();
                            JSONObject jo=(JSONObject) json_arr.get(i);
                            cpl.setOfficeName(jo.getString("officeName"));
                            cpl.setOfficeCode(jo.getString("officeCode"));
                            townList.add(cpl);
                        }
                    }
                }

                setTwonSpinner();

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if(response.request().url().toString().equals(oldMessage_url)){

            try {
                JSONObject json_objs = new JSONObject(response.body().string());
                if (json_objs.get("result").toString().equals("true")) {
                    JSONObject jsonObject = json_objs.getJSONObject("data");
                    final JSONObject fmCar_obj = jsonObject.getJSONObject("fmCar");
                    final JSONObject fmCarInfo_obj = jsonObject.getJSONObject("fmCarInfo");
                    final JSONObject fmCarInstall_obj = jsonObject.getJSONObject("fmCarInstall");
                    final JSONObject coop_obj = fmCar_obj.getJSONObject("cooperation");
                    carid_edit.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                carid_edit.setText(fmCar_obj.getString("carId"));
                                name_edit.setText(fmCar_obj.getString("owner"));
                                phone_edit.setText(fmCar_obj.getString("ownerPhone"));
                                carNum.setText(fmCarInfo_obj.getString("plateNumber"));
                                jijuhao.setText(fmCarInfo_obj.getString("toolId"));
                                tag.setText(fmCarInstall_obj.getString("flag"));

                                workwidth.setText(fmCar_obj.getString("width"));
                                depth.setText(fmCarInstall_obj.getString("ploughGroundHeight"));

                                province_id = fmCar_obj.getString("province");
                                city_id = fmCar_obj.getString("city");
                                county_id = fmCar_obj.getString("county");
                                towns_id = fmCar_obj.getString("towns");
                                xialagan.setText(fmCarInstall_obj.getString("lowBarLength"));
                                cgq_id = fmCarInstall_obj.getString("sensor2Direction");
                                worktype_id = fmCar_obj.getString("workType");
                                jijutype_id = fmCarInfo_obj.getString("toolType");
                                coop_id = coop_obj.getString("id");
//                                coop_str = coop_obj.getString("name");
                                fmCarId = fmCar_obj.getString("id");
                                /**
                                 * 数据反显
                                 */


                                if (worktype_id != "") {
//
                                    for(int i = 0;i<worktype_ids.length;i++){
                                        String value = worktype_ids[i];
                                        if(value.equals(worktype_id)){
                                            final int j = i;
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    worktype_sp.setSelection(j,true);
                                                }
                                            });
                                        }
                                    }
                                }
                                if (jijutype_id != null) {
                                    for(int i = 0;i<jijutype_ids.length;i++){
                                        String value = jijutype_ids[i];
                                        if(value.equals(jijutype_id)){
                                            final int j = i;
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    jijutype_sp.setSelection(j,true);
                                                }
                                            });
                                        }
                                    }
                                }
                                if (cgq_id != null) {

                                    for(int i = 0;i<cgq_ids.length;i++){
                                        String value = cgq_ids[i];
                                        if(value.equals(cgq_id)){
                                            final int j = i;
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    cgq_sp.setSelection(j,true);
                                                }
                                            });
                                        }
                                    }
                                }
                                if (coop_id != null){
                                    Getcoop("");
                                }
//                                setCoopSpinner();


                            }catch (Exception e){
                                Log.d("7", "乡镇id: " + e.getMessage());
                            }

                        }
                    });
                    netGetValue();

                }

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            try {
                JSONObject json_objs = new JSONObject(response.body().string());
                coopList.clear();
                if (json_objs.get("result").toString().equals("true")) {
                    JSONArray json_arr = json_objs.getJSONArray("data");
                    if(json_arr.length()!=0){
                        for(int i=0;i<json_arr.length();i++){
                            if(i==0){
                                Province first=new Province();
                                first.setOfficeName("请选择合作社");
                                first.setOfficeCode("");
                                coopList.add(first);
                            }
                            Province cpl=new Province();
                            JSONObject jo=(JSONObject) json_arr.get(i);
                            cpl.setOfficeName(jo.getString("name"));
                            cpl.setOfficeCode(jo.getString("id"));
                            coopList.add(cpl);
                        }
                    }
                }

                setCoopSpinner();

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
    public void failed(Call call, IOException e){

    }

    private void testSpinner1() {
        final String[] spinnerItems = new String[provinceList1.size()];
        final String[] spinnerItems_id = new String[provinceList1.size()];
        for (int i = 0; i < provinceList1.size(); i++) {
            spinnerItems[i] = provinceList1.get(i).getOfficeName();
            spinnerItems_id[i] = provinceList1.get(i).getOfficeCode();
        }

        province_spinner.post(new Runnable() {
            @Override
            public void run() {
                //简单的string数组适配器：样式res，数组

                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,spinnerItems);
                //绑定 Adapter到控件
                province_spinner.setAdapter(spinnerAdapter);
            }
        });

        //选择监听
        province_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
//	                Toast.makeText(context, "选择了["+spinnerItems[pos]+"]", Toast.LENGTH_SHORT).show();

                province_str = spinnerItems[pos];
                province_id = spinnerItems_id[pos];
                if (province_id!=""){
                    Getcity(province_id);
                }

//	                //设置spinner内的填充文字居中
//	                ((TextView)view).setGravity(Gravity.CENTER);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback

            }
        });

        if (!province_id.equals("")) {
            String temp1 = "";
            for ( int i = 0; i < provinceList1.size(); i++) {
                temp1 = provinceList1.get(i).getOfficeCode();
                if (temp1.equals(province_id)) {
                    Message msg = new Message();
                    msg.what = 1;
                    Bundle b = new Bundle();
                    b.putInt("pos", i);
                    msg.setData(b);
//                    msg.obj = i;
                    handler.sendMessage(msg);
                }
            }
        }
    }
    /**
     * 测试：加载数据列，监听选择  市
     * */
    private void setCitySpinner(){
        final String[] spinnerItems2 = new String[cityList.size() ];
        final String[] spinnerItems_id2 = new String[cityList.size() ];
        for(int i = 0;i<cityList.size();i++){
            spinnerItems2[i] = cityList.get(i).getOfficeName();
            spinnerItems_id2[i] = cityList.get(i).getOfficeCode();
        }

        province_spinner.post(new Runnable() {
            @Override
            public void run() {
                //简单的string数组适配器：样式res，数组

                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,spinnerItems2);
                //绑定 Adapter到控件
                city_spinner.setAdapter(spinnerAdapter);
            }
        });


        //选择监听
        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
//		                Toast.makeText(context, "选择了["+spinnerItems[pos]+"]", Toast.LENGTH_SHORT).show();

                city_str = spinnerItems2[pos];
                city_id= spinnerItems_id2[pos];

                if (city_id!="") {
                    Getquyu(city_id);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback

            }
        });
        if(!city_id.equals("")){
            String temp2 = "";
            for(int i = 0;i<cityList.size();i++){
                temp2 = cityList.get(i).getOfficeCode();
                if(temp2.equals(city_id)){
                    final int j = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            city_spinner.setSelection(j,true);
                        }
                    });
                    //                    Message msg = new Message();
//                    msg.what = 2;
//                    Bundle b = new Bundle();
//                    b.putInt("pos", i);
//                    msg.setData(b);
////                    msg.obj = i;
//                    handler.sendMessage(msg);
//                    city_spinner.setSelection(i,true);
                }
            }
        }
    }

    /**
     * 测试：加载数据列，监听选择  区域
     * */
    private void setQuyuSpinner(){
        final String[] spinnerItems3 = new String[quyuList.size() ];
        final String[] spinnerItems_id3 = new String[quyuList.size() ];
        for(int i = 0;i<quyuList.size();i++){
            spinnerItems3[i] = quyuList.get(i).getOfficeName();
            spinnerItems_id3[i] = quyuList.get(i).getOfficeCode();
        }
        quyu_spinner.post(new Runnable() {
            @Override
            public void run() {
                //简单的string数组适配器：样式res，数组

                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,spinnerItems3);
                //绑定 Adapter到控件
                quyu_spinner.setAdapter(spinnerAdapter);
            }
        });

        //选择监听
        quyu_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                county_str = spinnerItems3[pos];
                county_id= spinnerItems_id3[pos];
                if (county_id!="") {
                    Gettown(county_id);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback

            }
        });
        if(!county_id.equals("")){
            String temp3 = "";
            for(int i = 0;i<quyuList.size();i++){
                temp3 = quyuList.get(i).getOfficeCode();
                if(temp3.equals(county_id)){
                    final int j = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            quyu_spinner.setSelection(j,true);
                        }
                    });

                }
            }
        }
    }
    /**
     * 测试：加载数据列，监听选择  乡镇
     * */
    private void setTwonSpinner(){

        final String[] spinnerItems4 = new String[townList.size() ];
        final String[] spinnerItems_id4 = new String[townList.size() ];
        for(int i = 0;i<townList.size();i++){
            spinnerItems4[i] = townList.get(i).getOfficeName();
            spinnerItems_id4[i] = townList.get(i).getOfficeCode();
        }
        town_spinner.post(new Runnable() {
            @Override
            public void run() {
                //简单的string数组适配器：样式res，数组

                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,spinnerItems4);
                //绑定 Adapter到控件
                town_spinner.setAdapter(spinnerAdapter);
            }
        });

        //选择监听
        town_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
//				                Toast.makeText(context, "选择了["+spinnerItems[pos]+"]", Toast.LENGTH_SHORT).show();

                towns_str = spinnerItems4[pos];
                towns_id = spinnerItems_id4[pos];

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback

            }
        });

        if(!towns_id.equals("")){
            String temp4 = "";
            for(int i = 0;i<townList.size();i++){
                temp4 = townList.get(i).getOfficeCode();
                if(temp4.equals(towns_id)){
                    final int j = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            town_spinner.setSelection(j,true);
                        }
                    });

                }
            }
        }
    }

    /**
     * 测试：加载数据列，监听选择  合作社
     * */
    private void setCoopSpinner(){

        final String[] spinnerItems5 = new String[coopList.size() ];
        final String[] spinnerItems_id5 = new String[coopList.size() ];
        for(int i = 0;i<coopList.size();i++){
            spinnerItems5[i] = coopList.get(i).getOfficeName();
            spinnerItems_id5[i] = coopList.get(i).getOfficeCode();
        }
        coop.post(new Runnable() {
            @Override
            public void run() {
                //简单的string数组适配器：样式res，数组
                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,spinnerItems5);
                //绑定 Adapter到控件
                coop.setAdapter(spinnerAdapter);
            }
        });

        //选择监听
        coop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
//				                Toast.makeText(context, "选择了["+spinnerItems[pos]+"]", Toast.LENGTH_SHORT).show();

                coop_str = spinnerItems5[pos];
                coop_id = spinnerItems_id5[pos];

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback

            }
        });

        if(!coop_id.equals("")){
            String temp4 = "";
            for(int i = 0;i<coopList.size();i++){
                temp4 = coopList.get(i).getOfficeCode();
                if(temp4.equals(coop_id)){
                    final int j = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            coop.setSelection(j,true);
                        }
                    });


                }
            }
        }
    }
    private void setoldCoopSp(){

        final String[] spinnerItems5 = new String[coops.length];
        final String[] spinnerItems_id5 = new String[coop_ids.length ];
        for(int i = 0;i<coops.length;i++){
            spinnerItems5[i] = coops[i];
            spinnerItems_id5[i] = coop_ids[i];
        }
        coop.post(new Runnable() {
            @Override
            public void run() {
                //简单的string数组适配器：样式res，数组
                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,spinnerItems5);
                //绑定 Adapter到控件
                coop.setAdapter(spinnerAdapter);
            }
        });

        //选择监听
        coop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
//				                Toast.makeText(context, "选择了["+spinnerItems[pos]+"]", Toast.LENGTH_SHORT).show();

                coop_str = spinnerItems5[pos];
                coop_id = spinnerItems_id5[pos];

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback

            }
        });

        if(!coop_id.equals("")){
//            String temp4 = "";
//            for(int i = 0;i<coopList.size();i++){
//                temp4 = coopList.get(i).getOfficeCode();
//                if(temp4.equals(coop_id)){
//                    final int j = i;
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            coop.setSelection(j,true);
//                        }
//                    });
//
//
//                }
//            }
        }
    }

}
