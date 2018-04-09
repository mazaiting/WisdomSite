package com.mazaiting.site.api;

import com.mazaiting.site.module.bean.net.SiteBean;

import io.reactivex.Observable;

/**
 * 工地 Api
 *
 * @author mazaiting
 * @date 2018/3/28
 */

public class SiteApi {
    private static SiteApi sApi;
    private SiteApiService mService;

    private SiteApi(SiteApiService service) {
        this.mService = service;
    }

    /**
     * 单例
     *
     * @param service 服务
     * @return 工地 接口
     */
    public static SiteApi getInstance(SiteApiService service) {
        if (null == sApi) {
            synchronized (SiteApi.class) {
                if (null == sApi) {
                    sApi = new SiteApi(service);
                }
            }
        }
        return sApi;
    }

    /**
     * 获取工地列表
     *
     * @param userId   用户id
     * @param page     页面
     * @param isDepart 是否监管
     * @param time     时间
     * @return 工地列表
     */
    public Observable<SiteBean> getSiteList(int userId, int page, int isDepart, String time) {
        return mService.getSiteList(userId, page, isDepart, time);
    }
}
