package com.example.pc.xumuapp.mvp_contrl.view;


import com.example.pc.xumuapp.mvp_contrl.model.ChangeControlModel;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public interface ChangeControlView {

    void ChangeSuccess(ChangeControlModel changeControlModel);
//    void GetLoginSuccess(String loginModel);
    void ChangeError(Throwable e);
}
