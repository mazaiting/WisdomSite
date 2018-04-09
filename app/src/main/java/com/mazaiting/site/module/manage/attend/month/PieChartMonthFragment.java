package com.mazaiting.site.module.manage.attend.month;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.github.mikephil.charting.data.PieEntry;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.base.fragment.BasePieChartFragment;

import java.util.List;

/**
 * @author mazaiting
 * @date 2018/3/26
 */

public class PieChartMonthFragment extends BasePieChartFragment {
    /**满勤天数*/
    private int mFullNumber;
    /**缺勤天数*/
    private int mNotFullNumber;
    /**
     * 创建Fragment实例
     *
     * @return PieChartDayFragment
     * @param fullNumber 满勤天数
     * @param notFullNumber 缺勤天数
     */
    public static PieChartMonthFragment newInstance(int fullNumber, int notFullNumber) {
        PieChartMonthFragment fragment = new PieChartMonthFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Config.ATTEND_FULL_NUMBER, fullNumber);
        bundle.putInt(Config.ATTEND_NOT_FULL_NUMBER, notFullNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFullNumber = getArguments().getInt(Config.ATTEND_FULL_NUMBER);
        mNotFullNumber = getArguments().getInt(Config.ATTEND_NOT_FULL_NUMBER);
    }

    @Override
    protected String setPieDataLabel() {
        return "当月考勤";
    }

    @Override
    protected void addData(List<PieEntry> entries) {
        entries.add(new PieEntry(mFullNumber, "到勤率"));
        entries.add(new PieEntry(mNotFullNumber, "缺勤率"));
    }
}
