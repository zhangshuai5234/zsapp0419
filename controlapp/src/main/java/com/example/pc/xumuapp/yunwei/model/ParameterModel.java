package com.example.pc.xumuapp.yunwei.model;

public class ParameterModel {

    /**
     * code : 200
     * currentTime : 2020-04-23 04:22:10
     * data : {"ammoniaContentLowerLimit":"0.000000","ammoniaContentUpperLimit":"5000.000000","carbonDioxideContentLowerLimit":"0.000000","carbonDioxideContentUpperLimit":"1000.000000","draughtFanQuantity":"6","dustContentLowerLimit":"0.000000","dustContentUpperLimit":"20.000000","equipmentDescription":"","equipmentId":"1237612178578714625","equipmentNumber":"","frequencyLowerLimit":"0.000000","frequencyUpperLimit":"400.000000","gasFlowLowerLimit":"0.000000","gasFlowUpperLimit":"100.000000","humidityLowerLimit":"300.000000","humidityUpperLimit":"700.000000","hydrogenSulfideContentLowerLimit":"0.000000","hydrogenSulfideContentUpperLimit":"5000.000000","iccId":"89860434151980183045","id":"1237612179384020993","lineNumber":0,"name":"","temperatureLowerLimit":"200.000000","temperatureUpperLimit":"320.000000","uuivertorQuantity":"6","version":"1.0.00"}
     * errorMessage : success
     * success : true
     */

    private String code;
    private String currentTime;
    private DataBean data;
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

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * ammoniaContentLowerLimit : 0.000000
         * ammoniaContentUpperLimit : 5000.000000
         * carbonDioxideContentLowerLimit : 0.000000
         * carbonDioxideContentUpperLimit : 1000.000000
         * draughtFanQuantity : 6
         * dustContentLowerLimit : 0.000000
         * dustContentUpperLimit : 20.000000
         * equipmentDescription :
         * equipmentId : 1237612178578714625
         * equipmentNumber :
         * frequencyLowerLimit : 0.000000
         * frequencyUpperLimit : 400.000000
         * gasFlowLowerLimit : 0.000000
         * gasFlowUpperLimit : 100.000000
         * humidityLowerLimit : 300.000000
         * humidityUpperLimit : 700.000000
         * hydrogenSulfideContentLowerLimit : 0.000000
         * hydrogenSulfideContentUpperLimit : 5000.000000
         * iccId : 89860434151980183045
         * id : 1237612179384020993
         * lineNumber : 0
         * name :
         * temperatureLowerLimit : 200.000000
         * temperatureUpperLimit : 320.000000
         * uuivertorQuantity : 6
         * version : 1.0.00
         */

        private String ammoniaContentLowerLimit;
        private String ammoniaContentUpperLimit;
        private String carbonDioxideContentLowerLimit;
        private String carbonDioxideContentUpperLimit;
        private String draughtFanQuantity;
        private String dustContentLowerLimit;
        private String dustContentUpperLimit;
        private String equipmentDescription;
        private String equipmentId;
        private String equipmentNumber;
        private String frequencyLowerLimit;
        private String frequencyUpperLimit;
        private String gasFlowLowerLimit;
        private String gasFlowUpperLimit;
        private String humidityLowerLimit;
        private String humidityUpperLimit;
        private String hydrogenSulfideContentLowerLimit;
        private String hydrogenSulfideContentUpperLimit;
        private String iccId;
        private String id;
        private int lineNumber;
        private String name;
        private String temperatureLowerLimit;
        private String temperatureUpperLimit;
        private String uuivertorQuantity;
        private String version;

        public String getAmmoniaContentLowerLimit() {
            return ammoniaContentLowerLimit;
        }

        public void setAmmoniaContentLowerLimit(String ammoniaContentLowerLimit) {
            this.ammoniaContentLowerLimit = ammoniaContentLowerLimit;
        }

        public String getAmmoniaContentUpperLimit() {
            return ammoniaContentUpperLimit;
        }

        public void setAmmoniaContentUpperLimit(String ammoniaContentUpperLimit) {
            this.ammoniaContentUpperLimit = ammoniaContentUpperLimit;
        }

        public String getCarbonDioxideContentLowerLimit() {
            return carbonDioxideContentLowerLimit;
        }

        public void setCarbonDioxideContentLowerLimit(String carbonDioxideContentLowerLimit) {
            this.carbonDioxideContentLowerLimit = carbonDioxideContentLowerLimit;
        }

