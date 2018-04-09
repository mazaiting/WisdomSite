package com.mazaiting.site.api;

import com.mazaiting.site.module.bean.net.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 用户 操作接口
 * Created by mazaiting on 18/4/2.
 */

public interface UserApiService {
    /**
     * 表单上传
     */
    @FormUrlEncoded
    @POST("userLong.shtml")
    Observable<UserBean> login(
            @Field("userName")String userName,
            @Field("passWord")String passWord,
            @Field("isDepart")int isDepart
    );
}
