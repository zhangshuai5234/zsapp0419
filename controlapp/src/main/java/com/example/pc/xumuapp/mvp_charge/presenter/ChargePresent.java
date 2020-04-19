package com.example.pc.xumuapp.mvp_charge.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.mvp_charge.model.ChargeMedel;
import com.example.pc.xumuapp.mvp_charge.view.ChargeListView;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;

import rx.Subscriber;


    public class ChargePresent extends BasePresenter<ChargeListView> {


        public ChargePresent(ChargeListView view) {
            attachView(view);
            apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
        }

        public void loadChargeData(String usercode) {
            String login = "true";
            String ajax = "json";
            addSubscription(apiStores.cahrgelist(), new Subscriber<ChargeMedel>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    LogUtil.logConsole("请求失败");
                    mvpView.GetChargeError(e);
                }

                @Override
                public void onNext(ChargeMedel chargeMedel) {
                    LogUtil.logConsole("请求成功");
                    mvpView.GetChargeSuccess(chargeMedel);
                }
            });

        }
    }
