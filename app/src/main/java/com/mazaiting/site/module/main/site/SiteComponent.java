package com.mazaiting.site.module.main.site;

import com.mazaiting.site.base.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * 监管部门组件
 * @author mazaiting
 * @date 2018/3/22
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface SiteComponent {
    /**
     * 注入Fragment
     * @param fragment 界面
     */
    void inject(SiteFragment fragment);
}
