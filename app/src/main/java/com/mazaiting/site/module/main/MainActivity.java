package com.mazaiting.site.module.main;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.mazaiting.site.R;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.module.bean.Site;
import com.mazaiting.site.module.login.LoginActivity;
import com.mazaiting.site.module.main.site.SiteFragment;
import com.mazaiting.site.module.main.unit.UnitFragment;
import com.mazaiting.easy.base.receiver.BaseNetChangeReceiver;
import com.mazaiting.site.receiver.NetChangeReceiver;
import com.mazaiting.site.utils.DateUtil;
import com.orhanobut.logger.Logger;

import java.text.ParseException;

import javax.inject.Inject;

/**
 * 主页面
 *
 * @author mazaiting
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /**
     * 侧滑菜单
     */
    private DrawerLayout mDrawer;
    /**
     * 工地列表页面
     */
    private SiteFragment mSiteFragment;
    /**
     * 使用人页面
     */
    private UnitFragment mUnitFragment;
    /**
     * 是否为监管部门
     */
    private boolean mIsDepart;
    /**
     * 网络改变广播
     */
    private NetChangeReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initReceiver();

        initView();

        initFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        // 获取传递的数据--是否为监管部门页面
        mIsDepart = getIntent().getBooleanExtra(Config.LOGIN_IS_DEPART, false);
        mSiteFragment = SiteFragment.newInstance();
        mUnitFragment = UnitFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_main, mSiteFragment)
                .add(R.id.content_main, mUnitFragment)
                .commit();
        if (mIsDepart) {
            setFragment(mSiteFragment, mUnitFragment);
        } else {
            setFragment(mUnitFragment, mSiteFragment);
        }
    }

    /**
     * 显示使用单位页面
     */
    public void showUnitFragment(){
        setFragment(mUnitFragment, mSiteFragment);
    }

    /**
     * 设置Fragment
     *
     */
    public void setFragment(Fragment showFragment, Fragment hideFragment) {
        // 设置Fragment页面
        getSupportFragmentManager()
                .beginTransaction()
                .show(showFragment)
                .hide(hideFragment)
                .commitNow();
    }

    /**
     * 初始化View
     */
    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * 初始化广播
     */
    private void initReceiver() {
        // 初始化网络改变广播

        mReceiver = new NetChangeReceiver();
        IntentFilter filter = new IntentFilter();
        // 添加Wifi状态改变动作
//        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        // 添加网络状态改变动作
//        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        // 添加网络连接动作
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "销毁主页面", Toast.LENGTH_SHORT).show();
        // 注销网络改变广播
        unregisterReceiver(mReceiver);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else if (mIsDepart && mUnitFragment.isVisible()) {
            setFragment(mSiteFragment, mUnitFragment);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_quit) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            sharedPreferences.edit()
                    .putBoolean(Config.LOGIN_IS_AUTO_LOGIN, false)
                    .apply();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
