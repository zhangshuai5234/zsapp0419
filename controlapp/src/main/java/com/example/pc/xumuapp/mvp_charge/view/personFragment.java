package com.example.pc.xumuapp.mvp_charge.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.Tools.OkHttpUtils;
import com.example.pc.xumuapp.adapter.ChargelistAdapter;
import com.example.pc.xumuapp.mvp_charge.model.ChargeMedel;
import com.example.pc.xumuapp.mvp_charge.model.UserChargeModel;
import com.example.pc.xumuapp.mvp_charge.presenter.ChargePresent;
import com.example.pc.xumuapp.mvp_login.view.Loginactivity;
import com.example.pc.xumuapp.retrofit.ProgressDialogHandler;
import com.example.pc.xumuapp.utils.SpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class personFragment extends Fragment implements OkHttpUtils.MyNetCall,ChargeListView {

    OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
    ListView listView;
    Context context;
    View listheadview;
    private String netrul="";
    private TextView LogoutBtn;

    private EditText searchView;
    private List<UserChargeModel> mainlist = new ArrayList<UserChargeModel>();
    private ChargePresent chargePresenter = new ChargePresent(this);
    private ProgressDialogHandler progressDialogHandler ;

    private RelativeLayout changepsw_btn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        context = getContext();
        super.onCreate(savedInstanceState);
//        netGetValue();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.personfragment_layout,container,false);
        TextView navtitle = view.findViewById(R.id.nav_title);
        TextView edit_btn = view.findViewById(R.id.nav_edit);
        ImageView back = view.findViewById(R.id.iv_back);

        changepsw_btn = view.findViewById(R.id.change_psw);
        changepsw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                修改密码跳转界面
            }
        });

        LogoutBtn = view.findViewById(R.id.tv_logout);
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Loginactivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.setClass(getActivity(), Loginactivity.class);

                startActivity(intent);
            }
        });

        listView = view.findViewById(R.id.chargelist);
        listheadview = inflater.inflate(R.layout.listhead_layout,null);
        progressDialogHandler = new ProgressDialogHandler(context, null, true);

        navtitle.setText("个人中心");
        edit_btn.setVisibility(view.GONE);
        back.setVisibility(view.GONE);

        initview();

        searchView = view.findViewById(R.id.searchview);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("1", searchView.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Getcoop(searchView.getText().toString());
            }
        });


        return view;

    }
    public void initview(){
        listView.addHeaderView(listheadview);
    }
    /**
     * 网络访问
     */

    public void Getcoop(String coopname){

        String coopurl = "http://39.107.152.122/fm/app/install/api//fmAnnualFee/listData?owner=";

        netrul = coopurl.concat(coopname);
        showProgressDialog(true);
        okHttpUtils.getDataAsyn(netrul,this);
    }

    public void netGetValue() {

//        String url = "http://39.107.152.122/fm/app/install/api/user/carList?userCode=ttest_zxjz";
//        okHttpUtils.getDataAsyn(url,this);
        String usercode = SpUtils.GetConfigString(context,"usercode");
        showProgressDialog(true);
        chargePresenter.loadChargeData(usercode);
    }

    @Override
    public void GetChargeError(Throwable e) {

    }

    @Override
    public void GetChargeSuccess(ChargeMedel chargeMedel) {
        mainlist = chargeMedel.getData();
        //        try {
//            JSONObject jsonObjects = new JSONObject();
//            jsonObjects = chargeMedel.getData().toString()
//            JSONObject jsondata = jsonObjects.getJSONObject("data");
//            JSONArray jsonArray = jsondata.getJSONArray("fmUserCarList");
//            mainlist.clear();
//            for ( int i = 0; i < jsonArray.length(); i++){
//                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//                CarListModel carListModel = new CarListModel();
//                carListModel.setUserName(jsonObject.getString("carId"));
//                carListModel.setPhonNum(jsonObject.getString("carId"));
//                carListModel.setCarCount(jsonObject.getString("carId"));
//                carListModel.setImgUrl(jsonObject.getString("carId"));
//
//                mainlist.add(carListModel);
//            }
//
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
        showProgressDialog(false);
        if (mainlist.size() != 0){


            listView.post(new Runnable() {
                @Override
                public void run() {

                    ChargelistAdapter adapter = new ChargelistAdapter(context,mainlist);

                    listView.setAdapter(adapter);

                }
            });


        }
    }

    /**
     * 网络访问回调方法
     * @param call
     * @param response
     * @throws IOException
     */



    public void success(Call call, Response response) throws IOException{
//        Log.d("1", "onResponse: " + response.body().string());
        try {
            JSONObject jsonObjects = new JSONObject(response.body().string());
//            JSONObject jsondata = jsonObjects.getJSONObject("data");
            JSONArray jsonArray = jsonObjects.getJSONArray("data");
            mainlist.clear();
            for ( int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                UserChargeModel userChargeModel = new UserChargeModel();
                userChargeModel.setCarId(jsonObject.getString("carId"));
                userChargeModel.setCooperation(jsonObject.getString("cooperation"));
                userChargeModel.setInstallUser(jsonObject.getString("installUser"));
                userChargeModel.setLocation(jsonObject.getString("location"));
                userChargeModel.setOwner(jsonObject.getString("owner"));
                userChargeModel.setOwnerPhone(jsonObject.getString("ownerPhone"));
                mainlist.add(userChargeModel);
            }

        }catch (JSONException e){
            e.printStackTrace();
            Log.d("1",e.getMessage());
        }
        if (mainlist.size() != 0){


            listView.post(new Runnable() {
                @Override
                public void run() {

                    ChargelistAdapter adapter = new ChargelistAdapter(context,mainlist);

                    listView.setAdapter(adapter);
                }
            });

            showProgressDialog(false);

        }
    }

    public void failed(Call call, IOException e){

    }
    private void showProgressDialog(boolean isShow){

        if(isShow){
            Message msg = new Message();
            msg.what = progressDialogHandler.SHOW_PROGRESS_DIALOG;
            progressDialogHandler.handleMessage(msg);
        }else{
            Message msg = new Message();
            msg.what = progressDialogHandler.DISMISS_PROGRESS_DIALOG;
            progressDialogHandler.handleMessage(msg);
        }
    }
}
