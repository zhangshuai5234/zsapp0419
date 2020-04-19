package com.example.pc.xumuapp.mvp_contrl.presenter;


import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.mvp_contrl.model.ChangeControlModel;
import com.example.pc.xumuapp.mvp_contrl.view.ChangeControlView;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;

import rx.Subscriber;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public class ControlBtnPresenter extends BasePresenter<ChangeControlView> {


    public ControlBtnPresenter(ChangeControlView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void ChangeControlStatus(String equipCode,String equipStatus) {
        String command = "63";
        addSubscription(apiStores.changeControl(equipCode,command,equipStatus), new Subscriber<ChangeControlModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.ChangeError(e);
            }

            @Override
            public void onNext(ChangeControlModel changeControlModel) {
                LogUtil.logConsole("请求成功");
                mvpView.ChangeSuccess(changeControlModel);
            }
        });

    }
}
