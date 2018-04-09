package com.mazaiting.site.module.manage.employee.main;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.R;
import com.mazaiting.site.base.activity.BaseRefreshToolbarActivity;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.module.bean.Employee;
import com.mazaiting.site.module.manage.employee.info.EmployeeInfoActivity;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * 员工管理界面
 * @author mazaiting
 */
public class EmployeeManageActivity extends BaseRefreshToolbarActivity<EmployeePresenter> implements EmployeeContract.View {

    @Override
    protected BaseQuickAdapter setAdapter() {
        return new EmployeeAdapter();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_employee_manage;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerEmployeeComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initData() {
        getSupportActionBar().setTitle(getResources().getString(R.string.tool_bar_employee));
        mPresenter.loadData();
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        super.bindView(view, savedInstanceState);
        mSwipeLayout.setOnRefreshListener(() -> {
            mPresenter.loadData();
            Toast.makeText(this, "刷新", Toast.LENGTH_SHORT).show();
            mSwipeLayout.setRefreshing(false);
        });
        mAdapter.setOnLoadMoreListener(() -> {
            mPresenter.loadMoreData();
            Toast.makeText(EmployeeManageActivity.this, "加载更多", Toast.LENGTH_SHORT).show();
        }, mRecyclerView);
        mAdapter.setOnItemClickListener((adapter, view1, position) -> {
            String workerId = ((Employee) adapter.getData().get(position)).getWorkerId();
            Bundle bundle = new Bundle();
            bundle.putString(Config.WORKER_ID, workerId);
            nextActivity(EmployeeInfoActivity.class, bundle);
        });
    }

    @Override
    public void setData(List<Employee> list) {
        mAdapter.getData().clear();
        // 设置新数据
        mAdapter.setNewData(list);
    }

    @Override
    public void addData(List<Employee> list) {
        // 添加数据
        mAdapter.addData(list);
        // 设置加载完成
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
        Logger.e(message);
    }
}
