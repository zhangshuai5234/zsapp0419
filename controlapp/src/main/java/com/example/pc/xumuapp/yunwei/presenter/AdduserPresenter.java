package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.AdduserModel;
import com.example.pc.xumuapp.yunwei.view.adduserview;

import rx.Subscriber;

public class AdduserPresenter extends BasePresenter<adduserview> {


    public AdduserPresenter(adduserview view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void adduser(String logincode, String username ,String mobileImei) {

        addSubscription(apiStores.adduser(logincode, username, mobileImei), new Subscriber<AdduserModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetLoginError(e);
            }

            @Override
            public void onNext(AdduserModel adduserModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetLoginSuccess(adduserModel);
            }
        });

    }
}
