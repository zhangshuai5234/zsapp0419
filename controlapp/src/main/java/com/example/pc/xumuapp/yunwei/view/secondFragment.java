package com.example.pc.xumuapp.yunwei.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.adapter.GridviewListAdapter;
import com.example.pc.xumuapp.retrofit.ProgressDialogHandler;
import com.example.pc.xumuapp.utils.SpUtils;
import com.example.pc.xumuapp.yunwei.activity.GatherActivity;
import com.example.pc.xumuapp.yunwei.activity.GongdanActivity;
import com.example.pc.xumuapp.yunwei.activity.PackActivity;
import com.example.pc.xumuapp.yunwei.activity.PlantActivity;
import com.example.pc.xumuapp.yunwei.activity.ProcessActivity;
import com.example.pc.xumuapp.yunwei.model.EquipmentModel;
import com.example.pc.xumuapp.yunwei.presenter.EqupmentListPersenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;

public class secondFragment extends Fragment implements EquipmentListView{

 private GridView maingridview;

    private EqupmentListPersenter equpmentListPersenter = new EqupmentListPersenter(this);

    private Context context;
    private List<EquipmentModel.DataBean> mainlist = new  ArrayList<EquipmentModel.DataBean>();
//    private AdduserPresenter adduserPresenter = new AdduserPresenter(this);
    private ProgressDialogHandler progressDialogHandler = new ProgressDialogHandler(getActivity(), null, true);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        context = getContext();

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.adduser_layout,container,false);

        maingridview = view.findViewById(R.id.main_gridview);

        context = getActivity();

        initview();
        netGetValue();
        return view;
    }


    public void initview(){

        List<String> strlist = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            strlist.add("设备1");
        }

//        GridviewListAdapter gridviewListAdapter = new GridviewListAdapter(context,strlist);
//        maingridview.setAdapter(gridviewListAdapter);
    }

    @Override
    public void GetLoginSuccess(EquipmentModel adduserModel) {
//        if (!getActivity().isFinishing())//xActivity即为本界面的Activity
//        {
////dialog.show
//            Toast.makeText(context, adduserModel.getMessage(), Toast.LENGTH_SHORT).show();
//        }

//        Intent intent = new Intent(getActivity(), AddCarinfoActivity.class);]

        if (adduserModel.isSuccess()){
            mainlist = adduserModel.getData();
            GridviewListAdapter gridviewListAdapter = new GridviewListAdapter(context,mainlist);
            maingridview.setAdapter(gridviewListAdapter);
//            intent.putExtra("name",name_edit.getText().toString());
//            intent.putExtra("phone",phone_edit.getText().toString());
//            startActivity(intent);
//            name_edit.setText("");
//            phone_edit.setText("");
        }else {
            Toast.makeText(context, adduserModel.getErrorMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void GetLoginError(Throwable e) {
//        Toast.makeText(context, adduserModel.getErrorMessage(), Toast.LENGTH_SHORT).show();
        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
    }


    /**
     * 网络访问
     */
    public void netGetValue() {

        Gson gson=new Gson();
        HashMap<String,Object> paramsMap = new HashMap<>();
        HashMap<String,String> paramsMap1 = new HashMap<>();
        paramsMap.put("entity",paramsMap1);
        paramsMap.put("userToken", SpUtils.GetConfigString(context,"userToken"));
        String strEntity = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("token", SpUtils.GetConfigString(context,"userToken"));
        headmap.put("Content-Type","application/json");

        equpmentListPersenter.GetEquipList(body,headmap);

    }



}
