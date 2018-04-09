package com.mazaiting.site.module.bean;

/**
 * 记录 Bean
 * @author mazaiting
 * @date 2018/3/22
 */

public class Record {
    /**标签ID*/
    private String labelId;
    /**设备ID*/
    private String equipId;
    /**录入时间*/
    private String entryTime;

    public Record() {
    }

    public Record(String labelId, String equipId, String entryTime) {
        this.labelId = labelId;
        this.equipId = equipId;
        this.entryTime = entryTime;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "标签ID: labelId='" + labelId + '\'' + '\n' +
                "设备ID: equipId='" + equipId + '\'' + '\n' +
                "录入时间： entryTime='" + entryTime + '\'' + '\n' +
                '}';
    }
}
