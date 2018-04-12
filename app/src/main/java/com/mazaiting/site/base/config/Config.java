package com.mazaiting.site.base.config;

import com.mazaiting.easy.config.BaseConfig;
import com.mazaiting.site.BuildConfig;

/**
 * 配置类
 * @author mazaiting
 * @date 2018/3/21
 */

public class Config extends BaseConfig{
    /**字体*/
    public static final String OPEN_SANS_REGULAR = "OpenSans-Regular.ttf";
    public static final String OPEN_SANS_LIGHT = "OpenSans-Light.ttf";
    /**是否自动登录*/
    public static final String LOGIN_IS_AUTO_LOGIN = "is_auto_login";
    /**是否为监管部门*/
    public static final String LOGIN_IS_DEPART = "is_depart";
    /**用户名*/
    public static final String USER_NAME = "user_name";
    /**密码*/
    public static final String PASS_WORD = "pass_word";
    /**对话框Tag*/
    public static final String DIALOG_LOADING = "dialog_loading";
    /**无网络对话框tag*/
    public static final String DIALOG_PN = "dialog_pn";
    /**网络类型存储*/
    public static final String TYPE_NET = "type_net";
    /**储存用户ID*/
    public static final String USER_ID = "data";
    /**存储工地ID*/
    public static final String SITE_ID = "site_id";
    /**员工ID*/
    public static final String WORKER_ID = "worker_id";
    /**考勤实到人数*/
    public static final String ATTEND_REAL_PERCENT = "attend_real_percent";
    /**考勤缺勤人数*/
    public static final String ATTEND_SUB_PERCENT = "attend_sub_percent";
    /**满勤天数*/
    public static final String ATTEND_FULL_NUMBER = "attend_full_number";
    /**缺勤天数*/
    public static final String ATTEND_NOT_FULL_NUMBER = "attend_not_full_number";


    /**
     * 是否处于调试阶段
     * @return true, 调试；false, 发布版
     */
    @Override
    protected boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    /**
     * 是否开启内存检测
     * @return true, 开启；false, 不开启
     */
    @Override
    protected boolean isUseLogger() {
        return true;
    }

    /**
     * 是否开启UI卡顿检测
     * @return true, 开启；false, 不开启
     */
    @Override
    protected boolean isUseBlockCanary() {
        return true;
    }

    /**
     * 是否开启网页调试
     * @return true, 开启；false, 不开启
     */
    @Override
    protected boolean isUseStetho() {
        return true;
    }

}
