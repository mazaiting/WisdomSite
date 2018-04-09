package com.mazaiting.site.module.manage.attend.day;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;
import com.mazaiting.site.module.bean.net.AttendBean;

/**
 * 当日考勤 mvp
 * @author mazaiting
 * @date 2018/3/23
 */

public interface AttendDayContract {

    interface View extends IBaseView {
        /**
         * 更新布局
         * @param dayBean 当日考勤Bean
         */
        void update(AttendBean.DayBean dayBean);
    }

    interface Presenter extends IBasePresenter<View> {

        /**
         * 加载数据
         */
        void loadData();
    }

}
