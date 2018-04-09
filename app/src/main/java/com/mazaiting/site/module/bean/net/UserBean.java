package com.mazaiting.site.module.bean.net;

import com.google.gson.annotations.SerializedName;
import com.mazaiting.easy.base.BaseBean;

/**
 * 用户 Bean
 * Created by mazaiting on 18/4/2.
 */

public class UserBean extends BaseBean{
    /**用户名*/
    private String userName;
    /**密码*/
    private String passWord;
    /**是否为监管人员*/
    private int isDepart;
    /**用户ID*/
    @SerializedName("data")
    private int userId;
    /**工地ID*/
    @SerializedName("gongdiId")
    private String siteId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getIsDepart() {
        return isDepart;
    }

    public void setIsDepart(int isDepart) {
        this.isDepart = isDepart;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", isDepart=" + isDepart +
                ", userId=" + userId +
                ", siteId=" + siteId +
                '}';
    }
}
