package com.mazaiting.site.module.manage.attend.month;

import com.mazaiting.site.base.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * 本月考勤 组件
 * @author mazaiting
 * @date 2018/3/26
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface AttendMonthComponent {
    /**
     * 注入Activity
     * @param activity 界面
     */
    void inject(AttendMonthActivity activity);
}
