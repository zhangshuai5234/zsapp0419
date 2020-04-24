package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.ParameterModel;
import com.example.pc.xumuapp.yunwei.model.SubmitParameterModel;
import com.example.pc.xumuapp.yunwei.view.ParameterView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;


public class SubmitParameterPersenter extends BasePresenter<ParameterView> {


    public SubmitParameterPersenter(ParameterView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void PostParameter(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.postParameter(headers,jsonbody), new Subscriber<SubmitParameterModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.PostParameterError(e);
            }

            @Override
            public void onNext(SubmitParameterModel plantModel) {
                LogUtil.logConsole("请求成功");
                mvpView.PostParameterSuccess(plantModel);
            }
        });

    }

}
