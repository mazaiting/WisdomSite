package com.mazaiting.site.module.login;

import android.text.TextUtils;

import com.mazaiting.easy.utils.AesUtil;
import com.mazaiting.easy.utils.rx.BaseObserver;
import com.mazaiting.easy.utils.rx.RxScheduler;
import com.mazaiting.site.BuildConfig;
import com.mazaiting.site.api.UserApi;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.base.presenter.BaseNetPresenter;
import com.mazaiting.site.module.bean.net.UserBean;
import com.orhanobut.logger.Logger;


import javax.inject.Inject;

/**
 * 登录 主持
 *
 * @author mazaiting
 * @date 2018/3/22
 */

public class LoginPresenter extends BaseNetPresenter<LoginContract.View> implements LoginContract.Presenter {
    private UserApi mUserApi;

    @Inject
    LoginPresenter(UserApi api) {
        this.mUserApi = api;
    }

    @Override
    public void login(String userName, String passWord, int isDepart) {
        if (isNetConnected()) {
            mView.onShowLoading();
            mUserApi.login(userName, passWord, isDepart)
                    // 绑定线程
                    .compose(RxScheduler.applySchedulers())
                    // 绑定生命周期
                    .compose(mView.bindToLife())
                    // 订阅
                    .subscribe(new BaseObserver<UserBean>() {

                        @Override
                        protected void onSuccess(UserBean userBean) {
//                            Logger.e(userBean.toString());
                            // 等于0 为请求成功s
                            if (userBean.getRet() == 0) {
                                saveUserId(userBean.getUserId());
                                saveSiteId(userBean.getSiteId());
                                mView.onShowSuccess();
                                mView.update();
                            } else {
                                mView.onShowFailed(userBean.getMsg());
                            }
                        }

                        @Override
                        protected void onFailed(Throwable e) {
                            mView.onShowFailed("登录失败, 请重新登陆");
                        }
                    });
        } else {
            mView.onShowNoNet();
        }
    }

    /**
     * 保存工地ID
     *
     * @param siteId 工地Id
     */
    private void saveSiteId(String siteId) {
        putString(Config.SITE_ID, siteId);
    }

    /**
     * 保存用户ID
     *
     * @param userId 用户ID
     */
    private void saveUserId(int userId) {
        putInt(Config.USER_ID, userId);
    }

    @Override
    public void saveAutoLogin(boolean isAutoLogin) {
        putBoolean(Config.LOGIN_IS_AUTO_LOGIN, isAutoLogin);
    }

    @Override
    public void saveUserNameAndPassWord(String userName, String passWord) {
        putString(Config.USER_NAME, AesUtil.encrypt(userName, BuildConfig.KEY_ALGORITHM));
        putString(Config.PASS_WORD, AesUtil.encrypt(passWord, BuildConfig.KEY_ALGORITHM));
    }

    @Override
    public String getUserName() {
        String userName = getString(Config.USER_NAME);
        if (TextUtils.isEmpty(userName)) {
            return userName;
        } else {
            return AesUtil.decrypt(userName, BuildConfig.KEY_ALGORITHM);
        }
    }

    @Override
    public String getPassWord() {
        String passWord = getString(Config.PASS_WORD);
        if (TextUtils.isEmpty(passWord)) {
            return passWord;
        } else {
            return AesUtil.decrypt(passWord, BuildConfig.KEY_ALGORITHM);
        }
    }

    @Override
    public void saveDepart(boolean isDepart) {
        putBoolean(Config.LOGIN_IS_DEPART, isDepart);
    }

    @Override
    public boolean getAutoLogin() {
        return getBoolean(Config.LOGIN_IS_AUTO_LOGIN);
    }

    @Override
    public boolean getDepart() {
        return getBoolean(Config.LOGIN_IS_DEPART);
    }
}
