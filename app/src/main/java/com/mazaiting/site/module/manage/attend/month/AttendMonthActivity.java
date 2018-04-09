package com.mazaiting.site.module.manage.attend.month;

import android.widget.TextView;

import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.R;
import com.mazaiting.site.base.activity.BaseToolbarActivity;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.module.bean.net.AttendBean;
import com.mazaiting.site.utils.DateUtil;

import java.util.Locale;

import butterknife.BindView;

/**
 * 本月考勤
 *
 * @author mazaiting
 */
public class AttendMonthActivity extends BaseToolbarActivity<AttendMonthPresenter> implements AttendMonthContract.View {
    /**工厂名称*/
    @BindView(R.id.attend_month_tv_site_name)
    TextView mTvSiteName;
    /**当前时间*/
    @BindView(R.id.attend_month_tv_time)
    TextView mTvTime;
    /**描述信息*/
    @BindView(R.id.attend_month_tv_desc)
    TextView mTvDesc;

    @Override
    public int getContentLayout() {
        return R.layout.activity_month_attend;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerAttendMonthComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initData() {
        getSupportActionBar().setTitle(getResources().getString(R.string.tool_bar_attend_month));
        mPresenter.loadData();
    }

    @Override
    public void update(AttendBean.MonthBean monthBean) {
        // 满勤天数
        int fullNumber = monthBean.getFullNumber();
        // 缺勤天数
        int notFullNumber = monthBean.getNotFullNumber();
        // 总天数
        int totalNumber = fullNumber + notFullNumber;
        // 计算满勤天数百分比
        float fullPercent = fullNumber * 100.0f / totalNumber;
        // 计算缺勤天数百分比
        float notFullPercent = notFullNumber * 100.0f / totalNumber;
        updateText(fullNumber, notFullNumber, fullPercent, notFullPercent, monthBean.getSiteName());
        updateChart(fullNumber, notFullNumber);
    }

    /**
     * 更新图标
     * @param fullNumber 满勤天数
     * @param notFullNumber 缺勤天数
     */
    private void updateChart(int fullNumber, int notFullNumber) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.attend_month_frame_container, PieChartMonthFragment.newInstance(fullNumber, notFullNumber))
                .commitNow();
    }

    /**
     * 更新文本
     * @param fullNumber 满勤天数
     * @param notFullNumber 缺勤天数
     * @param fullPercent 满勤百分比
     * @param notFullPercent 缺勤百分比
     * @param siteName 工地名称
     */
    private void updateText(int fullNumber, int notFullNumber, float fullPercent, float notFullPercent, String siteName) {
        // 设置工地名称
        mTvSiteName.setText(siteName);
        // 设置当前时间
        mTvTime.setText(DateUtil.getCurrentTime(System.currentTimeMillis()));
        // 设置文本
        String text = String.format(Locale.CHINA, getResources().getString(R.string.tv_attend_month),
                fullNumber, notFullNumber, fullPercent, notFullPercent);
        mTvDesc.setText(text);
    }
}
