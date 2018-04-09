package com.mazaiting.site.module.main.site;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.easy.base.fragment.BaseLazyFragment;
import com.mazaiting.site.R;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.module.bean.Site;
import com.mazaiting.site.module.bean.net.SiteBean;
import com.mazaiting.site.module.main.MainActivity;
import com.mazaiting.site.module.main.unit.UnitFragment;
import com.mazaiting.widget.fragment.LoadingDialogFragment;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;

/**
 * 监管部门界面
 *
 * @author mazaiting
 */
public class SiteFragment extends BaseLazyFragment<SitePresenter> implements SiteContract.View {
    /**列表*/
    @BindView(R.id.site_rv_list)
    RecyclerView mRecyclerView;
    /**下拉刷新*/
    @BindView(R.id.site_swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    /**Fragment对话框*/
    private LoadingDialogFragment mLoadingDialogFragment;
    /**工地适配器*/
    private SiteAdapter mAdapter;

    public static SiteFragment newInstance() {
        return new SiteFragment();
    }

    @Override
    protected void lazyFetchData() {
        mPresenter.loadData();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_site;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerSiteComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        // 设置下拉刷新的颜色
        mSwipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        // 设置布局方向
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 创建适配器
        mAdapter = new SiteAdapter();
        // 设置加载更多监听
        mAdapter.setOnLoadMoreListener(() -> {
            mPresenter.loadMoreData();
            Toast.makeText(getActivity(), "加载更多", Toast.LENGTH_SHORT).show();
        }, mRecyclerView);
        // 打开加载动画
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        // 设置适配器
        mRecyclerView.setAdapter(mAdapter);
        // 设置刷新不可用
//        mSwipeLayout.setRefreshing(false);
        // 设置下拉刷新监听
        mSwipeLayout.setOnRefreshListener(() -> {
            Toast.makeText(getActivity(), "刷新", Toast.LENGTH_SHORT).show();
            mAdapter.setEnableLoadMore(true);
            mPresenter.loadData();
            mSwipeLayout.setRefreshing(false);
        });
        // 条目点击监听
        mAdapter.setOnItemClickListener((adapter, view1, position) -> {
            String siteId = ((Site)adapter.getData().get(position)).getGdid();
            mPresenter.saveSiteId(siteId);
            ((MainActivity)getActivity()).showUnitFragment();
//            Toast.makeText(getActivity(), adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onShowLoading() {
        if (null == mLoadingDialogFragment) {
            mLoadingDialogFragment = new LoadingDialogFragment();
        }
        mLoadingDialogFragment.show(getActivity().getSupportFragmentManager(), Config.DIALOG_LOADING);
    }

    @Override
    public void onShowSuccess() {
        closeLoadingDialog();
    }

    /**
     * 关闭加载对话框
     */
    private void closeLoadingDialog() {
        if (mLoadingDialogFragment.isVisible()) {
            mLoadingDialogFragment.dismiss();
        }
    }

    @Override
    public void onShowFailed(String message) {
        closeLoadingDialog();
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowNoNet() {
        Toast.makeText(mContext, "无网络连接", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRetry() {

    }

    @Override
    public void setData(List<Site> list) {
        // 设置数据
        mAdapter.setNewData(list);
    }

    @Override
    public void addData(List<Site> list) {
        // 添加数据
        mAdapter.addData(list);
        // 标记加载更多完成
        mAdapter.loadMoreComplete();
    }

    @Override
    public void onLoadMoreComplete() {
        mAdapter.loadMoreEnd();
    }
}
