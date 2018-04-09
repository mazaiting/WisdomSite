package com.mazaiting.site.module.bean;

/**
 * 设备 Bean
 * @author mazaiting
 * @date 2018/3/22
 */

public class Equip {
    /**设备名称*/
    private String sheBeiName;
    /**设备号*/
    private String labelId;
    /**设备类型*/
    private String equipType;
    /**是否启动*/
    private boolean isUse;
    /**录入时间*/
    private String entryTime;

    public Equip() {
    }

    public String getSheBeiName() {
        return sheBeiName;
    }

    public void setSheBeiName(String sheBeiName) {
        this.sheBeiName = sheBeiName;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "Equip{" +
                "设备名称: sheBeiName='" + sheBeiName + '\'' + '\n' +
                "设备号: labelId='" + labelId + '\'' + '\n' +
                "设备类型: equipType='" + equipType + '\'' + '\n' +
                "是否启用: isUse=" + isUse + '\n' +
                "录入时间: entryTime='" + entryTime + '\'' + '\n' + 
                '}';
    }
}
