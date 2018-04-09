package com.mazaiting.site.module.manage.employee.main;

import android.text.TextUtils;

import com.mazaiting.easy.utils.rx.BaseObserver;
import com.mazaiting.easy.utils.rx.RxScheduler;
import com.mazaiting.site.api.ManagerApi;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.base.presenter.BaseNetPresenter;
import com.mazaiting.site.module.bean.net.EmployeeBean;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

/**
 * 员工管理 主持人
 *
 * @author mazaiting
 * @date 2018/3/23
 */

public class EmployeePresenter extends BaseNetPresenter<EmployeeContract.View> implements EmployeeContract.Presenter {
    private ManagerApi mManagerApi;
    /**
     * 当前页
     */
    private static int sPage = 0;
    /**
     * 总页数
     */
    private int mTotalPage;
    /**
     * 获取工地ID
     */
    private String mSiteId;
    /**
     * 时间
     */
    private String mTime;

    @Inject
    EmployeePresenter(ManagerApi api) {
        this.mManagerApi = api;
    }

    @Override
    public void loadData() {
        if (isNetConnected()) {
            mView.onShowLoading();
            if (TextUtils.isEmpty(mSiteId)) {
                mSiteId = getSiteId();
            }
            mManagerApi.getEmployeeList(0, mSiteId, "")
                    .compose(RxScheduler.applySchedulers())
                    .compose(mView.bindToLife())
                    .subscribe(new BaseObserver<EmployeeBean>() {

                        @Override
                        protected void onSuccess(EmployeeBean employeeBean) {
                            Logger.e(employeeBean.toString());
                            if (0 == employeeBean.getRet()) {
                                mTotalPage = employeeBean.getPage();
                                mTime = employeeBean.getTime();
                                mView.onShowSuccess();
                                mView.setData(employeeBean.getList());
                            } else {
                                mView.onShowFailed(employeeBean.getMsg());
                            }
                        }

                        @Override
                        protected void onFailed(Throwable e) {
                            mView.onShowFailed(e.getMessage());
                        }
                    });
        } else {
            mView.onShowNoNet();
        }
    }

    @Override
    public void loadMoreData() {
        if (isNetConnected()) {
            if (sPage < mTotalPage - 1) {
                mView.onShowLoading();
                mManagerApi.getEmployeeList(sPage + 1, mSiteId, mTime)
                        .compose(RxScheduler.applySchedulers())
                        .compose(mView.bindToLife())
                        .subscribe(new BaseObserver<EmployeeBean>() {

                            @Override
                            protected void onSuccess(EmployeeBean employeeBean) {
//                                Logger.e(employeeBean.toString());
                                if (0 == employeeBean.getRet()) {
                                    sPage += 1;
                                    mView.onShowSuccess();
                                    mView.addData(employeeBean.getList());
                                } else {
                                    mView.onShowFailed(employeeBean.getMsg());
                                }
                            }

                            @Override
                            protected void onFailed(Throwable e) {
                                mView.onShowFailed(e.getMessage());
                            }
                        });
            } else {
                mView.onLoadMoreComplete();
            }
        } else {
            mView.onShowNoNet();
        }
    }

    /**
     * 获取工地ID
     *
     * @return gongID
     */
    private String getSiteId() {
        return getString(Config.SITE_ID);
    }
}
