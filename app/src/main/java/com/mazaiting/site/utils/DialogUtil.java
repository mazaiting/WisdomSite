package com.mazaiting.site.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

import com.mazaiting.site.base.config.Config;
import com.mazaiting.widget.fragment.PnDialogFragment;

/**
 * Created by mazaiting on 18/4/11.
 */

public class DialogUtil {
    private static DialogUtil sDialogUtil = null;
    private DialogUtil(){}
    public static DialogUtil getInstance(){
        if (null == sDialogUtil) {
            synchronized (DialogUtil.class){
                if (null == sDialogUtil) {
                    sDialogUtil = new DialogUtil();
                }
            }
        }
        return sDialogUtil;
    }

    /**
     * 开启Wifi界面
     */
    public void startWifiDialog(AppCompatActivity activity){
        PnDialogFragment testFragment =
                new PnDialogFragment()
                        .setTitle("无网络连接")
                        .setMessage("请在设置页开启无线网络或移动网络！")
                        .setPositiveListener((dialog, which) -> {
                            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                            activity.startActivity(intent);
                        })
                        .setNegativeListener(null);

        testFragment.show(activity.getSupportFragmentManager(), Config.DIALOG_PN);
    }
}
