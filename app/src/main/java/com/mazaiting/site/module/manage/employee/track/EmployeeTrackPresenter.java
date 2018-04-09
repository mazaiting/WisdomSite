package com.mazaiting.site.module.manage.employee.track;

import com.mazaiting.easy.utils.rx.BaseObserver;
import com.mazaiting.easy.utils.rx.RxScheduler;
import com.mazaiting.site.api.ManagerApi;
import com.mazaiting.site.base.presenter.BaseNetPresenter;
import com.mazaiting.site.module.bean.EmployeeTrack;
import com.mazaiting.site.module.bean.net.EmployeeTrackBean;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 员工信息轨迹 主持人
 * @author mazaiting
 * @date 2018/3/23
 */

public class EmployeeTrackPresenter extends BaseNetPresenter<EmployeeTrackContract.View> implements EmployeeTrackContract.Presenter {
    private ManagerApi mManagerApi;
    /**当前页*/
    private static int sPage;
    /**总页数*/
    private int mTotalPage;
    /**时间*/
    private String mTime;
    /**员工ID*/
    private String mWorkerId;
    @Inject
    EmployeeTrackPresenter (ManagerApi api){
        this.mManagerApi = api;
    }

    @Override
    public void loadData(String workerId) {
        if (isNetConnected()) {
            mView.onShowLoading();
            this.mWorkerId = workerId;
            mManagerApi.getEmployeeTrack(workerId, 0, "")
                    .compose(RxScheduler.applySchedulers())
                    .compose(mView.bindToLife())
                    .subscribe(new BaseObserver<EmployeeTrackBean>() {

                        @Override
                        protected void onSuccess(EmployeeTrackBean employeeTrackBean) {
                            Logger.e(employeeTrackBean.toString());
                            if (0 == employeeTrackBean.getRet()) {
                                mTotalPage = employeeTrackBean.getPage();
                                mTime = employeeTrackBean.getTime();
                                mView.onShowSuccess();
                                mView.setData(employeeTrackBean.getList());
                            } else {
                                mView.onShowFailed(employeeTrackBean.getMsg());
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
                mManagerApi.getEmployeeTrack(mWorkerId, sPage + 1, mTime)
                        .compose(RxScheduler.applySchedulers())
                        .compose(mView.bindToLife())
                        .subscribe(new BaseObserver<EmployeeTrackBean>() {

                            @Override
                            protected void onSuccess(EmployeeTrackBean employeeTrackBean) {
                                Logger.e(employeeTrackBean.toString());
                                if (0 == employeeTrackBean.getRet()) {
                                    sPage += 1;
                                    mView.onShowSuccess();
                                    mView.addData(employeeTrackBean.getList());
                                } else {
                                    mView.onShowFailed(employeeTrackBean.getMsg());
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
}
