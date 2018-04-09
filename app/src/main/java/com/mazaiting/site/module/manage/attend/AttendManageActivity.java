package com.mazaiting.site.module.manage.attend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.mazaiting.site.R;
import com.mazaiting.site.module.manage.attend.day.AttendDayActivity;
import com.mazaiting.site.module.manage.attend.month.AttendMonthActivity;
import com.mazaiting.site.module.manage.attend.query.AttendQueryActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 考勤管理页面
 *
 * @author mazaiting
 */
public class AttendManageActivity extends AppCompatActivity {
    /**绑定视图*/
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend_manage);
        mUnBinder = ButterKnife.bind(this);
        initToolbar();
    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.tool_bar_attend);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.attend_iti_day, R.id.attend_iti_month, R.id.attend_iti_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.attend_iti_day:
                // 当日考勤
                dayAttend();
                break;
            case R.id.attend_iti_month:
                // 当月考勤
                monthAttend();
                break;
            case R.id.attend_iti_query:
                // 查询考勤
                queryAttend();
                break;
            default:
                break;
        }
    }

    /**
     * 查询考勤
     */
    private void queryAttend() {
        nextActivity(AttendQueryActivity.class, null);
    }

    /**
     * 当月考勤
     */
    private void monthAttend() {
        nextActivity(AttendMonthActivity.class, null);
    }

    /**
     * 当日考勤
     */
    private void dayAttend() {
        nextActivity(AttendDayActivity.class, null);
    }

    /**
     * 开启新页面
     * @param clazz Activity类字节码
     * @param bundle 传递的数据
     */
    private void nextActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解绑View
        if (null != mUnBinder) {
            mUnBinder.unbind();
        }
    }
}
