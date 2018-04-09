package com.mazaiting.site.api;

import com.mazaiting.site.module.bean.net.UserBean;

import io.reactivex.Observable;

/**
 * 用户操作 api
 * Created by mazaiting on 18/4/2.
 */

public class UserApi {
    private static UserApi sApi;
    private UserApiService mService;
    private UserApi(UserApiService service){
        this.mService = service;
    }

    /**
     * 单例
     * @param service 服务
     * @return api对象
     */
    public static UserApi getInstance(UserApiService service) {
        if (null == sApi) {
            synchronized (UserApi.class) {
                if (null == sApi) {
                    sApi = new UserApi(service);
                }
            }
        }
        return sApi;
    }

    /**
     * 登陆
     */
    public Observable<UserBean> login(String userName, String passWord, int isDepart) {
        return mService.login(userName, passWord, isDepart);
    }
}
