package com.example.pc.xumuapp.mvp_login.view;


import com.example.pc.xumuapp.mvp_login.model.LoginModel;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public interface LoginView {

    void GetLoginSuccess(LoginModel loginModel);
//    void GetLoginSuccess(String loginModel);
    void GetLoginError(Throwable e);
}
