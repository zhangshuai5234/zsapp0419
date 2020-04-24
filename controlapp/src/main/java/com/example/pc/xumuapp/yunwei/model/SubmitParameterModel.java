package com.example.pc.xumuapp.yunwei.model;

public class SubmitParameterModel {


    /**
     * code : 200
     * currentTime : 2020-04-24 10:35:46
     * data : 1242322120418050050
     * errorMessage : success
     * success : true
     */

    private String code;
    private String currentTime;
    private String data;
    private String errorMessage;
    private String success;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