        public String getCarbonDioxideContentUpperLimit() {
            return carbonDioxideContentUpperLimit;
        }

        public void setCarbonDioxideContentUpperLimit(String carbonDioxideContentUpperLimit) {
            this.carbonDioxideContentUpperLimit = carbonDioxideContentUpperLimit;
        }

        public String getDraughtFanQuantity() {
            return draughtFanQuantity;
        }

        public void setDraughtFanQuantity(String draughtFanQuantity) {
            this.draughtFanQuantity = draughtFanQuantity;
        }

        public String getDustContentLowerLimit() {
            return dustContentLowerLimit;
        }

        public void setDustContentLowerLimit(String dustContentLowerLimit) {
            this.dustContentLowerLimit = dustContentLowerLimit;
        }

        public String getDustContentUpperLimit() {
            return dustContentUpperLimit;
        }

        public void setDustContentUpperLimit(String dustContentUpperLimit) {
            this.dustContentUpperLimit = dustContentUpperLimit;
        }

        public String getEquipmentDescription() {
            return equipmentDescription;
        }

        public void setEquipmentDescription(String equipmentDescription) {
            this.equipmentDescription = equipmentDescription;
        }

        public String getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(String equipmentId) {
            this.equipmentId = equipmentId;
        }

        public String getEquipmentNumber() {
            return equipmentNumber;
        }

        public void setEquipmentNumber(String equipmentNumber) {
            this.equipmentNumber = equipmentNumber;
        }

        public String getFrequencyLowerLimit() {
            return frequencyLowerLimit;
        }

        public void setFrequencyLowerLimit(String frequencyLowerLimit) {
            this.frequencyLowerLimit = frequencyLowerLimit;
        }

        public String getFrequencyUpperLimit() {
            return frequencyUpperLimit;
        }

        public void setFrequencyUpperLimit(String frequencyUpperLimit) {
            this.frequencyUpperLimit = frequencyUpperLimit;
        }

        public String getGasFlowLowerLimit() {
            return gasFlowLowerLimit;
        }

        public void setGasFlowLowerLimit(String gasFlowLowerLimit) {
            this.gasFlowLowerLimit = gasFlowLowerLimit;
        }

        public String getGasFlowUpperLimit() {
            return gasFlowUpperLimit;
        }

        public void setGasFlowUpperLimit(String gasFlowUpperLimit) {
            this.gasFlowUpperLimit = gasFlowUpperLimit;
        }

        public String getHumidityLowerLimit() {
            return humidityLowerLimit;
        }

        public void setHumidityLowerLimit(String humidityLowerLimit) {
            this.humidityLowerLimit = humidityLowerLimit;
        }

        public String getHumidityUpperLimit() {
            return humidityUpperLimit;
        }

        public void setHumidityUpperLimit(String humidityUpperLimit) {
            this.humidityUpperLimit = humidityUpperLimit;
        }

        public String getHydrogenSulfideContentLowerLimit() {
            return hydrogenSulfideContentLowerLimit;
        }

        public void setHydrogenSulfideContentLowerLimit(String hydrogenSulfideContentLowerLimit) {
            this.hydrogenSulfideContentLowerLimit = hydrogenSulfideContentLowerLimit;
        }

        public String getHydrogenSulfideContentUpperLimit() {
            return hydrogenSulfideContentUpperLimit;
        }

        public void setHydrogenSulfideContentUpperLimit(String hydrogenSulfideContentUpperLimit) {
            this.hydrogenSulfideContentUpperLimit = hydrogenSulfideContentUpperLimit;
        }

        public String getIccId() {
            return iccId;
        }

        public void setIccId(String iccId) {
            this.iccId = iccId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getTemperatureLowerLimit() {
            return temperatureLowerLimit;
        }

        public void setTemperatureLowerLimit(String temperatureLowerLimit) {
            this.temperatureLowerLimit = temperatureLowerLimit;
        }

        public String getTemperatureUpperLimit() {
            return temperatureUpperLimit;
        }

        public void setTemperatureUpperLimit(String temperatureUpperLimit) {
            this.temperatureUpperLimit = temperatureUpperLimit;
        }

        public String getUuivertorQuantity() {
            return uuivertorQuantity;
        }

        public void setUuivertorQuantity(String uuivertorQuantity) {
            this.uuivertorQuantity = uuivertorQuantity;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
