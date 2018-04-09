package com.mazaiting.site.module.manage.employee.main;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;
import com.mazaiting.site.module.bean.Employee;

import java.util.List;

/**
 * 员工管理 mvp
 * @author mazaiting
 * @date 2018/3/23
 */

public interface EmployeeContract {
    interface View extends IBaseView {

        /**
         * 设置数据
         * @param list 列表
         */
        void setData(List<Employee> list);

        /**
         * 添加数据
         * @param list 列表
         */
        void addData(List<Employee> list);

        /**
         * 加载更多完成，即没有更多数据
         */
        void onLoadMoreComplete();
    }

    interface Presenter extends IBasePresenter<View> {

        /**
         * 加载数据
         */
        void loadData();

        /**
         * 加载更多
         */
        void loadMoreData();
    }
}
