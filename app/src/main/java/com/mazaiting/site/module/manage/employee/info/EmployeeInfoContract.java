package com.mazaiting.site.module.manage.employee.info;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;
import com.mazaiting.site.module.bean.Employee;

/**
 * 员工人员信息 mvp
 * @author mazaiting
 * @date 2018/3/23
 */

public interface EmployeeInfoContract {

    interface View extends IBaseView {

        /**
         * 设置数据
         * @param employee 员工信息
         */
        void setData(Employee employee);
    }

    interface Presenter extends IBasePresenter<View> {

        /**
         * 加载员工信息
         * @param workerId 员工信息
         */
        void loadEmployeeInfo(String workerId);
    }
}
