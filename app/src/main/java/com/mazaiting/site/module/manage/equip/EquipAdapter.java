package com.mazaiting.site.module.manage.equip;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mazaiting.site.R;
import com.mazaiting.site.module.bean.Equip;

/**
 * 设备适配器
 * @author mazaiting
 * @date 2018/3/23
 */

public class EquipAdapter extends BaseQuickAdapter<Equip, BaseViewHolder>{
    public EquipAdapter() {
        super(R.layout.item_equip);
    }

    @Override
    protected void convert(BaseViewHolder helper, Equip item) {
        // 设备名称
        helper.setText(R.id.item_tv_equip_name, item.getSheBeiName())
                // 设备号
                .setText(R.id.item_tv_equip_number, item.getLabelId())
                // 设备类型
                .setText(R.id.item_tv_equip_type, item.getEquipType())
                // 是否启用
                .setText(R.id.item_tv_equip_use, String.valueOf(item.isUse()))
                // 录入时间
                .setText(R.id.item_tv_entry_time,item.getEntryTime());
    }
}
