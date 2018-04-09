package com.mazaiting.site.module.login;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;

/**
 * 登录的Mvp
 *
 * @author mazaiting
 * @date 2018/3/22
 */

public interface LoginContract {

    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter<View> {
        /**
         * 登录
         *  @param userName 用户名
         * @param passWord 密码
         * @param isDepart 是否为监管部门
         */
        void login(String userName, String passWord, int isDepart);

        /**
         * 保存自动登录状态
         *
         * @param isAutoLogin 是否自动登录
         */
        void saveAutoLogin(boolean isAutoLogin);

        /**
         * 保存用户名和密码
         *
         * @param userName 用户名
         * @param passWord 密码
         */
        void saveUserNameAndPassWord(String userName, String passWord);

        /**
         * 获取用户名
         *
         * @return 用户名
         */
        String getUserName();

        /**
         * 获取密码
         *
         * @return 密码
         */
        String getPassWord();

        /**
         * 保存是否是监管部门
         *
         * @param isDepart 是否为监管部门
         */
        void saveDepart(boolean isDepart);

        /**
         * 获取自动登录
         *
         * @return 是否自动登录
         */
        boolean getAutoLogin();

        /**
         * 是否为监管部门
         *
         * @return 是否为监管部门
         */
        boolean getDepart();
    }

}
