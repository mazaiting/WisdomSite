package com.mazaiting.site.module.login;

import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.module.welcome.WelcomeActivity;

import dagger.Component;

/**
 * 全局组件
 * @author mazaiting
 * @date 2018/3/22
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface LoginComponent {
    /**
     * 注入Activity
     * @param activity 界面
     */
    void inject(LoginActivity activity);

    /**
     * 注入Activity
     * @param activity 界面
     */
    void inject(WelcomeActivity activity);
}
