package com.mazaiting.site.api;

import com.mazaiting.site.module.bean.net.AttendBean;
import com.mazaiting.site.module.bean.net.EmployeeBean;
import com.mazaiting.site.module.bean.net.EmployeeInfoBean;
import com.mazaiting.site.module.bean.net.EmployeeTrackBean;
import com.mazaiting.site.module.bean.net.EquipBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 管理服务
 * Created by mazaiting on 18/4/2.
 */

public interface ManagerService {
    /**
     * 设备列表
     *
     * @param page   页数
     * @param siteId 工地ID
     * @param time   时间
     * @return 设备列表
     */
    @GET("sheBeiList.shtml")
    Observable<EquipBean> getEquipList(
            @Query("page") int page,
            @Query("gdid") String siteId,
            @Query("time") String time
    );

    /**
     * 人员列表
     *
     * @param page   页数
     * @param siteId 工地ID
     * @param time   时间
     * @return 人员列表
     */
    @GET("workerList.shtml")
    Observable<EmployeeBean> getEmployeeList(
            @Query("page") int page,
            @Query("gdid") String siteId,
            @Query("time") String time
    );

    /**
     * 员工信息
     *
     * @param workerId 员工ID
     * @return 员工详细信息
     */
    @GET("workerInfo.shtml")
    Observable<EmployeeInfoBean> getEmployeeInfo(
            @Query("workerId") String workerId
    );

    /**
     * 人员轨迹列表
     *
     * @param workerId 员工ID
     * @param page     页数
     * @param time     时间
     * @return 人员轨迹列表
     */
    @GET("trackList.shtml")
    Observable<EmployeeTrackBean> getEmployeeTrack(
            @Query("workerId") String workerId,
            @Query("page") int page,
            @Query("time") String time
    );

    /**
     * 当日考勤查询
     *
     * @param gdId 工地Id
     * @return 当日考勤信息
     */
    @GET("kaoQinList.shtml")
    Observable<AttendBean.DayBean> getAttendDay(
            @Query("gdId") String gdId
    );

    /**
     * 当月考勤
     * @param gdId 工地ID
     */
    @GET("kQMList.shtml")
    Observable<AttendBean.MonthBean> getAttendMonth(
            @Query("gdId") String gdId
    );

    /**
     * 自定义查询
     *
     * @param siteId    工地Id
     * @param startTime 开始时间
     * @param endTime   结束时间
     */
    @GET("")
    Observable<AttendBean.QueryBean> getAttendQuery(
            @Query("gdid") String siteId,
            @Query("startTime") String startTime,
            @Query("endTime") String endTime
    );
}
