package com.mazaiting.site.module.manage.attend.day;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.github.mikephil.charting.data.PieEntry;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.base.fragment.BasePieChartFragment;

import java.util.List;

/**
 * 当日考勤 饼图Fragment
 *
 * @author mazaiting
 * @date 2018/3/26
 */

public class PieChartDayFragment extends BasePieChartFragment {
    /**
     * 实到人数百分比
     */
    private float mRealPercent;
    /**
     * 缺勤百分比
     */
    private float mSubPercent;

    /**
     * 创建Fragment实例
     *
     * @param realPercent 实到人数百分比
     * @param subPercent  缺勤百分比
     * @return PieChartDayFragment
     */
    public static PieChartDayFragment newInstance(float realPercent, float subPercent) {
        PieChartDayFragment fragment = new PieChartDayFragment();
        Bundle bundle = new Bundle();
        bundle.putFloat(Config.ATTEND_REAL_PERCENT, realPercent);
        bundle.putFloat(Config.ATTEND_SUB_PERCENT, subPercent);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRealPercent = getArguments().getFloat(Config.ATTEND_REAL_PERCENT);
        mSubPercent = getArguments().getFloat(Config.ATTEND_SUB_PERCENT);
    }

    @Override
    protected String setPieDataLabel() {
        return "当日考勤";
    }

    @Override
    protected void addData(List<PieEntry> entries) {
        // 添加数据
        entries.add(new PieEntry(mRealPercent, "到勤率"));
        entries.add(new PieEntry(mSubPercent, "缺勤率"));
    }
}
