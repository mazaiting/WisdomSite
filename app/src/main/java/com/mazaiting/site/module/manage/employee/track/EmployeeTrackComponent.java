package com.mazaiting.site.module.manage.employee.track;

import com.mazaiting.site.base.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * 员工轨迹 组件
 * @author mazaiting
 * @date 2018/3/23
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface EmployeeTrackComponent {
    /**
     * 注入Activity
     * @param activity 界面
     */
    void inject(EmployeeTrackActivity activity);
}
