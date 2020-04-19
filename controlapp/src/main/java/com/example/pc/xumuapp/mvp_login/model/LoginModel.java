package com.example.pc.xumuapp.mvp_login.model;

import java.io.Serializable;

/**
 * Created by wangyuanshi on 2018/3/20.
 */

public class LoginModel implements Serializable {

    /**
     * code : 200
     * message : SUCCESS
     * data : {"id":"admin","remarks":"客户方使用的系统管理员，用于一些常用的基础数据配置。",
     * "createDate":"2018-08-18 17:33","createBy":"system","updateDate":"2019-06-03 16:23",
     * "status":"0","updateBy":"admin","sign":"赵道刚","userType":"none","phone":"053166580869",
     * "pwdUpdateRecord":"[[\"503faab0fc8a267d1606b56ae12cc707186ddb9671b4108416119917\",\"2019-01-10 11:28:12\"]]",
     * "userName":"长清区农机局","userWeight":0,"loginCode":"changqing","email":"cqnjglzm@126.com",
     * "oldLastLoginIp":"120.224.50.72","lastLoginIp":"120.224.50.72","wxOpenid":"1","userCode":"admin",
     * "lastLoginDate":"2019-08-23 17:50:33","mobile":"15954111409","sex":"1","mgrType":"1",
     * "extend":{"extendS2":"","extendS5":"","extendS8":"","extendS4":"","extendS6":"","extendS1":"","extendS7":"","extendS3":""}
     */

    private int code;
    private String success;
    private String currentTime;
    private String data;
    private String errorMessage;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
