package com.mazaiting.site.module.manage.record;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;
import com.mazaiting.site.module.bean.Record;

import java.util.List;

/**
 * 记录管理 mvp
 *
 * @author mazaiting
 * @date 2018/3/22
 */

public interface RecordContract {

    interface View extends IBaseView {

        /**
         * 设置数据
         * @param list 列表数据
         */
        void setData(List<Record> list);

        /**
         * 添加数据
         * @param list 列表数据
         */
        void addData(List<Record> list);
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
