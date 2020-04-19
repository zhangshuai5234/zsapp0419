package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.EquipmentModel;
import com.example.pc.xumuapp.yunwei.model.GongdanModel;
import com.example.pc.xumuapp.yunwei.view.EquipmentListView;
import com.example.pc.xumuapp.yunwei.view.gongdanView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;

public class EqupmentListPersenter extends BasePresenter<EquipmentListView> {


    public EqupmentListPersenter(EquipmentListView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void GetEquipList(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.getEquipList(headers,jsonbody), new Subscriber<EquipmentModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetLoginError(e);
            }

            @Override
            public void onNext(EquipmentModel gongdanModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetLoginSuccess(gongdanModel);
            }
        });

    }
}
