package com.mazaiting.site.module.manage.attend.query;

import com.mazaiting.easy.base.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * 考勤 主持人
 * @author mazaiting
 * @date 2018/3/26
 */

public class AttendQueryPresenter extends BasePresenter<AttendQueryContract.View> implements AttendQueryContract.Presenter {
    @Inject
    AttendQueryPresenter(){}

    @Override
    public void loadData(long startTime, long endTime) {
        mView.onShowLoading();

        mView.onShowSuccess();

        mView.setData();
    }
}
