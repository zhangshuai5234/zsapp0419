package com.example.pc.xumuapp.mvp_contrl.view;


import com.example.pc.xumuapp.mvp_contrl.model.ControlListModel;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public interface ControlView {

    void GetListSuccess(ControlListModel controlListModel);
//    void GetLoginSuccess(String loginModel);
    void GetListError(Throwable e);
}
