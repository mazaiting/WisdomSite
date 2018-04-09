package com.mazaiting.site.module.manage.equip;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.R;
import com.mazaiting.site.base.activity.BaseRefreshToolbarActivity;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.module.bean.Equip;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * 设备管理 页面
 *
 * @author mazaiting
 */
public class EquipManageActivity extends BaseRefreshToolbarActivity<EquipPresenter> implements EquipContract.View {

    @Override
    public int getContentLayout() {
        return R.layout.activity_equip_manage;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerEquipComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    protected BaseQuickAdapter setAdapter() {
        return new EquipAdapter();
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        super.bindView(view, savedInstanceState);
        // 设置加载更多监听
        mAdapter.setOnLoadMoreListener(() -> {
            mPresenter.loadMoreData();
            Toast.makeText(EquipManageActivity.this, "加载更多", Toast.LENGTH_SHORT).show();
        }, mRecyclerView);
        // 设置下拉刷新监听
        mSwipeLayout.setOnRefreshListener(() -> {
            Toast.makeText(EquipManageActivity.this, "刷新", Toast.LENGTH_SHORT).show();
            mSwipeLayout.setRefreshing(false);
        });
        // 条目点击监听
        mAdapter.setOnItemClickListener((adapter, view1, position) -> Toast.makeText(EquipManageActivity.this, "点击"+position, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void initData() {
        getSupportActionBar().setTitle(getResources().getString(R.string.tool_bar_equip));
        mPresenter.loadData();
    }

    @Override
    public void setData(List<Equip> list) {
        // 设置新数据
        mAdapter.setNewData(list);
    }

    @Override
    public void addData(List<Equip> list) {
        // 添加数据
        mAdapter.addData(list);
        // 加载更多完成
        mAdapter.loadMoreComplete();
    }

    @Override
    public void onLoadMoreComplete() {
        mAdapter.loadMoreEnd();
    }

    @Override
    public void onShowFailed(String message) {
        super.onShowFailed(message);
        Logger.e(message);
    }
}
