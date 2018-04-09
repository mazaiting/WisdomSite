package com.mazaiting.site.module.manage.employee.main;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mazaiting.site.R;
import com.mazaiting.site.module.bean.Employee;

/**
 * 员工管理 适配器
 * @author mazaiting
 * @date 2018/3/23
 */

public class EmployeeAdapter extends BaseQuickAdapter<Employee,BaseViewHolder>{
    EmployeeAdapter() {
        super(R.layout.item_employee);
    }

    @Override
    protected void convert(BaseViewHolder helper, Employee item) {
        if ("18".equals(item.getWorkerId())){
            helper.setTextColor(R.id.item_tv_employee_name, Color.parseColor("#ff0000"));
        }
        if ("10".equals(item.getWorkerId())){
            helper.setTextColor(R.id.item_tv_employee_name, Color.parseColor("#ff0000"));
        }
        // 设置员工姓名
        helper.setText(R.id.item_tv_employee_name, item.getName())
                // 设置员工工种
                .setText(R.id.item_tv_employee_type, item.getType())
                // 设置员工性别
                .setText(R.id.item_tv_employee_sex, item.getSex());

    }
}
