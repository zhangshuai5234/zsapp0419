package com.example.pc.xumuapp.yunwei.model;

import java.util.List;

public class EquipmentModel {


    /**
     * code : 200
     * currentTime : 2020-04-18 11:19:33
     * data : [{"availableStatus":"string","defaultEquipmentId":0,"description":"测试专用设备","equipmentModelId":"1228953536052699137","equipmentTypeId":"1228952718381522946","hostNumber":"ESN111","id":"1231847475835334658","isDefaultEquipment":"1","isOnline":"0","lineNumber":"1","name":"","number":"ESN111","picPath":"string","position":"string","sourcesDict":"租赁","workCenterId":"1198803964330643458","workCenterName":""},{"availableStatus":"string","defaultEquipmentId":0,"description":"畜牧专用网关","equipmentModelId":"1228953536052699137","equipmentTypeId":"1228952718381522946","hostNumber":"GATEWAY-0001","id":"1234801703348371457","isDefaultEquipment":"1","isOnline":"0","lineNumber":"2","name":"","number":"GATEWAY-0001","picPath":"string","position":"string","sourcesDict":"","workCenterId":"1198803964330643458","workCenterName":""},{"availableStatus":"string","defaultEquipmentId":0,"description":"畜牧专用网关2","equipmentModelId":"1228953536052699137","equipmentTypeId":"1228952718381522946","hostNumber":"GATEWAY-0002","id":"1235822694694432769","isDefaultEquipment":"1","isOnline":"0","lineNumber":"3","name":"","number":"GATEWAY-0002","picPath":"string","position":"string","sourcesDict":"","workCenterId":"1198803964330643458","workCenterName":""},{"availableStatus":"string","defaultEquipmentId":0,"description":"畜牧专用测试设备","equipmentModelId":"1228953536052699137","equipmentTypeId":"1228952718381522946","hostNumber":"XMK200191001","id":"1237612178578714625","isDefaultEquipment":"1","isOnline":"0","lineNumber":"4","name":"","number":"XMK200191001","picPath":"","position":"3楼实验室","sourcesDict":"","workCenterId":"1198803964330643458","workCenterName":""},{"availableStatus":"string","defaultEquipmentId":0,"description":"畜牧专用测试设备","equipmentModelId":"1228953536052699137","equipmentTypeId":"1228952718381522946","hostNumber":"XMK200191002","id":"1242322116261494786","isDefaultEquipment":"1","isOnline":"0","lineNumber":"5","name":"","number":"XMK200191002","picPath":"","position":"3楼实验室","sourcesDict":"","workCenterId":"1198803964330643458","workCenterName":""}]
     * errorMessage : success
     * success : true
     */

    private int code;
    private String currentTime;
    private String errorMessage;
    private boolean success;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * availableStatus : string
         * defaultEquipmentId : 0
         * description : 测试专用设备
         * equipmentModelId : 1228953536052699137
         * equipmentTypeId : 1228952718381522946
         * hostNumber : ESN111
         * id : 1231847475835334658
         * isDefaultEquipment : 1
         * isOnline : 0
         * lineNumber : 1
         * name :
         * number : ESN111
         * picPath : string
         * position : string
         * sourcesDict : 租赁
         * workCenterId : 1198803964330643458
         * workCenterName :
         */

        private String availableStatus;
        private int defaultEquipmentId;
        private String description;
        private String equipmentModelId;
        private String equipmentTypeId;
        private String hostNumber;
        private String id;
        private String isDefaultEquipment;
        private String isOnline;
        private String lineNumber;
        private String name;
        private String number;
        private String picPath;
        private String position;
        private String sourcesDict;
        private String workCenterId;
        private String workCenterName;

        public String getAvailableStatus() {
            return availableStatus;
        }

        public void setAvailableStatus(String availableStatus) {
            this.availableStatus = availableStatus;
        }

        public int getDefaultEquipmentId() {
            return defaultEquipmentId;
        }

        public void setDefaultEquipmentId(int defaultEquipmentId) {
            this.defaultEquipmentId = defaultEquipmentId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getEquipmentModelId() {
            return equipmentModelId;
        }

        public void setEquipmentModelId(String equipmentModelId) {
            this.equipmentModelId = equipmentModelId;
        }

        public String getEquipmentTypeId() {
            return equipmentTypeId;
        }

        public void setEquipmentTypeId(String equipmentTypeId) {
            this.equipmentTypeId = equipmentTypeId;
        }

        public String getHostNumber() {
            return hostNumber;
        }

        public void setHostNumber(String hostNumber) {
            this.hostNumber = hostNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsDefaultEquipment() {
            return isDefaultEquipment;
        }

        public void setIsDefaultEquipment(String isDefaultEquipment) {
            this.isDefaultEquipment = isDefaultEquipment;
        }

        public String getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(String isOnline) {
            this.isOnline = isOnline;
        }

        public String getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(String lineNumber) {
            this.lineNumber = lineNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getPicPath() {
            return picPath;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getSourcesDict() {
            return sourcesDict;
        }

        public void setSourcesDict(String sourcesDict) {
            this.sourcesDict = sourcesDict;
        }

        public String getWorkCenterId() {
            return workCenterId;
        }

        public void setWorkCenterId(String workCenterId) {
            this.workCenterId = workCenterId;
        }

        public String getWorkCenterName() {
            return workCenterName;
        }

        public void setWorkCenterName(String workCenterName) {
            this.workCenterName = workCenterName;
        }
    }
}
