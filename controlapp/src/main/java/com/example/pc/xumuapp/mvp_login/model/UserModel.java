package com.example.pc.xumuapp.mvp_login.model;

import java.io.Serializable;

/**
 * Created by wangyuanshi on 2018/3/22.
 */

public class UserModel implements Serializable {


    /**
     "id":"15040070175_qk8b",
     "isNewRecord":false,
     "createBy":"system",
     "updateDate":"2019-07-22 14:39",
     "remarks":"",
     "createDate":"2019-03-05 10:16",
     "status":"0",
     "updateBy":"system",
     "mgrType":"0",
     "wxOpenid":"0",
     "userName":"设计院",
     "lastLoginIp":"175.167.154.31",
     "userWeight":0,
     "mobileImei":"hongtai",
     "userType":"employee",
     "oldLastLoginIp":"175.167.154.31",
     "refObj":Object{...},
     "email":"",
     "refCode":"15040070175_qk8b",
     "loginCode":"15040070175",
     "extend":Object{...},
     "refName":"设计院",
     "mobile":"",
     "userCode":"15040070175_qk8b",
     "phone":"",
     "sign":"5",
     "lastLoginDate":"2019-04-22 10:28:49",
     "corpCode_":"0",
     "corpName_":"JeeSite",
     "avatarUrl":"/ctxPath/static/images/user1.jpg",
     "oldLoginDate":"2019-04-22 10:28:49"
     */

    private String id;
    private String mobileImei;
    private String avatarUrl;
    private String sign;
    private String userType;
    private String phone;
    private String loginCode;
    private String wxOpenid;
    private String userCode;
    private String mobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileImei() {
        return mobileImei;
    }

    public void setMobileImei(String mobileImei) {
        this.mobileImei = mobileImei;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
