package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.EquipmentstatusModel;
import com.example.pc.xumuapp.yunwei.model.OrderModel;
import com.example.pc.xumuapp.yunwei.view.OrderView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;


public class EquipmentStatusPersenter extends BasePresenter<OrderView> {


    public EquipmentStatusPersenter(OrderView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void GetEquipmentStatus(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.getEquipmentStatus(headers,jsonbody), new Subscriber<EquipmentstatusModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetEquipmentStatusError(e);
            }

            @Override
            public void onNext(EquipmentstatusModel plantModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetEquipmentStatusSuccess(plantModel);
            }
        });

    }

}
