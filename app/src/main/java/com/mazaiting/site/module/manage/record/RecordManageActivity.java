package com.mazaiting.site.module.manage.record;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.R;
import com.mazaiting.site.base.activity.BaseRefreshToolbarActivity;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.module.bean.Record;

import java.util.List;

/**
 * 记录管理 页面
 *
 * @author mazaiting
 */
public class RecordManageActivity extends BaseRefreshToolbarActivity<RecordPresenter> implements RecordContract.View {

    @Override
    public int getContentLayout() {
        return R.layout.activity_record_manage;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerRecordComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        super.bindView(view, savedInstanceState);
        // 设置加载更多监听
        mAdapter.setOnLoadMoreListener(() -> {
            mPresenter.loadMoreData();
            Toast.makeText(RecordManageActivity.this, "加载更多", Toast.LENGTH_SHORT).show();
        }, mRecyclerView);
        // 设置下拉刷新监听
        mSwipeLayout.setOnRefreshListener(() -> {
            Toast.makeText(RecordManageActivity.this, "刷新", Toast.LENGTH_SHORT).show();
            mSwipeLayout.setRefreshing(false);
        });
        // 条目点击监听
        mAdapter.setOnItemClickListener((adapter, view1, position) -> Toast.makeText(RecordManageActivity.this, "点击"+position, Toast.LENGTH_SHORT).show());
    }

    @Override
    protected BaseQuickAdapter setAdapter() {
        return new RecordAdapter();
    }

    @Override
    public void initData() {
        mPresenter.loadData();
    }

    @Override
    public void setData(List<Record> list) {
        // 设置新数据
        mAdapter.setNewData(list);
    }

    @Override
    public void addData(List<Record> list) {
        // 添加数据
        mAdapter.addData(list);
        // 加载更多完成
        mAdapter.loadMoreComplete();
    }
}
