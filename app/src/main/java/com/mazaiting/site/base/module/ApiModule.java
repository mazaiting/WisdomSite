package com.mazaiting.site.base.module;

import com.mazaiting.site.BuildConfig;
import com.mazaiting.site.api.ManagerApi;
import com.mazaiting.site.api.ManagerService;
import com.mazaiting.site.api.SiteApi;
import com.mazaiting.site.api.SiteApiService;
import com.mazaiting.site.api.UserApi;
import com.mazaiting.site.api.UserApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * 提供Api
 * @author mazaiting
 * @date 2018/3/22
 */
@Module
public class ApiModule {

    @Provides
    UserApi providedUserApis(Retrofit.Builder builder) {
        return UserApi.getInstance(
                builder.baseUrl(BuildConfig.URL)
                .build().create(UserApiService.class)
        );
    }

    @Provides
    SiteApi providedSiteApis(Retrofit.Builder builder){
        return SiteApi.getInstance(
                builder.baseUrl(BuildConfig.URL)
                .build().create(SiteApiService.class)
        );
    }

    @Provides
    ManagerApi providedManagerApis(Retrofit.Builder builder) {
        return ManagerApi.getInstance(
                builder.baseUrl(BuildConfig.URL)
                .build().create(ManagerService.class)
        );
    }
}
