package com.mazaiting.site.module.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 员工信息类
 *
 * @author mazaiting
 * @date 2018/3/23
 */

public class Employee {
    /**
     * 员工ID
     */
    private String workerId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 民族
     */
    private String national;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 工种
     */
    private String type;
    /**
     * 虹膜机号
     */
    private String irisNumber;
    /**
     * 头盔号
     */
    private String helmetNumber;
    /**
     * 标签号
     */
    private String labelNumber;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 抓拍头像
     */
    @SerializedName("touImg")
    private String headImgUrl;
    /**
     * 工地名称
     */
    @SerializedName("Gong_Di_Name")
    private String workName;
    /**
     * 建筑名称
     */
    @SerializedName("Jian_Zhu_Name")
    private String buildName;
    /**
     * 楼层
     */
    @SerializedName("Lou_Ceng_Name")
    private String floorName;
    /**
     * 记录设备名称
     */
    @SerializedName("She_Bei_Name")
    private String equipName;
    /**
     * 抓拍照片
     */
    private String photo;

    public Employee() {
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIrisNumber() {
        return irisNumber;
    }

    public void setIrisNumber(String irisNumber) {
        this.irisNumber = irisNumber;
    }

    public String getHelmetNumber() {
        return helmetNumber;
    }

    public void setHelmetNumber(String helmetNumber) {
        this.helmetNumber = helmetNumber;
    }

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "员工ID：workerID='" + workerId + '\'' + '\n' +
                "姓名：name='" + name + '\'' + '\n' +
                "性别：sex='" + sex + '\'' + '\n' +
                "族别：national='" + national + '\'' + '\n' +
                "身份证：idCard='" + idCard + '\'' + '\n' +
                "工种类型：type='" + type + '\'' + '\n' +
                "虹膜机号：irisNumber='" + irisNumber + '\'' + '\n' +
                "头盔号：helmetNumber='" + helmetNumber + '\'' + '\n' +
                "标签编号：labelNumber='" + labelNumber + '\'' + '\n' +
                "创建时间：createTime='" + createTime + '\'' + '\n' +
                "工地名称：workName='" + workName + '\'' + '\n' +
                "建筑名称：buildName='" + buildName + '\'' + '\n' +
                "楼层：floorName='" + floorName + '\'' + '\n' +
                "设备名称：equipName='" + equipName + '\'' + '\n' +
                "头像链接：headImgUrl='" + headImgUrl + '\'' + '\n' +
                "照片：photo='" + photo + '\'' + '\n' +
                '}';
    }
}
