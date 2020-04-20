package com.example.pc.xumuapp.yunwei.model;

public class OrderModel {

    /**
     * code : 200
     * currentTime : 2020-04-20 04:46:42
     * data : {"equipmentId":"1242322116261494786","id":"1252156727821430786","isSendOk":"1","sendTime":"2020-04-20 04:46:42","topic":"switch","tunnel":1,"tunnelValue":"1"}
     * errorMessage : success
     * success : true
     */

    private int code;
    private String currentTime;
    private DataBean data;
    private String errorMessage;
    private boolean success;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * equipmentId : 1242322116261494786
         * id : 1252156727821430786
         * isSendOk : 1
         * sendTime : 2020-04-20 04:46:42
         * topic : switch
         * tunnel : 1
         * tunnelValue : 1
         */

        private String equipmentId;
        private String id;
        private String isSendOk;
        private String sendTime;
        private String topic;
        private int tunnel;
        private String tunnelValue;

        public String getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(String equipmentId) {
            this.equipmentId = equipmentId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsSendOk() {
            return isSendOk;
        }

        public void setIsSendOk(String isSendOk) {
            this.isSendOk = isSendOk;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public int getTunnel() {
            return tunnel;
        }

        public void setTunnel(int tunnel) {
            this.tunnel = tunnel;
        }

        public String getTunnelValue() {
            return tunnelValue;
        }

        public void setTunnelValue(String tunnelValue) {
            this.tunnelValue = tunnelValue;
        }
    }
}
