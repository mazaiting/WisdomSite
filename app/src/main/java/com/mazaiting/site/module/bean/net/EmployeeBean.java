package com.mazaiting.site.module.bean.net;

import com.google.gson.annotations.SerializedName;
import com.mazaiting.easy.base.BaseBean;
import com.mazaiting.site.module.bean.Employee;

import java.util.List;

/**
 * 人员 Bean
 * Created by mazaiting on 18/4/2.
 */

public class EmployeeBean extends BaseBean {
    /**页数*/
    private int page;
    /**人员列表*/
    private List<Employee> list;
    /**时间*/
    @SerializedName("timeDian")
    private String time;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
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
        return "EmployeeBean{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", page=" + page +
                ", list=" + list +
                ", time='" + time + '\'' +
                '}';
    }
}
