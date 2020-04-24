package com.example.pc.xumuapp.yunwei.model;

public class EquipmentstatusModel {

    /**
     * code : 0
     * currentTime :
     * data : {"ammoniaContent":0,"carbonDioxideContent":0,"equipmentId":0,"gasFlow":0,"humidity":0,"hydrogenSulfideContent":0,"id":0,"isAuto":"","isOnline":"","lineNumber":0,"name":"","number":"","recordTime":"","switch1":"","switch2":"","switch3":"","switch4":"","switch5":"","switch6":"","temperature":0,"uuivertor1":0,"uuivertor2":0}
     * errorMessage :
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
         * ammoniaContent : 0
         * carbonDioxideContent : 0
         * equipmentId : 0
         * gasFlow : 0
         * humidity : 0
         * hydrogenSulfideContent : 0
         * id : 0
         * isAuto :
         * isOnline :
         * lineNumber : 0
         * name :
         * number :
         * recordTime :
         * switch1 :
         * switch2 :
         * switch3 :
         * switch4 :
         * switch5 :
         * switch6 :
         * temperature : 0
         * uuivertor1 : 0
         * uuivertor2 : 0
         */

        private Double ammoniaContent;
        private Double carbonDioxideContent;
        private String equipmentId;
        private Double gasFlow;
        private Double humidity;
        private Double hydrogenSulfideContent;
        private String id;
        private String isAuto;
        private String isOnline;
        private int lineNumber;
        private String name;
        private String number;
        private String recordTime;
        private String switch1;
        private String switch2;
        private String switch3;
        private String switch4;
        private String switch5;
        private String switch6;
        private Double temperature;
        private int uuivertor1;
        private int uuivertor2;

        public Double getAmmoniaContent() {
            return ammoniaContent;
        }

        public void setAmmoniaContent(Double ammoniaContent) {
            this.ammoniaContent = ammoniaContent;
        }

        public Double getCarbonDioxideContent() {
            return carbonDioxideContent;
        }

        public void setCarbonDioxideContent(Double carbonDioxideContent) {
            this.carbonDioxideContent = carbonDioxideContent;
        }

        public String getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(String equipmentId) {
            this.equipmentId = equipmentId;
        }

        public Double getGasFlow() {
            return gasFlow;
        }

        public void setGasFlow(Double gasFlow) {
            this.gasFlow = gasFlow;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public Double getHydrogenSulfideContent() {
            return hydrogenSulfideContent;
        }

        public void setHydrogenSulfideContent(Double hydrogenSulfideContent) {
            this.hydrogenSulfideContent = hydrogenSulfideContent;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsAuto() {
            return isAuto;
        }

        public void setIsAuto(String isAuto) {
            this.isAuto = isAuto;
        }

        public String getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(String isOnline) {
            this.isOnline = isOnline;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
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

        public String getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(String recordTime) {
            this.recordTime = recordTime;
        }

        public String getSwitch1() {
            return switch1;
        }

        public void setSwitch1(String switch1) {
            this.switch1 = switch1;
        }

        public String getSwitch2() {
            return switch2;
        }

        public void setSwitch2(String switch2) {
            this.switch2 = switch2;
        }

        public String getSwitch3() {
            return switch3;
        }

        public void setSwitch3(String switch3) {
            this.switch3 = switch3;
        }

        public String getSwitch4() {
            return switch4;
        }

        public void setSwitch4(String switch4) {
            this.switch4 = switch4;
        }

        public String getSwitch5() {
            return switch5;
        }

        public void setSwitch5(String switch5) {
            this.switch5 = switch5;
        }

        public String getSwitch6() {
            return switch6;
        }

        public void setSwitch6(String switch6) {
            this.switch6 = switch6;
        }

        public Double getTemperature() {
            return temperature;
        }

        public void setTemperature(Double temperature) {
            this.temperature = temperature;
        }

        public int getUuivertor1() {
            return uuivertor1;
        }

        public void setUuivertor1(int uuivertor1) {
            this.uuivertor1 = uuivertor1;
        }

        public int getUuivertor2() {
            return uuivertor2;
        }

        public void setUuivertor2(int uuivertor2) {
            this.uuivertor2 = uuivertor2;
        }
    }
}
