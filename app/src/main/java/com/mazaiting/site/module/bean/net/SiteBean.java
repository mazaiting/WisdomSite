package com.mazaiting.site.module.bean.net;

import com.google.gson.annotations.SerializedName;
import com.mazaiting.easy.base.BaseBean;
import com.mazaiting.site.module.bean.Site;

import java.util.List;

/**
 * 工地 Bean
 * Created by mazaiting on 18/4/2.
 */

public class SiteBean extends BaseBean {
    /**
     * 页数
     */
    private String page;
    /**
     * 时间
     */
    @SerializedName("time")
    private String time;
    /**
     * 工地列表
     */
    private List<Site> list;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Site> getList() {
        return list;
    }

    public void setList(List<Site> list) {
        this.list = list;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SiteBean{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", page='" + page + '\'' +
                ", time='" + time + '\'' +
                ", list=" + list +
                '}';
    }
}
