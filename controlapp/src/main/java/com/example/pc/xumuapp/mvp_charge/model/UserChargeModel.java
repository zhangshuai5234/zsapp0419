package com.example.pc.xumuapp.mvp_charge.model;

public class UserChargeModel {
    /**
     *     createTime 年费账单成效日期
     *     carId
     *     owner
     *     ownerPhone
     *     location
     *     cooperation
     *     installUser
     */
    String carId;
    String owner;
    String ownerPhone;
    String location;
    String cooperation;
    String installUser;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    public String getInstallUser() {
        return installUser;
    }

    public void setInstallUser(String installUser) {
        this.installUser = installUser;
    }
}
