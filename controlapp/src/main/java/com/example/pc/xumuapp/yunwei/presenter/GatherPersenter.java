package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.GatherModel;
import com.example.pc.xumuapp.yunwei.view.GatherView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;


public class GatherPersenter extends BasePresenter<GatherView> {


    public GatherPersenter(GatherView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void GetGatherList(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.getGatherList(headers,jsonbody), new Subscriber<GatherModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetLoginError(e);
            }

            @Override
            public void onNext(GatherModel plantModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetLoginSuccess(plantModel);
            }
        });

    }
}
