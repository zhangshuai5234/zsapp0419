package com.example.pc.xumuapp.mvp_charge.model;

import java.util.List;

public class ChargeMedel {
    String result;

    private List<UserChargeModel> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<UserChargeModel> getData() {
        return data;
    }

    public void setData(List<UserChargeModel> data) {
        this.data = data;
    }
}
