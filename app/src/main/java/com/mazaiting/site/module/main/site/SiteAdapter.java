package com.mazaiting.site.module.main.site;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mazaiting.site.R;
import com.mazaiting.site.module.bean.Site;

/**
 * 工地适配器
 * @author mazaiting
 * @date 2018/3/22
 */

class SiteAdapter extends BaseQuickAdapter<Site, BaseViewHolder>{
    SiteAdapter() {
        super(R.layout.item_site);
    }

    @Override
    protected void convert(BaseViewHolder helper, Site item) {
        if ("200".equals(item.getGdid())) {
            helper.setTextColor(R.id.item_tv_site_name, Color.parseColor("#ff0000"));
        }
        // 设置工地名称
        helper.setText(R.id.item_tv_site_name, item.getSiteName())
                // 设置工地地址
                .setText(R.id.item_tv_site_address, item.getSiteAddress())
                // 设置工地管理人名称
                .setText(R.id.item_tv_manager_name, item.getManagerName());
    }
}
