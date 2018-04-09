package com.mazaiting.site.module.manage.employee.track;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.R;
import com.mazaiting.site.base.activity.BaseRefreshToolbarActivity;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.module.bean.EmployeeTrack;

import java.util.List;

/**
 * 员工轨迹
 * @author mazaiting
 */
public class EmployeeTrackActivity extends BaseRefreshToolbarActivity<EmployeeTrackPresenter> implements EmployeeTrackContract.View {

    @Override
    public int getContentLayout() {
        return R.layout.activity_employee_track;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        super.bindView(view, savedInstanceState);
        // 加载更多
        mAdapter.setOnLoadMoreListener(() -> {
            mPresenter.loadMoreData();
            Toast.makeText(EmployeeTrackActivity.this, "加载更多", Toast.LENGTH_SHORT).show();
        }, mRecyclerView);
        // 下拉刷新
        mSwipeLayout.setOnRefreshListener(() -> {
            mSwipeLayout.setRefreshing(false);
            Toast.makeText(EmployeeTrackActivity.this, "条目点击", Toast.LENGTH_SHORT).show();
        });
        // 条目点击监听
        mAdapter.setOnItemClickListener((adapter, view1, position) -> {
            Toast.makeText(EmployeeTrackActivity.this, "条目点击", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerEmployeeTrackComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initData() {
        getSupportActionBar().setTitle(getResources().getString(R.string.tool_bar_employee_track));
        String workerId = getIntent().getStringExtra(Config.WORKER_ID);
        mPresenter.loadData(workerId);
    }

    @Override
    protected BaseQuickAdapter setAdapter() {
        return new EmployeeTrackAdapter(this);
    }

    @Override
    public void setData(List<EmployeeTrack> list) {
        // 设置新数据
        mAdapter.setNewData(list);
    }

    @Override
    public void addData(List<EmployeeTrack> list) {
        // 添加新数据
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
