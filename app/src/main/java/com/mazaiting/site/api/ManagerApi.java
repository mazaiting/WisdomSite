package com.mazaiting.site.api;

import com.mazaiting.site.module.bean.net.AttendBean;
import com.mazaiting.site.module.bean.net.EmployeeBean;
import com.mazaiting.site.module.bean.net.EmployeeInfoBean;
import com.mazaiting.site.module.bean.net.EmployeeTrackBean;
import com.mazaiting.site.module.bean.net.EquipBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * 管理 Api
 * Created by mazaiting on 18/4/2.
 */

public class ManagerApi {
    private static ManagerApi sApi;
    private ManagerService mService;
    private ManagerApi(ManagerService service) {
        this.mService = service;
    }

    public static ManagerApi getInstance(ManagerService service) {
        if (null == sApi) {
            synchronized (ManagerApi.class) {
                if (null == sApi) {
                    sApi = new ManagerApi(service);
                }
            }
        }
        return sApi;
    }

    /**
     * 设备列表
     * @param page 页数
     * @param siteId 工地列表
     * @return
     */
    public Observable<EquipBean> getEquipList(int page, String siteId,String time) {
        return mService.getEquipList(page, siteId, time);
    }

    /**
     *
     * 人员列表
     * @param page 页数
     * @param siteId 工地ID
     * @return 人员列表
     */
    public Observable<EmployeeBean> getEmployeeList(int page, String siteId, String time){
        return mService.getEmployeeList(page, siteId, time);
    }

    /**
     * 员工信息
     * @param workerId 员工ID
     * @return 员工详细信息
     */
    public Observable<EmployeeInfoBean> getEmployeeInfo(String workerId) {
        return mService.getEmployeeInfo(workerId);
    }

    /**
     * 人员轨迹列表
     * @param workerId 员工ID
     * @param page 页数
     * @param time 时间
     * @return 人员轨迹列表
     */
    public Observable<EmployeeTrackBean> getEmployeeTrack(String workerId, int page, String time) {
        return mService.getEmployeeTrack(workerId, page, time);
    }

    /**
     * 当日考勤查询
     * @param gdId 工地Id
     * @return 当日考勤信息
     */
    public Observable<AttendBean.DayBean> getAttendDay(String gdId) {
        return mService.getAttendDay(gdId);
    }

    /**
     * 当日考勤查询
     * @param gdId 工地Id
     * @return 当日考勤信息
     */
    public Observable<AttendBean.MonthBean> getAttendMonth(String gdId) {
        return mService.getAttendMonth(gdId);
    }
}
