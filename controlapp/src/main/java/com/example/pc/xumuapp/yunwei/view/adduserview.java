package com.example.pc.xumuapp.yunwei.view;


import com.example.pc.xumuapp.yunwei.model.AdduserModel;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public interface adduserview {

    void GetLoginSuccess(AdduserModel adduserModel);

    void GetLoginError(Throwable e);
}
