package com.mazaiting.site.module.main.unit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mazaiting.site.R;
import com.mazaiting.site.module.manage.attend.AttendManageActivity;
import com.mazaiting.site.module.manage.employee.main.EmployeeManageActivity;
import com.mazaiting.site.module.manage.equip.EquipManageActivity;
import com.mazaiting.site.module.manage.record.RecordManageActivity;
import com.mazaiting.widget.view.ItiView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 使用单位 页面
 *
 * @author mazaiting
 */
public class UnitFragment extends Fragment {
    /**布局控件绑定*/
    private Unbinder mUnBinder;

    public UnitFragment() {
    }


    public static UnitFragment newInstance() {
        return new UnitFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit, container, false);
        mUnBinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mUnBinder) {
            mUnBinder.unbind();
        }
    }

    @OnClick({R.id.unit_iti_attend_manage, R.id.unit_iti_record_manage, R.id.unit_iti_equip_manage, R.id.unit_iti_person_manage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.unit_iti_attend_manage:
                // 考勤管理
                attendManage();
                break;
            case R.id.unit_iti_record_manage:
                // 记录管理
                recordManage();
                break;
            case R.id.unit_iti_equip_manage:
                // 设备管理
                equipManage();
                break;
            case R.id.unit_iti_person_manage:
                // 人员管理
                personManage();
                break;
            default:
                break;
        }
    }

    /**
     * 人员管理
     */
    private void personManage() {
        nextActivity(EmployeeManageActivity.class, null);
    }

    /**
     * 设备管理
     */
    private void equipManage() {
        nextActivity(EquipManageActivity.class, null);
    }

    /**
     * 记录管理
     */
    private void recordManage() {
        nextActivity(RecordManageActivity.class, null);
    }

    /**
     * 考勤管理
     */
    private void attendManage() {
        nextActivity(AttendManageActivity.class, null);
    }

    /**
     * 开启新页面
     * @param clazz Activity类字节码
     * @param bundle 传递的数据
     */
    private void nextActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
