package com.mazaiting.site.module.bean;

/**
 * 员工轨迹 Bean
 * @author mazaiting
 * @date 2018/3/23
 */

public class EmployeeTrack {
    /**楼号*/
    private String buildNumber;
    /**楼层*/
    private String floorNumber;
    /**记录设备名称*/
    private String equipName;
    /**记录时间*/
    private String entryTime;
    /**工地名称*/
    private String workName;
    /**抓拍图片地址*/
    private String imagePath;

    public EmployeeTrack() {
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "EmployeeTrack{" +
                "楼号：buildNumber='" + buildNumber + '\'' + '\n' +
                "楼层：floorNumber='" + floorNumber + '\'' + '\n' +
                "设备名称：equipName='" + equipName + '\'' + '\n' +
                "写入时间：entryTime='" + entryTime + '\'' + '\n' +
                "工地名称：workName='" + workName + '\'' + '\n' +
                "抓拍地址：imagePath='" + imagePath + '\'' + '\n' +
                '}';
    }
}
