package com.mazaiting.site.module.manage.attend.query;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;

/**
 * 查询考勤 mvp
 * @author mazaiting
 * @date 2018/3/26
 */

public interface AttendQueryContract {
    interface View extends IBaseView {

        /**
         * 设置数据
         */
        void setData();
    }

    interface Presenter extends IBasePresenter<View> {

        /**
         * 获取网络数据
         * @param startTime 开始时间
         * @param endTime 结束时间
         */
        void loadData(long startTime, long endTime);
    }
}
