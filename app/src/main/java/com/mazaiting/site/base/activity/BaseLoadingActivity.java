package com.mazaiting.site.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.mazaiting.easy.base.activity.BaseActivity;
import com.mazaiting.easy.base.presenter.BasePresenter;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.utils.DialogUtil;
import com.mazaiting.widget.fragment.LoadingDialogFragment;
import com.mazaiting.widget.fragment.PnDialogFragment;

/**
 * 加载页面基类
 * @author mazaiting
 * @date 2018/3/23
 */

public abstract class BaseLoadingActivity<T extends BasePresenter> extends BaseActivity<T>{

    /**加载进度条*/
    protected LoadingDialogFragment mLoadingDialogFragment;

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        
    }

    @Override
    public void onShowLoading() {
        if (null == mLoadingDialogFragment) {
            // 创建进度条Fragment
            mLoadingDialogFragment = new LoadingDialogFragment();
        }
        // 显示
        mLoadingDialogFragment.show(getSupportFragmentManager(), Config.DIALOG_LOADING);
    }

    @Override
    public void onShowSuccess() {
        closeLoadingDialog();
    }

    /**
     * 关闭对话框
     */
    private void closeLoadingDialog() {
        if (mLoadingDialogFragment.isVisible()) {
            mLoadingDialogFragment.dismiss();
        }
    }

    @Override
    public void onShowFailed(String message) {
        closeLoadingDialog();
    }

    @Override
    public void onShowNoNet() {
        DialogUtil.getInstance().startWifiDialog(this);
        Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRetry() {

    }

//    /**
//     * 开启Wifi界面
//     */
//    protected void startWifiActivity(){
//        PnDialogFragment testFragment =
//                new PnDialogFragment()
//                        .setTitle("无网络连接")
//                        .setMessage("请在设置页开启无线网络或移动网络！")
//                        .setPositiveListener((dialog, which) -> {
//                            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
//                            startActivity(intent);
//                        })
//                        .setNegativeListener(null);
//
//        testFragment.show(getSupportFragmentManager(), Config.DIALOG_PN);
//    }
}
