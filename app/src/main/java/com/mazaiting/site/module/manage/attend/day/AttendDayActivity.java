package com.mazaiting.site.module.manage.attend.day;

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
 * 当日考勤
 *
 * @author mazaiting
 */
public class AttendDayActivity extends BaseToolbarActivity<AttendDayPresenter> implements AttendDayContract.View{
    /**工地名称*/
    @BindView(R.id.attend_day_tv_site_name)
    TextView mTvSiteName;
    /**当前时间*/
    @BindView(R.id.attend_day_tv_time)
    TextView mTvTime;
    /**描述信息*/
    @BindView(R.id.attend_day_tv_desc)
    TextView mTvDesc;

    @Override
    public int getContentLayout() {
        return R.layout.activity_day_attend;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerAttendDayComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initData() {
        getSupportActionBar().setTitle(getResources().getString(R.string.tool_bar_attend_day));
        mPresenter.loadData();
    }

    @Override
    public void update(AttendBean.DayBean dayBean) {
        // 总人数
        int totalNumber = dayBean.getTotalNumber();
        // 实到人数
        int realNumber = dayBean.getRealNumber();
        // 缺勤人数
        int subNumber = totalNumber - realNumber;
        // 计算实到人数百分比
        float realPercent = realNumber * 100.0f / totalNumber;
        // 计算缺勤人数百分比
        float subPercent = subNumber * 100.0f / totalNumber;
        // 更新文本
        updateText(realNumber, totalNumber, realPercent, subPercent, dayBean.getSiteName());
        // 更新图表
        updateChart(realPercent, subPercent);
    }

    /**
     * 更新饼状图
     * @param realPercent 实到人数百分比
     * @param subPercent 缺勤人数百分比
     */
    private void updateChart(float realPercent, float subPercent) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.attend_day_frame_container, PieChartDayFragment.newInstance(realPercent, subPercent))
                .commitNow();
    }

    /**
     * 更新TextView
     * @param realNumber 实到人数
     * @param totalNumber 应到人数
     * @param realPercent 实到人数百分比
     * @param subPercent 缺勤人数百分比
     * @param siteName 工地名称
     */
    private void updateText(int realNumber, int totalNumber, float realPercent, float subPercent, String siteName) {
        // 设置工地名称
        mTvSiteName.setText(siteName);
        // 设置当前时间
        mTvTime.setText(DateUtil.getCurrentTime(System.currentTimeMillis()));
        // 设置提示文本
        String text = String.format(Locale.CHINA, getResources().getString(R.string.tv_attend_day), totalNumber, realNumber, realPercent, subPercent);
        mTvDesc.setText(text);
    }
}
