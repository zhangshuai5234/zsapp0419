package com.example.pc.xumuapp.yunwei.presenter;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;
import com.example.pc.xumuapp.yunwei.model.PlantModel;
import com.example.pc.xumuapp.yunwei.view.NewPlantView;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Subscriber;

public class NewPlantPersenter extends BasePresenter<NewPlantView> {


    public NewPlantPersenter(NewPlantView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void PostNewPlant(RequestBody jsonbody, HashMap<String,String> headers,String typestr) {
        String login = "application/json";
        switch (typestr){
            case "0":
                addSubscription(apiStores.newPlant(headers,jsonbody), new Subscriber<PlantModel.NewPlantBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.logConsole("请求失败");
                        mvpView.GetLoginError(e);
                    }

                    @Override
                    public void onNext(PlantModel.NewPlantBean newPlantBean) {
                        LogUtil.logConsole("请求成功");
                        mvpView.GetLoginSuccess(newPlantBean);
                    }
                });
                break;
            case "1":
                addSubscription(apiStores.newGather(headers,jsonbody), new Subscriber<PlantModel.NewPlantBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.logConsole("请求失败");
                        mvpView.GetLoginError(e);
                    }

                    @Override
                    public void onNext(PlantModel.NewPlantBean newPlantBean) {
                        LogUtil.logConsole("请求成功");
                        mvpView.GetLoginSuccess(newPlantBean);
                    }
                });
                break;
            case "2":
                addSubscription(apiStores.newProcess(headers,jsonbody), new Subscriber<PlantModel.NewPlantBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.logConsole("请求失败");
                        mvpView.GetLoginError(e);
                    }

                    @Override
                    public void onNext(PlantModel.NewPlantBean newPlantBean) {
                        LogUtil.logConsole("请求成功");
                        mvpView.GetLoginSuccess(newPlantBean);
                    }
                });
                break;
            case "3":
                addSubscription(apiStores.newPack(headers,jsonbody), new Subscriber<PlantModel.NewPlantBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.logConsole("请求失败");
                        mvpView.GetLoginError(e);
                    }

                    @Override
                    public void onNext(PlantModel.NewPlantBean newPlantBean) {
                        LogUtil.logConsole("请求成功");
                        mvpView.GetLoginSuccess(newPlantBean);
                    }
                });
                break;
        }



    }
}
