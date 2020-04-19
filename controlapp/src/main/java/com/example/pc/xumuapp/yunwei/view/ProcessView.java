package com.example.pc.xumuapp.yunwei.view;


import com.example.pc.xumuapp.yunwei.model.ProcessModel;

public interface ProcessView {

    void GetLoginSuccess(ProcessModel processModel);


    void GetLoginError(Throwable e);


}
