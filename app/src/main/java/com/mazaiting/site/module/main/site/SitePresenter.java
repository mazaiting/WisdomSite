package com.mazaiting.site.module.main.site;

import com.mazaiting.easy.utils.rx.BaseObserver;
import com.mazaiting.easy.utils.rx.RxScheduler;
import com.mazaiting.site.api.SiteApi;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.base.presenter.BaseNetPresenter;
import com.mazaiting.site.module.bean.net.SiteBean;

import javax.inject.Inject;

/**
 * 工地 主持
 *
 * @author mazaiting
 * @date 2018/3/22
 */

class SitePresenter extends BaseNetPresenter<SiteContract.View> implements SiteContract.Presenter {
    private SiteApi mSiteApi;
    /**
     * 管理员用户ID
     */
    private int mUserId;
    /**
     * 当前页数
     */
    private static int sPage = 0;
    /**
     * 数据总页数
     */
    private int mTotalPage;
    /**
     * 时间
     */
    private String mTime;

    @Inject
    SitePresenter(SiteApi siteApi) {
        this.mSiteApi = siteApi;
    }

    @Override
    public void loadData() {
        if (isNetConnected()) {
            mView.onShowLoading();
            if (0 == mUserId) {
                mUserId = getInt(Config.USER_ID);
            }

//            mTime = DateUtil.getTime(System.currentTimeMillis());
            mSiteApi.getSiteList(mUserId, 0, 1, "")
                    .compose(RxScheduler.applySchedulers())
                    .compose(mView.bindToLife())
                    .subscribe(new BaseObserver<SiteBean>() {

                        @Override
                        protected void onSuccess(SiteBean siteBean) {
//                            Logger.e(siteBean.toString());
                            if (0 == siteBean.getRet()) {
                                mTime = siteBean.getTime();
                                mTotalPage = Integer.valueOf(siteBean.getPage());
                                mView.onShowSuccess();
                                mView.setData(siteBean.getList());
                            } else {
                                mView.onShowFailed(siteBean.getMsg());
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
                if (0 == mUserId) {
                    mUserId = getInt(Config.USER_ID);
                }
                mSiteApi.getSiteList(mUserId, sPage + 1, 1, mTime)
                        .compose(RxScheduler.applySchedulers())
                        .compose(mView.bindToLife())
                        .subscribe(new BaseObserver<SiteBean>() {

                            @Override
                            protected void onSuccess(SiteBean siteBean) {
//                                Logger.e(siteBean.toString());
                                if (0 == siteBean.getRet()) {
                                    sPage += 1;
                                    mView.onShowSuccess();
                                    mView.addData(siteBean.getList());
                                } else {
                                    mView.onShowFailed(siteBean.getMsg());
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

    @Override
    public void saveSiteId(String siteId) {
        putString(Config.SITE_ID, siteId);
    }
}
