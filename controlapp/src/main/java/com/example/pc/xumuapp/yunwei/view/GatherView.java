package com.example.pc.xumuapp.yunwei.view;

import com.example.pc.xumuapp.yunwei.model.GatherModel;

public interface GatherView {

    void GetLoginSuccess(GatherModel gatherModel);


    void GetLoginError(Throwable e);


}
