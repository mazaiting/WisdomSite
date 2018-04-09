package com.mazaiting.site.module.manage.equip;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;
import com.mazaiting.site.module.bean.Equip;

import java.util.List;

/**
 * 设备 mvp
 *
 * @author mazaiting
 * @date 2018/3/23
 */

public interface EquipContract {

    interface View extends IBaseView {

        /**
         * 设置数据
         * @param list 数据列表
         */
        void setData(List<Equip> list);

        /**
         * 添加数据
         * @param list 数据列表
         */
        void addData(List<Equip> list);

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
