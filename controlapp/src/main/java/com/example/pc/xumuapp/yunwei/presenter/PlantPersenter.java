package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.PlantModel;
import com.example.pc.xumuapp.yunwei.view.PlantView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;


public class PlantPersenter extends BasePresenter<PlantView> {


    public PlantPersenter(PlantView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void GetPlantList(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.getPlantList(headers,jsonbody), new Subscriber<PlantModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetLoginError(e);
            }

            @Override
            public void onNext(PlantModel plantModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetLoginSuccess(plantModel);
            }
        });

    }

}
