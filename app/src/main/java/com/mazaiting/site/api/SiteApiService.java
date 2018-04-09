package com.mazaiting.site.api;

import com.mazaiting.site.module.bean.net.SiteBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 工地 接口
 * @author mazaiting
 * @date 2018/3/28
 */

public interface SiteApiService {

    /**
     * 获取工地列表
     * @param userId 用户id
     * @param page 页面
     * @param isDepart 是否监管
     * @param time 时间
     * @return 工地列表
     */
    @GET("gongDiList.shtml")
    Observable<SiteBean> getSiteList(
            @Query("id") int userId,
            @Query("page") int page,
            @Query("isDepart") int isDepart,
            @Query("time") String time
    );
}
