package com.example.pc.xumuapp.yunwei.view;

import com.example.pc.xumuapp.yunwei.model.EquipmentstatusModel;
import com.example.pc.xumuapp.yunwei.model.GatherModel;
import com.example.pc.xumuapp.yunwei.model.OrderModel;
import com.example.pc.xumuapp.yunwei.model.ParameterModel;

public interface OrderView {

    void OrderSuccess(OrderModel gatherModel);

    void OrderError(Throwable e);

    void GetEquipmentStatusSuccess(EquipmentstatusModel equipmentstatusModel);

    void GetEquipmentStatusError(Throwable e);

    void GetParameterSuccess(ParameterModel parameterModel);

    void GetParameterError(Throwable e);
}
