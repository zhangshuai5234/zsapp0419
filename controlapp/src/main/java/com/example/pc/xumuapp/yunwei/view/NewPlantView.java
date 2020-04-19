package com.example.pc.xumuapp.yunwei.view;

import com.example.pc.xumuapp.yunwei.model.PlantModel;

public interface NewPlantView {

    void GetLoginSuccess(PlantModel.NewPlantBean plantModel);


    void GetLoginError(Throwable e);


}
