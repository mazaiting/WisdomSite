package com.mazaiting.site.module.manage.employee.info;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.site.BuildConfig;
import com.mazaiting.site.R;
import com.mazaiting.site.base.activity.BaseToolbarActivity;
import com.mazaiting.site.base.component.ApplicationComponentImpl;
import com.mazaiting.site.base.config.Config;
import com.mazaiting.site.module.bean.Employee;
import com.mazaiting.site.module.manage.employee.track.EmployeeTrackActivity;
import com.mazaiting.widget.view.IttView;

import butterknife.BindView;

/**
 * 员工信息 页面
 *
 * @author mazaiting
 */
public class EmployeeInfoActivity extends BaseToolbarActivity<EmployeeInfoPresenter> implements EmployeeInfoContract.View {
    /**姓名*/
    @BindView(R.id.employee_info_itt_name)
    IttView mIttName;
    /**性别*/
    @BindView(R.id.employee_info_itt_sex)
    IttView mIttSex;
    /**族别*/
    @BindView(R.id.employee_info_itt_national)
    IttView mIttNational;
    /**身份证*/
    @BindView(R.id.employee_info_itt_id_card)
    IttView mIttIdCard;
    /**工种*/
    @BindView(R.id.employee_info_itt_type)
    IttView mIttType;
    /**虹膜机号*/
    @BindView(R.id.employee_info_itt_iris_number)
    IttView mIttIrisNumber;
    /**头盔号*/
    @BindView(R.id.employee_info_itt_helmet_number)
    IttView mIttHelmetNumber;
    /**标签号*/
    @BindView(R.id.employee_info_itt_label_number)
    IttView mIttLabelNumber;
    /**创建时间*/
    @BindView(R.id.employee_info_itt_create_time)
    IttView mIttCreateTime;
    /**人员轨迹*/
    @BindView(R.id.employee_info_itt_track)
    IttView mIttTrack;
    /**头像*/
    @BindView(R.id.employee_info_iv_display)
    ImageView mIvDisplay;
    /**员工ID*/
    private Bundle mBundle;

    @Override
    public int getContentLayout() {
        return R.layout.activity_employee_info;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        DaggerEmployeeInfoComponent
                .builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        super.bindView(view, savedInstanceState);
        mIttTrack.setOnClickListener(v -> {
            nextActivity(EmployeeTrackActivity.class,mBundle);
        });
    }

    @Override
    public void initData() {
        getSupportActionBar().setTitle(getResources().getString(R.string.tool_bar_employee_info));
        mBundle = getIntent().getExtras();
        String workerId = mBundle.getString(Config.WORKER_ID);
        mPresenter.loadEmployeeInfo(workerId);
    }

    @Override
    public void setData(Employee employee) {
        runOnUiThread(() -> {
            mIttName.setTvContent(employee.getName());
            mIttSex.setTvContent(employee.getSex());
            mIttNational.setTvContent(employee.getNational());
            mIttIdCard.setTvContent(employee.getIdCard());
            mIttType.setTvContent(employee.getType());
            mIttIrisNumber.setTvContent(employee.getIrisNumber());
            if (!"null".equals(employee.getHelmetNumber())){
                mIttHelmetNumber.setTvContent(employee.getHelmetNumber());
            }
            mIttLabelNumber.setTvContent(employee.getLabelNumber());
            mIttCreateTime.setTvContent(employee.getCreateTime());
            mIttTrack.setTvContent(employee.getBuildName()+ "/" + employee.getFloorName());
            Glide.with(this).load(BuildConfig.BASE_URL+employee.getHeadImgUrl()).into(mIvDisplay);
        });
    }
}
