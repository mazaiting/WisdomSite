package com.mazaiting.site.module.manage.attend.query;

import com.mazaiting.site.base.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * @author mazaiting
 * @date 2018/3/26
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface AttendQueryComponent {
    /**
     * 注入Activity
     * @param activity activity
     */
    void inject(AttendQueryActivity activity);
}
