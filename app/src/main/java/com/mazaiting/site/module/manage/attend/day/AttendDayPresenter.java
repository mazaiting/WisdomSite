package com.mazaiting.site.module.manage.attend.day;

import com.mazaiting.easy.base.presenter.BasePresenter;
import com.mazaiting.easy.utils.rx.BaseObserver;
import com.mazaiting.easy.utils.rx.RxScheduler;
import com.mazaiting.site.api.ManagerApi;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.base.presenter.BaseNetPresenter;
import com.mazaiting.site.module.bean.net.AttendBean;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

/**
 * 当日考勤 主持人
 * @author mazaiting
 * @date 2018/3/23
 */

public class AttendDayPresenter extends BaseNetPresenter<AttendDayContract.View> implements AttendDayContract.Presenter {
    private ManagerApi mManagerApi;

    @Inject
    AttendDayPresenter(ManagerApi api) {
        this.mManagerApi = api;
    }

    @Override
    public void loadData() {
        if (isNetConnected()) {
            mView.onShowLoading();
            // 工地ID
            String siteId = getSiteId();
            mManagerApi.getAttendDay(siteId)
                    .compose(RxScheduler.applySchedulers())
                    .compose(mView.bindToLife())
                    .subscribe(new BaseObserver<AttendBean.DayBean>() {

                        @Override
                        protected void onSuccess(AttendBean.DayBean dayBean) {
//                            Logger.e(dayBean.toString());
                            if (0 == dayBean.getRet()) {
                                mView.onShowSuccess();
                                mView.update(dayBean);
                            } else {
                                mView.onShowFailed(dayBean.getMsg());
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

    /**
     * 获取工地ID
     * @return gongID
     */
    private String getSiteId() {
        return getString(Config.SITE_ID);
    }
}
