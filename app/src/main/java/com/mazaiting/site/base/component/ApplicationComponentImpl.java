package com.mazaiting.site.base.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.api.ManagerApi;
import com.mazaiting.site.api.SiteApi;
import com.mazaiting.site.api.UserApi;
import com.mazaiting.site.base.module.ApiModule;
import com.mazaiting.site.base.module.ApplicationModule;
import com.mazaiting.site.base.module.NetModule;

import dagger.Component;

/**
 * 全局ApplicationComponent组件
 * @author mazaiting
 * @date 2018/3/22
 */
@Component(modules = {NetModule.class, ApiModule.class, ApplicationModule.class})
public interface ApplicationComponentImpl extends ApplicationComponent{

    /**
     * 获取SharedPreferences
     * @return SharedPreferences对象
     */
    SharedPreferences getSharedPreferences();

    /**
     * 上下文
     * @return 上下文
     */
    Context getContext();

    /**
     * 用户操作 接口
     * @return 用户操作相关接口
     */
    UserApi getUserApi();

    /**
     * 工地 Api
     * @return 工地相关接口
     */
    SiteApi getSiteApi();

    /**
     * 管理 Api
     * @return 管理相关接口
     */
    ManagerApi getManagerApi();
}
