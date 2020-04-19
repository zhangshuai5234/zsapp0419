package com.example.pc.xumuapp.mvp_contrl.presenter;


import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.mvp_contrl.model.ControlListModel;
import com.example.pc.xumuapp.mvp_contrl.view.ControlView;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;

import rx.Subscriber;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public class ControlPresenter extends BasePresenter<ControlView> {


    public ControlPresenter(ControlView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void loadControlListData(String pengcode) {

        addSubscription(apiStores.getControlList(pengcode), new Subscriber<ControlListModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetListError(e);
            }

            @Override
            public void onNext(ControlListModel controlListModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetListSuccess(controlListModel);
            }
        });

    }
}
