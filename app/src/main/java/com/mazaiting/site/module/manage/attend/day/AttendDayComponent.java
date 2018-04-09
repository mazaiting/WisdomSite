package com.mazaiting.site.module.manage.attend.day;

import com.mazaiting.site.base.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * 当日考勤 组件
 * @author mazaiting
 * @date 2018/3/23
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface AttendDayComponent {
    /**
     * 注入Activity
     * @param activity 界面
     */
    void inject(AttendDayActivity activity);
}
