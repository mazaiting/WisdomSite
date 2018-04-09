package com.mazaiting.site.module.manage.equip;

import android.text.TextUtils;

import com.mazaiting.easy.utils.rx.BaseObserver;
import com.mazaiting.easy.utils.rx.RxScheduler;
import com.mazaiting.site.api.ManagerApi;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.base.presenter.BaseNetPresenter;
import com.mazaiting.site.module.bean.net.EquipBean;

import javax.inject.Inject;

/**
 * 设备 主持人
 *
 * @author mazaiting
 * @date 2018/3/23
 */

public class EquipPresenter extends BaseNetPresenter<EquipContract.View> implements EquipContract.Presenter {
    private ManagerApi mManagerApi;
    /**
     * 工地ID
     */
    private String mSiteId;
    /**
     * 时间
     */
    private String mTime;
    /**
     * 当前页
     */
    private static int sPage = 0;
    /**
     * 总页数
     */
    private int mTotalPage;

    @Inject
    EquipPresenter(ManagerApi api) {
        this.mManagerApi = api;
    }

    @Override
    public void loadData() {
        if (isNetConnected()) {
            mView.onShowLoading();
            if (TextUtils.isEmpty(mSiteId)) {
                mSiteId = getSiteId();
            }
            mManagerApi.getEquipList(0, mSiteId, "")
                    .compose(RxScheduler.applySchedulers())
                    .compose(mView.bindToLife())
                    .subscribe(new BaseObserver<EquipBean>() {

                        @Override
                        protected void onSuccess(EquipBean equipBean) {
//                            Logger.e(equipBean.toString());
                            if (0 == equipBean.getRet()) {
                                mTotalPage = equipBean.getPage();
                                mTime = equipBean.getTime();
                                mView.onShowSuccess();
                                mView.setData(equipBean.getList());
                            } else {
                                mView.onShowFailed(equipBean.getMsg());
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
                mManagerApi.getEquipList(sPage + 1, mSiteId, mTime)
                        .compose(RxScheduler.applySchedulers())
                        .compose(mView.bindToLife())
                        .subscribe(new BaseObserver<EquipBean>() {

                            @Override
                            protected void onSuccess(EquipBean equipBean) {
//                                Logger.e(equipBean.toString());
                                if (0 == equipBean.getRet()) {
                                    sPage += 1;
                                    mView.onShowSuccess();
                                    mView.addData(equipBean.getList());
                                } else {
                                    mView.onShowFailed(equipBean.getMsg());
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
     * @return gongID
     */
    private String getSiteId() {
        return getString(Config.SITE_ID);
    }

}
