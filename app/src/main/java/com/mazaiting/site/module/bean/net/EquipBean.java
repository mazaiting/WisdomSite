package com.mazaiting.site.module.bean.net;

import com.google.gson.annotations.SerializedName;
import com.mazaiting.easy.base.BaseBean;
import com.mazaiting.site.module.bean.Equip;

import java.util.List;

/**
 * 设备 Bean
 * Created by mazaiting on 18/4/2.
 */

public class EquipBean extends BaseBean{
    /**页数*/
    private int page;
    /**设备列表*/
    private List<Equip> list;
    /**时间*/
    @SerializedName("time")
    private String time;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Equip> getList() {
        return list;
    }

    public void setList(List<Equip> list) {
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
        return "EquipBean{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", page=" + page +
                ", list=" + list +
                ", time='" + time + '\'' +
                '}';
    }
}
