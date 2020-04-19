package com.example.pc.xumuapp.mvp_contrl.model;

import java.util.List;

public class ControlListModel {


    /**
     * result : true
     * data : [{"id":"GHC200191001","isNewRecord":false,"status":"0","updateBy":"system","updateDate":"2020-04-16 11:04","equipCode":"GHC200191001","pengCode":"123456","channelName":"水泵1","equipStatus":"02","autoType":"02"},{"id":"GHC200191005","isNewRecord":false,"status":"0","updateBy":"system","updateDate":"2020-04-16 10:05","equipCode":"GHC200191005","pengCode":"123456","channelName":"水泵5","equipStatus":"02,0000","autoType":"01"},{"id":"GHC200191002","isNewRecord":false,"status":"0","updateBy":"system","updateDate":"2020-04-16 10:03","equipCode":"GHC200191002","pengCode":"123456","channelName":"水泵2","equipStatus":"02,0000","autoType":"01"},{"id":"GHC200191003","isNewRecord":false,"status":"0","equipCode":"GHC200191003","pengCode":"123456","channelName":"水泵3","autoType":"01"},{"id":"GHC200191004","isNewRecord":false,"status":"0","equipCode":"GHC200191004","pengCode":"123456","channelName":"水泵4","autoType":"01"},{"id":"GHC200191006","isNewRecord":false,"status":"0","equipCode":"GHC200191006","pengCode":"123456","channelName":"水泵6","autoType":"01"},{"id":"GHC200191007","isNewRecord":false,"status":"0","equipCode":"GHC200191007","pengCode":"123456","channelName":"水泵7","autoType":"01"},{"id":"GHC200191008","isNewRecord":false,"status":"0","equipCode":"GHC200191008","pengCode":"123456","channelName":"水泵8","autoType":"01"},{"id":"GHC200191009","isNewRecord":false,"status":"0","equipCode":"GHC200191009","pengCode":"123456","channelName":"水泵9","autoType":"01"}]
     * message : 查询列表成功
     */

    private String result;
    private String message;
    private List<DataBean> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : GHC200191001
         * isNewRecord : false
         * status : 0
         * updateBy : system
         * updateDate : 2020-04-16 11:04
         * equipCode : GHC200191001
         * pengCode : 123456
         * channelName : 水泵1
         * equipStatus : 02
         * autoType : 02
         */

        private String id;
        private boolean isNewRecord;
        private String status;
        private String updateBy;
        private String updateDate;
        private String equipCode;
        private String pengCode;
        private String channelName;
        private String equipStatus;
        private String autoType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getEquipCode() {
            return equipCode;
        }

        public void setEquipCode(String equipCode) {
            this.equipCode = equipCode;
        }

        public String getPengCode() {
            return pengCode;
        }

        public void setPengCode(String pengCode) {
            this.pengCode = pengCode;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getEquipStatus() {
            return equipStatus;
        }

        public void setEquipStatus(String equipStatus) {
            this.equipStatus = equipStatus;
        }

        public String getAutoType() {
            return autoType;
        }

        public void setAutoType(String autoType) {
            this.autoType = autoType;
        }
    }
}
