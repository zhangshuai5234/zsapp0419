package com.example.pc.xumuapp.mvp_login.presenter;




import okhttp3.RequestBody;
import rx.Subscriber;

import com.example.pc.xumuapp.base.BasePresenter;
import com.example.pc.xumuapp.mvp_login.model.LoginModel;
import com.example.pc.xumuapp.mvp_login.view.LoginView;
import com.example.pc.xumuapp.retrofit.ApiClient;
import com.example.pc.xumuapp.retrofit.ApiService;
import com.example.pc.xumuapp.retrofit.HostType;
import com.example.pc.xumuapp.utils.LogUtil;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public class LoginPresenter extends BasePresenter<LoginView> {


    public LoginPresenter(LoginView view) {
        attachView(view);
        apiStores = ApiClient.retrofit(HostType.INTERNAL).create(ApiService.class);
    }

    public void loadLoginData(RequestBody loginjson) {
        String login = "application/json";
        String ajax = "json";
        addSubscription(apiStores.login(login,loginjson), new Subscriber<LoginModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.logConsole("请求失败");
                mvpView.GetLoginError(e);
            }

            @Override
            public void onNext(LoginModel loginModel) {
                LogUtil.logConsole("请求成功");
                mvpView.GetLoginSuccess(loginModel);
            }
        });

    }
}
