package com.mazaiting.site.module.manage.attend.query;

import android.os.Bundle;

import com.github.mikephil.charting.data.PieEntry;
import com.mazaiting.site.base.fragment.BasePieChartFragment;
import com.mazaiting.site.module.manage.attend.month.PieChartMonthFragment;

import java.util.List;

/**
 * @author mazaiting
 * @date 2018/3/26
 */

public class PieChartQueryFragment extends BasePieChartFragment {
    /**
     * 创建Fragment实例
     *
     * @return PieChartDayFragment
     */
    public static PieChartQueryFragment newInstance() {
        PieChartQueryFragment fragment = new PieChartQueryFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected String setPieDataLabel() {
        return "自定义考勤查询";
    }

    @Override
    protected void addData(List<PieEntry> entries) {
        entries.add(new PieEntry(50, "到勤率"));
        entries.add(new PieEntry(50, "缺勤率"));
    }
}
