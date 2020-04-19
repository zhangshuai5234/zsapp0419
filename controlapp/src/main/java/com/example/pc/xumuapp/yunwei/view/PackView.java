package com.example.pc.xumuapp.yunwei.view;


import com.example.pc.xumuapp.yunwei.model.PackModel;

public interface PackView {

    void GetLoginSuccess(PackModel packModel);


    void GetLoginError(Throwable e);


}
