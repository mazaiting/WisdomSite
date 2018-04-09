package com.mazaiting.site.module.manage.attend.month;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;
import com.mazaiting.site.module.bean.net.AttendBean;

/**
 * 当月考勤 mvp
 *
 * @author mazaiting
 * @date 2018/3/26
 */

public interface AttendMonthContract {
    interface View extends IBaseView {

        /**
         * 更新数据
         * @param monthBean 当月考勤Bean
         */
        void update(AttendBean.MonthBean monthBean);
    }

    interface Presenter extends IBasePresenter<View> {

        /**
         * 加载数据
         */
        void loadData();
    }
}
