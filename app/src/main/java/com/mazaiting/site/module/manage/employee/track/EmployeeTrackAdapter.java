package com.mazaiting.site.module.manage.employee.track;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mazaiting.site.BuildConfig;
import com.mazaiting.site.R;
import com.mazaiting.site.module.bean.EmployeeTrack;

/**
 * 员工轨迹适配器
 * @author mazaiting
 * @date 2018/3/23
 */

public class EmployeeTrackAdapter extends BaseQuickAdapter<EmployeeTrack, BaseViewHolder>{
    private Context mContext;
    EmployeeTrackAdapter(Context context) {
        super(R.layout.item_employee_track);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, EmployeeTrack item) {
        // 楼号 / 楼层
        helper.setText(R.id.item_tv_build_floor, item.getBuildNumber() + " / " + item.getFloorNumber())
                // 记录设备名称
                .setText(R.id.item_tv_equip_name, item.getEquipName())
                // 记录时间
                .setText(R.id.item_tv_entry_time, item.getEntryTime());
        // 设置图片
        Glide.with(mContext).load(BuildConfig.BASE_URL+item.getImagePath()).into((ImageView) helper.getView(R.id.item_iv_head_img));
    }
}
