package com.example.pc.xumuapp.yunwei.model;

import java.util.List;

public class gdListModel {

    /**
     * records : [{"lineNumber":1,"id":"1197071931208351745","workOrderId":"1197071641558106113","workOrderNumber":"WO-00001","workOrderDescription":"种地","number":"TK-00001","description":"种地1个月","taskTypeDict":"plant","statusDict":"saved","productId":"1197059616916357122","productNumber":"TL-PN-2019-0001","productName":"WWZ-01","productDescription":"五味子1号","materialId":null,"materialNumber":null,"materialName":null,"materialDescription":null,"quantity":200,"unitDict":"pcs","outstandingQuantity":200,"completeProgress":0,"outstandingProgress":100,"generateTime":"2019-11-20","issuedTime":null,"completeTime":null,"planBeginTime":"2019-11-20","planEndTime":"2019-11-23","beginTime":null,"endTime":null}]
     * total : 1
     * size : 10
     * current : 1
     * orders : [{"column":"mt.crt_time","asc":false}]
     * searchCount : true
     * pages : 1
     */

    private int total;
    private int size;
    private int current;
    private boolean searchCount;
    private int pages;
    private List<RecordsBean> records;
    private List<OrdersBean> orders;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isSearchCount() {
        return searchCount;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public static class RecordsBean {
        /**
         * lineNumber : 1
         * id : 1197071931208351745
         * workOrderId : 1197071641558106113
         * workOrderNumber : WO-00001
         * workOrderDescription : 种地
         * number : TK-00001
         * description : 种地1个月
         * taskTypeDict : plant
         * statusDict : saved
         * productId : 1197059616916357122
         * productNumber : TL-PN-2019-0001
         * productName : WWZ-01
         * productDescription : 五味子1号
         * materialId : null
         * materialNumber : null
         * materialName : null
         * materialDescription : null
         * quantity : 200.0
         * unitDict : pcs
         * outstandingQuantity : 200.0
         * completeProgress : 0.0
         * outstandingProgress : 100.0
         * generateTime : 2019-11-20
         * issuedTime : null
         * completeTime : null
         * planBeginTime : 2019-11-20
         * planEndTime : 2019-11-23
         * beginTime : null
         * endTime : null
         */

        private int lineNumber;
        private String id;
        private String workOrderId;
        private String workOrderNumber;
        private String workOrderDescription;
        private String number;
        private String description;
        private String taskTypeDict;
        private String statusDict;
        private String productId;
        private String productNumber;
        private String productName;
        private String productDescription;
        private String materialId;
        private String materialNumber;
        private String materialName;
        private String materialDescription;
        private double quantity;
        private String unitDict;
        private double outstandingQuantity;
        private double completeProgress;
        private double outstandingProgress;
        private String generateTime;
        private String issuedTime;
        private String completeTime;
        private String planBeginTime;
        private String planEndTime;
        private String beginTime;
        private String endTime;

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

        public String getWorkOrderId() {
            return workOrderId;
        }

        public void setWorkOrderId(String workOrderId) {
            this.workOrderId = workOrderId;
        }

        public String getWorkOrderNumber() {
            return workOrderNumber;
        }

        public void setWorkOrderNumber(String workOrderNumber) {
            this.workOrderNumber = workOrderNumber;
        }

        public String getWorkOrderDescription() {
            return workOrderDescription;
        }

        public void setWorkOrderDescription(String workOrderDescription) {
            this.workOrderDescription = workOrderDescription;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTaskTypeDict() {
            return taskTypeDict;
        }

        public void setTaskTypeDict(String taskTypeDict) {
            this.taskTypeDict = taskTypeDict;
        }

        public String getStatusDict() {
            return statusDict;
        }

        public void setStatusDict(String statusDict) {
            this.statusDict = statusDict;
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

        public String getMaterialId() {
            return materialId;
        }

        public void setMaterialId(String materialId) {
            this.materialId = materialId;
        }

        public String getMaterialNumber() {
            return materialNumber;
        }

        public void setMaterialNumber(String materialNumber) {
            this.materialNumber = materialNumber;
        }

        public String getMaterialName() {
            return materialName;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public String getMaterialDescription() {
            return materialDescription;
        }

        public void setMaterialDescription(String materialDescription) {
            this.materialDescription = materialDescription;
        }

        public String getIssuedTime() {
            return issuedTime;
        }

        public void setIssuedTime(String issuedTime) {
            this.issuedTime = issuedTime;
        }

        public String getCompleteTime() {
            return completeTime;
        }

        public void setCompleteTime(String completeTime) {
            this.completeTime = completeTime;
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

        public double getOutstandingQuantity() {
            return outstandingQuantity;
        }

        public void setOutstandingQuantity(double outstandingQuantity) {
            this.outstandingQuantity = outstandingQuantity;
        }

        public double getCompleteProgress() {
            return completeProgress;
        }

        public void setCompleteProgress(double completeProgress) {
            this.completeProgress = completeProgress;
        }

        public double getOutstandingProgress() {
            return outstandingProgress;
        }

        public void setOutstandingProgress(double outstandingProgress) {
            this.outstandingProgress = outstandingProgress;
        }

        public String getGenerateTime() {
            return generateTime;
        }

        public void setGenerateTime(String generateTime) {
            this.generateTime = generateTime;
        }


        public String getPlanBeginTime() {
            return planBeginTime;
        }

        public void setPlanBeginTime(String planBeginTime) {
            this.planBeginTime = planBeginTime;
        }

        public String getPlanEndTime() {
            return planEndTime;
        }

        public void setPlanEndTime(String planEndTime) {
            this.planEndTime = planEndTime;
        }


    }

    public static class OrdersBean {
        /**
         * column : mt.crt_time
         * asc : false
         */

        private String column;
        private boolean asc;

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public boolean isAsc() {
            return asc;
        }

        public void setAsc(boolean asc) {
            this.asc = asc;
        }
    }
}
