package com.mazaiting.site.module.manage.employee.track;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;
import com.mazaiting.site.module.bean.EmployeeTrack;

import java.util.List;

/**
 * 员工轨迹 mvp
 * @author mazaiting
 * @date 2018/3/23
 */

public interface EmployeeTrackContract {

    interface View extends IBaseView {

        /**
         * 设置数据
         * @param list 列表
         */
        void setData(List<EmployeeTrack> list);

        /**
         * 添加数据
         * @param list 列表
         */
        void addData(List<EmployeeTrack> list);

        /**
         * 加载完成，即没有更多数据
         */
        void onLoadMoreComplete();
    }

    interface Presenter extends IBasePresenter<View> {

        /**
         * 加载数据
         * @param workerId 员工ID
         */
        void loadData(String workerId);

        /**
         * 加载更多
         */
        void loadMoreData();
    }

}
