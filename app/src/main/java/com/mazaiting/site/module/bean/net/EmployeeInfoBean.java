package com.mazaiting.site.module.bean.net;

import com.mazaiting.easy.base.BaseBean;
import com.mazaiting.site.module.bean.Employee;
import java.util.List;

/**
 * 员工信息 Bean
 * Created by mazaiting on 18/4/2.
 */

public class EmployeeInfoBean extends BaseBean {
    /**
     * 员工信息
     */
    private List<Employee> list;

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "EmployeeInfoBean{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", list=" + list +
                '}';
    }
}
