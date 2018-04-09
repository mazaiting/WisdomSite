package com.mazaiting.site.module.manage.employee.info;

import com.mazaiting.site.base.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * 员工人员信息 组件
 * @author mazaiting
 * @date 2018/3/23
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface EmployeeInfoComponent {
    /**
     * 注入Activity
     * @param activity 界面
     */
    void inject(EmployeeInfoActivity activity);
}
