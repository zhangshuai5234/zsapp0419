package com.example.pc.xumuapp.yunwei.model;

public class GongdanModel {
    /**
     * {
     *     "success": true,
     *     "code": 200,
     *     "errorMessage": "success",
     *     "currentTime": "2019-11-20 10:25:26",
     *     "data": {
     *         "records": [],
     *         "total": 0,
     *         "size": 10,
     *         "current": 1,
     *         "orders": [
     *             {
     *                 "column": "mt.crt_time",
     *                 "asc": false
     *             }
     *         ],
     *         "searchCount": true,
     *         "pages": 0
     *     }
     * }
     */
    private String success;
    private String code;
    private String currentTime;
    private String errorMessage;
    private gdListModel data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public gdListModel getData() {
        return data;
    }

    public void setData(gdListModel data) {
        this.data = data;
    }
}
