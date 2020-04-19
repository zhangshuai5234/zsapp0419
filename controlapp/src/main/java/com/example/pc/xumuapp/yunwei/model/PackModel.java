package com.example.pc.xumuapp.yunwei.model;

import java.util.List;

public class PackModel {


    /**
     * success : true
     * code : 200
     * errorMessage : success
     * currentTime : 2019-12-09 16:29:40
     * data : [{"lineNumber":1,"id":"1198920274007977985","taskId":"1198805786202083329","taskNumber":"TK-0001","taskDescription":"种植五味子","taskQuantity":20,"productionBaseId":"1198802998889943041","productionBaseNumber":"PB-001","productionBaseName":"基地1","productionBaseDescription":"第一个生产基地","productionCellId":"1198803964330643458","productionCellNumber":"PC-001","productionCellDescription":"基地01的第一个地块","managerId":"1198795020551983105","managerNumber":"15840500337","managerName":"姚峥","managerDescription":"","productId":"1198804621208981505","productNumber":"P-00001","productName":"五味子001","productDescription":"五味子","quantity":2,"unitDict":"pcs","percent":10,"beginTime":"2019-10-24","endTime":"2019-10-24","picPath":"","remark":""}]
     */

    private boolean success;
    private int code;
    private String errorMessage;
    private String currentTime;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * lineNumber : 1
         * id : 1198920274007977985
         * taskId : 1198805786202083329
         * taskNumber : TK-0001
         * taskDescription : 种植五味子
         * taskQuantity : 20.0
         * productionBaseId : 1198802998889943041
         * productionBaseNumber : PB-001
         * productionBaseName : 基地1
         * productionBaseDescription : 第一个生产基地
         * productionCellId : 1198803964330643458
         * productionCellNumber : PC-001
         * productionCellDescription : 基地01的第一个地块
         * managerId : 1198795020551983105
         * managerNumber : 15840500337
         * managerName : 姚峥
         * managerDescription :
         * productId : 1198804621208981505
         * productNumber : P-00001
         * productName : 五味子001
         * productDescription : 五味子
         * quantity : 2.0
         * unitDict : pcs
         * percent : 10.0
         * beginTime : 2019-10-24
         * endTime : 2019-10-24
         * picPath :
         * remark :
         */

        private int lineNumber;
        private String id;
        private String taskId;
        private String taskNumber;
        private String taskDescription;
        private double taskQuantity;
        private String productionBaseId;
        private String productionBaseNumber;
        private String productionBaseName;
        private String productionBaseDescription;
        private String productionCellId;
        private String productionCellNumber;
        private String productionCellDescription;
        private String managerId;
        private String managerNumber;
        private String managerName;
        private String managerDescription;
        private String productId;
        private String productNumber;
        private String productName;
        private String productDescription;
        private double quantity;
        private String unitDict;
        private double percent;
        private String beginTime;
        private String endTime;
        private String picPath;
        private String remark;

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getTaskNumber() {
            return taskNumber;
        }

        public void setTaskNumber(String taskNumber) {
            this.taskNumber = taskNumber;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public void setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
        }

        public double getTaskQuantity() {
            return taskQuantity;
        }

        public void setTaskQuantity(double taskQuantity) {
            this.taskQuantity = taskQuantity;
        }

        public String getProductionBaseId() {
            return productionBaseId;
        }

        public void setProductionBaseId(String productionBaseId) {
            this.productionBaseId = productionBaseId;
        }

        public String getProductionBaseNumber() {
            return productionBaseNumber;
        }

        public void setProductionBaseNumber(String productionBaseNumber) {
            this.productionBaseNumber = productionBaseNumber;
        }

        public String getProductionBaseName() {
            return productionBaseName;
        }

        public void setProductionBaseName(String productionBaseName) {
            this.productionBaseName = productionBaseName;
        }

        public String getProductionBaseDescription() {
            return productionBaseDescription;
        }

        public void setProductionBaseDescription(String productionBaseDescription) {
            this.productionBaseDescription = productionBaseDescription;
        }

        public String getProductionCellId() {
            return productionCellId;
        }

        public void setProductionCellId(String productionCellId) {
            this.productionCellId = productionCellId;
        }

        public String getProductionCellNumber() {
            return productionCellNumber;
        }

        public void setProductionCellNumber(String productionCellNumber) {
            this.productionCellNumber = productionCellNumber;
        }

        public String getProductionCellDescription() {
            return productionCellDescription;
        }

        public void setProductionCellDescription(String productionCellDescription) {
            this.productionCellDescription = productionCellDescription;
        }

        public String getManagerId() {
            return managerId;
        }

        public void setManagerId(String managerId) {
            this.managerId = managerId;
        }

        public String getManagerNumber() {
            return managerNumber;
        }

        public void setManagerNumber(String managerNumber) {
            this.managerNumber = managerNumber;
        }

        public String getManagerName() {
            return managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }

        public String getManagerDescription() {
            return managerDescription;
        }

        public void setManagerDescription(String managerDescription) {
            this.managerDescription = managerDescription;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductNumber() {
            return productNumber;
        }

        public void setProductNumber(String productNumber) {
            this.productNumber = productNumber;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public String getUnitDict() {
            return unitDict;
        }

        public void setUnitDict(String unitDict) {
            this.unitDict = unitDict;
        }

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getPicPath() {
            return picPath;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
