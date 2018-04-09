package com.mazaiting.site.module.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 工地实体
 * @author mazaiting
 * @date 2018/3/22
 */

public class Site {
    /**
     * 工地名称
     */
    private String siteName;
    /**
     * 工地地址
     */
    private String siteAddress;
    /**
     * 工地管理员名称
     */
    private String managerName;
    /**
     * 工地ID
     */
    private String gdid;

    public Site() {
    }

    public Site(String siteName, String siteAddress, String managerName, String gdid) {
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.managerName = managerName;
        this.gdid = gdid;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getGdid() {
        return gdid;
    }

    public void setGdid(String gdid) {
        this.gdid = gdid;
    }

    @Override
    public String toString() {
        return "Site{" +
                "工地名称： siteName='" + siteName + '\'' + '\n' +
                "工地地址： siteAddress='" + siteAddress + '\'' + '\n' +
                "工地管理员名称： managerName='" + managerName + '\'' + '\n' +
                "工地ID： gdid='" + gdid + '\'' + '\n' +
                '}';
    }

}
