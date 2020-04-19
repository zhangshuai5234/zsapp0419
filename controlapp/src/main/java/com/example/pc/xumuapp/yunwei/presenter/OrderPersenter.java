package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.OrderModel;
import com.example.pc.xumuapp.yunwei.model.PlantModel;
import com.example.pc.xumuapp.yunwei.view.OrderView;
import com.example.pc.xumuapp.yunwei.view.PlantView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;


public class OrderPersenter extends BasePresenter<OrderView> {


    public OrderPersenter(OrderView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void PostOrder(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.postOrder(headers,jsonbody), new Subscriber<OrderModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.OrderError(e);
            }

            @Override
            public void onNext(OrderModel plantModel) {
                LogUtil.logConsole("请求成功");
                mvpView.OrderSuccess(plantModel);
            }
        });

    }

}
