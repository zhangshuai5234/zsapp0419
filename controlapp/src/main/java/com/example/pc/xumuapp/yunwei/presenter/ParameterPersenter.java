package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.OrderModel;
import com.example.pc.xumuapp.yunwei.model.ParameterModel;
import com.example.pc.xumuapp.yunwei.view.OrderView;
import com.example.pc.xumuapp.yunwei.view.ParameterView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;


public class ParameterPersenter extends BasePresenter<ParameterView> {


    public ParameterPersenter(ParameterView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void GetParameter(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.getParameter(headers,jsonbody), new Subscriber<ParameterModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetParameterError(e);
            }

            @Override
            public void onNext(ParameterModel plantModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetParameterSuccess(plantModel);
            }
        });

    }

}
