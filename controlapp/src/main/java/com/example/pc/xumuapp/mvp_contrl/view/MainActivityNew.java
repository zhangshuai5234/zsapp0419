package com.example.pc.xumuapp.mvp_contrl.view;

import android.content.Context;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.adapter.ControlListAdapter;
import com.example.pc.xumuapp.mvp_contrl.model.ChangeControlModel;
import com.example.pc.xumuapp.mvp_contrl.model.ControlListModel;
import com.example.pc.xumuapp.mvp_contrl.presenter.ControlBtnPresenter;
import com.example.pc.xumuapp.mvp_contrl.presenter.ControlPresenter;
import com.example.pc.xumuapp.retrofit.ProgressDialogHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivityNew extends AppCompatActivity implements ControlView,ChangeControlView, ControlListAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    private TextView wendu_tv;
    private TextView shidu_tv;
//    private TextView shidu_tv;
    private ListView mainlistview;
    private EditText starttime_edit;
    private View listheadview;
    private ControlPresenter controlPresenter;
    private ControlBtnPresenter controlBtnPresenter;
    private List<ControlListModel.DataBean> mainlist = new ArrayList<ControlListModel.DataBean>();
    private Context context = this;

    private ProgressDialogHandler progressDialogHandler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        initview();
        NetGetValue();
    }
    public void initview(){
        LayoutInflater lif = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);

        listheadview = lif.inflate(R.layout.mainheader,null,false);
        mainlistview = findViewById(R.id.main_list);
        mainlistview.addHeaderView(listheadview);
        starttime_edit = findViewById(R.id.starttime_edit);
        mainlistview.setOnItemClickListener(this);
        progressDialogHandler = new ProgressDialogHandler(context, null, true);
    }

    public void NetGetValue(){
        controlPresenter = new ControlPresenter(this);
        showProgressDialog(true);
        controlPresenter.loadControlListData("123456");
    }

    @Override
    public void GetListSuccess(ControlListModel controlListModel) {
        showProgressDialog(false);
        if(controlListModel.getResult().equals("true")){
            mainlist = controlListModel.getData();
            if (mainlist.size() != 0){
                ControlListAdapter adapter = new ControlListAdapter(context,mainlist);
                adapter.setOnInnerItemOnClickListener(this);
                mainlistview.setAdapter(adapter);


            }
        }else {

        }

    }

    @Override
    public void GetListError(Throwable e) {
        showProgressDialog(false);
    }

    @Override
    public void ChangeSuccess(ChangeControlModel changeControlModel) {
        showProgressDialog(false);
        Toast.makeText(context,changeControlModel.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ChangeError(Throwable e) {
        showProgressDialog(false);
    }

    public void itemClick(View v,String editstr) {
        controlBtnPresenter = new ControlBtnPresenter(this);
        int position;
        position = (int) v.getTag();
        switch (v.getId()) {
            case R.id.start_btn:
//                Log.e("内部item--1-->", position + "");
                String equipStatus  = "01,";
                String editStr = editstr;

                for (int i = editStr.length(); i < 4; i++){
                    editStr = "0" +editStr;
                }
                equipStatus = equipStatus + editStr;
                showProgressDialog(true);
                controlBtnPresenter.ChangeControlStatus(mainlist.get(position).getEquipCode(),equipStatus);
                break;
            case R.id.end_btn:
                String equipStatus1  = "02,0000";
                showProgressDialog(true);
                controlBtnPresenter.ChangeControlStatus(mainlist.get(position).getEquipCode(),equipStatus1);
//                Log.e("内部item--2-->", position + "");
                break;
            default:
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
