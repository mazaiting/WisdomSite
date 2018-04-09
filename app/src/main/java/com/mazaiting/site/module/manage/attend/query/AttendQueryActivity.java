package com.mazaiting.site.module.manage.attend.query;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.R;
import com.mazaiting.site.base.activity.BaseToolbarActivity;
import com.mazaiting.site.base.component.ApplicationComponentImpl;

import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 查询界面
 *
 * @author mazaiting
 */
public class AttendQueryActivity extends BaseToolbarActivity<AttendQueryPresenter> implements AttendQueryContract.View {
    /**开始标记*/
    private final int FLAG_START = 0x00;
    /**结束标记*/
    private final int FLAG_END = 0x01;
    /**开始时间*/
    @BindView(R.id.attend_query_tv_start_time)
    TextView mTvStartTime;
    /**结束时间*/
    @BindView(R.id.attend_query_tv_end_time)
    TextView mTvEndTime;
    /**描述信息*/
    @BindView(R.id.attend_query_tv_desc)
    TextView mTvDesc;
    /**日期选择对话框*/
    private DatePickerDialog mDatePickerDialog;
    /**按钮点击标记*/
    private int mFlag = FLAG_START;
    /**开始日期*/
    private int mStartYear, mStartMonth, mStartDay;
    /**结束日期*/
    private int mEndYear, mEndMonth, mEndDay;


    @Override
    public int getContentLayout() {
        return R.layout.activity_query_attend;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerAttendQueryComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initData() {
        getSupportActionBar().setTitle(getResources().getString(R.string.tool_bar_attend_query));
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 创建日期选择对话框
        mDatePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            // 设置时间
            switch (mFlag) {
                case FLAG_START:
                    mTvStartTime.setText(year + "年" + (month + 1)+ "月" + dayOfMonth + "日");
                    break;
                case FLAG_END:
                    mTvEndTime.setText(year + "年" + (month + 1) + "月" + dayOfMonth + "日");
                    break;
                default:
                    break;
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    @OnClick({R.id.attend_query_btn_start_time, R.id.attend_query_btn_end_time, R.id.attend_query_btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.attend_query_btn_start_time:
                // 获取开始时间
                mFlag = FLAG_START;
                mDatePickerDialog.show();
                break;
            case R.id.attend_query_btn_end_time:
                // 获取结束时间
                mFlag = FLAG_END;
                mDatePickerDialog.show();
                break;
            case R.id.attend_query_btn_search:
                // 点击查询
                mPresenter.loadData(10000, 200000);
                break;
            default:
                break;
        }
    }

    @Override
    public void setData() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.attend_query_frame_container, PieChartQueryFragment.newInstance())
                .commitNow();
    }
}
