package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.PackModel;
import com.example.pc.xumuapp.yunwei.view.PackView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;


public class PackPersenter extends BasePresenter<PackView> {


    public PackPersenter(PackView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void GetPackList(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.getPackingList(headers,jsonbody), new Subscriber<PackModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetLoginError(e);
            }

            @Override
            public void onNext(PackModel packModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetLoginSuccess(packModel);
            }
        });

    }
}
