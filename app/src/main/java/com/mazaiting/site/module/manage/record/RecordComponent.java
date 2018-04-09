package com.mazaiting.site.module.manage.record;

import com.mazaiting.site.base.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * 记录 组件
 * @author mazaiting
 * @date 2018/3/22
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface RecordComponent {
    /**
     * 注入Activitiy
     * @param activity 界面
     */
    void inject(RecordManageActivity activity);
}
