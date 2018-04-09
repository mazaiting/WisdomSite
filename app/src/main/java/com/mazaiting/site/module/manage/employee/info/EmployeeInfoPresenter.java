package com.mazaiting.site.module.manage.employee.info;

import com.mazaiting.easy.utils.rx.BaseObserver;
import com.mazaiting.easy.utils.rx.RxScheduler;
import com.mazaiting.site.api.ManagerApi;
import com.mazaiting.site.base.presenter.BaseNetPresenter;
import com.mazaiting.site.module.bean.Employee;
import com.mazaiting.site.module.bean.net.EmployeeInfoBean;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

/**
 * 员工人员信息 主持人
 *
 * @author mazaiting
 * @date 2018/3/23
 */

public class EmployeeInfoPresenter extends BaseNetPresenter<EmployeeInfoContract.View> implements EmployeeInfoContract.Presenter {
    private ManagerApi mManagerApi;

    @Inject
    EmployeeInfoPresenter(ManagerApi api) {
        this.mManagerApi = api;
    }

    @Override
    public void loadEmployeeInfo(String workerId) {
        if (isNetConnected()) {
            mView.onShowLoading();
            mManagerApi.getEmployeeInfo(workerId)
                    .compose(RxScheduler.applySchedulers())
                    .compose(mView.bindToLife())
                    .subscribe(new BaseObserver<EmployeeInfoBean>() {

                        @Override
                        protected void onSuccess(EmployeeInfoBean employeeInfoBean) {
                            if (0 == employeeInfoBean.getRet()) {
                                Employee employee = employeeInfoBean.getList().get(0);
                                employee.setWorkerId(workerId);

                                mView.onShowSuccess();
                                mView.setData(employee);
                            } else {
                                mView.onShowFailed(employeeInfoBean.getMsg());
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
}
