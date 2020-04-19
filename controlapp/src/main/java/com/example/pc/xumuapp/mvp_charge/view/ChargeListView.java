package com.example.pc.xumuapp.mvp_charge.view;


import com.example.pc.xumuapp.mvp_charge.model.ChargeMedel;

public interface ChargeListView {

        void GetChargeSuccess(ChargeMedel chargeMedel);
        //    void GetLoginSuccess(String loginModel);
        void GetChargeError(Throwable e);
    }
