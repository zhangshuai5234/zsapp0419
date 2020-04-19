package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.ProcessModel;
import com.example.pc.xumuapp.yunwei.view.ProcessView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;

public class ProcessPersenter extends BasePresenter<ProcessView> {


    public ProcessPersenter(ProcessView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void GetProcessList(RequestBody jsonbody, HashMap<String,String> headers) {
        String login = "application/json";
        addSubscription(apiStores.getProcessList(headers,jsonbody), new Subscriber<ProcessModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetLoginError(e);
            }

            @Override
            public void onNext(ProcessModel processModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetLoginSuccess(processModel);
            }
        });

    }
}
