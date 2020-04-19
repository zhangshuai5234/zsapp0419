package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.GongdanModel;
import com.example.pc.xumuapp.yunwei.view.gongdanView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;

public class GongdanPersenter extends BasePresenter<gongdanView> {


    public GongdanPersenter(gongdanView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void GetGongdanList(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.getGondanList(headers,jsonbody), new Subscriber<GongdanModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetLoginError(e);
            }

            @Override
            public void onNext(GongdanModel gongdanModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetLoginSuccess(gongdanModel);
            }
        });

    }
}
