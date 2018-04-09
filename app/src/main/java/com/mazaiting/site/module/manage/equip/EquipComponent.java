package com.mazaiting.site.module.manage.equip;

import com.mazaiting.site.base.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * 设备组件
 * @author mazaiting
 * @date 2018/3/23
 */
@Component(dependencies = ApplicationComponentImpl.class)
public interface EquipComponent {
    /**
     * 注入Activity
     * @param activity 界面
     */
    void inject(EquipManageActivity activity);
}
