package com.mazaiting.site.module.manage.record;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mazaiting.site.R;
import com.mazaiting.site.module.bean.Record;

/**
 * 记录适配器
 * @author mazaiting
 * @date 2018/3/22
 */

class RecordAdapter extends BaseQuickAdapter<Record, BaseViewHolder>{
    RecordAdapter() {
        super(R.layout.item_record);
    }

    @Override
    protected void convert(BaseViewHolder helper, Record item) {
        // 标签ID
        helper.setText(R.id.item_tv_label_id, item.getLabelId())
                // 设备ID
                .setText(R.id.item_tv_equip_id, item.getEquipId())
                // 录入时间
                .setText(R.id.item_tv_entry_time, item.getEntryTime());
    }
}
