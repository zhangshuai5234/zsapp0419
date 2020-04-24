package com.example.pc.xumuapp.yunwei.view;

import com.example.pc.xumuapp.yunwei.model.EquipmentstatusModel;
import com.example.pc.xumuapp.yunwei.model.OrderModel;
import com.example.pc.xumuapp.yunwei.model.ParameterModel;
import com.example.pc.xumuapp.yunwei.model.SubmitParameterModel;

public interface ParameterView {


    void GetParameterSuccess(ParameterModel parameterModel);

    void GetParameterError(Throwable e);

    void PostParameterSuccess(SubmitParameterModel parameterModel);
    void PostParameterError(Throwable e);
}
