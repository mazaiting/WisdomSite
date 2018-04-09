package com.mazaiting.site.module.main.site;

import com.mazaiting.easy.base.mvp.IBasePresenter;
import com.mazaiting.easy.base.mvp.IBaseView;
import com.mazaiting.site.module.bean.Site;

import java.util.List;

/**
 * 监管部门 mvp
 * @author mazaiting
 * @date 2018/3/22
 */

public interface SiteContract {

    interface View extends IBaseView {

        /**
         * 设置数据
         * @param list 列表数据
         */
        void setData(List<Site> list);

        /**
         * 追加数据
         * @param list 数据列表
         */
        void addData(List<Site> list);

        /**
         * 加载更多完成
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

        /**
         * 保存工地Id
         * @param siteId 工地Id
         */
        void saveSiteId(String siteId);
    }

}
