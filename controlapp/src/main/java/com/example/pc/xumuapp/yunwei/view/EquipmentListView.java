package com.example.pc.xumuapp.yunwei.view;

import com.example.pc.xumuapp.yunwei.model.EquipmentModel;
import com.example.pc.xumuapp.yunwei.model.GatherModel;

public interface EquipmentListView {

    void GetLoginSuccess(EquipmentModel gatherModel);


    void GetLoginError(Throwable e);


}
