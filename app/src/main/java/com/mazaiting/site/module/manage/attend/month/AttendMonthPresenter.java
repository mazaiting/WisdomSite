package com.mazaiting.site.module.manage.attend.month;

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
 * 当月考勤 主持人
 * @author mazaiting
 * @date 2018/3/26
 */

public class AttendMonthPresenter extends BaseNetPresenter<AttendMonthContract.View> implements AttendMonthContract.Presenter {
    private ManagerApi mManagerApi;
    @Inject
    AttendMonthPresenter(ManagerApi api){
        this.mManagerApi = api;
    }

    @Override
    public void loadData() {
        if (isNetConnected()) {
            mView.onShowLoading();
            mManagerApi.getAttendMonth(getSiteId())
                    .compose(RxScheduler.applySchedulers())
                    .compose(mView.bindToLife())
                    .subscribe(new BaseObserver<AttendBean.MonthBean>() {

                        @Override
                        protected void onSuccess(AttendBean.MonthBean monthBean) {
//                            Logger.e(monthBean.toString());
                            if (0 == monthBean.getRet()) {
                                mView.onShowSuccess();
                                mView.update(monthBean);
                            } else {
                                mView.onShowFailed(monthBean.getMsg());
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
