package com.example.pc.xumuapp.yunwei.view;

import com.example.pc.xumuapp.yunwei.model.PlantModel;

/**
 * Created by wangyuanshi on 2018/3/21.
 */

public interface PlantView {

    void GetLoginSuccess(PlantModel plantModel);


    void GetLoginError(Throwable e);


}
