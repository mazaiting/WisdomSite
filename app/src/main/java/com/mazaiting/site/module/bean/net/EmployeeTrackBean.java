package com.mazaiting.site.module.bean.net;

import com.google.gson.annotations.SerializedName;
import com.mazaiting.easy.base.BaseBean;
import com.mazaiting.site.module.bean.EmployeeTrack;

import java.util.List;

/**
 * 人员轨迹 Bean
 * Created by mazaiting on 18/4/2.
 */

public class EmployeeTrackBean extends BaseBean {
    /**页数*/
    private int page;
    /**时间*/
    @SerializedName("timeDian")
    private String time;
    /**轨迹列表*/
    private List<EmployeeTrack> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<EmployeeTrack> getList() {
        return list;
    }

    public void setList(List<EmployeeTrack> list) {
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
        return "EmployeeTrackBean{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", page=" + page +
                ", time='" + time + '\'' +
                ", list=" + list +
                '}';
    }
}
