package com.example.pc.xumuapp.newAdded.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.newAdded.model.AddcarinfoModel;
import com.example.pc.xumuapp.newAdded.view.AddCarinfoView;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;

import java.util.Map;

import rx.Subscriber;

public class UpdateCarinfoPresenter extends BasePresenter<AddCarinfoView> {
    public UpdateCarinfoPresenter(AddCarinfoView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void updatecarinfoData(Map<String,String> carinfomap) {
        String login = "true";
        String ajax = "json";
        addSubscription(apiStores.updatecarinfo(carinfomap), new Subscriber<AddcarinfoModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetAddCarinfoError(e);
            }

            @Override
            public void onNext(AddcarinfoModel addcarinfoModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetAddCarinfoSuccess(addcarinfoModel);
            }
        });

    }
}
