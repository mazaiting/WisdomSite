package com.mazaiting.site.utils;

import com.mazaiting.site.BuildConfig;

/**
 * 数据库管理工具类
 * @author mazaiting
 * @date 2018/3/21
 */

public class DbManager {

//    private static final String DB_NAME = "Site.db";
//
//    private static DbManager mDbManager = null;
//    private static DaoSession mDaoSession = null;
//
//    private DbManager(Context context){
//        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
//        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
//        mDaoSession = daoMaster.newSession();
//        // 在控制台打印出sql语句和查询的值
//        QueryBuilder.LOG_SQL = true;
//        QueryBuilder.LOG_VALUES = true;
//    }
//
//    public static DbManager getInstance(Context context){
//        if (null == mDbManager){
//            synchronized (DbManager.class){
//                if (null == mDbManager){
//                    mDbManager = new DbManager(context);
//                }
//            }
//        }
//        return mDbManager;
//    }
//
//    public NewFriendDao getNewFriendDao(){
//        return mDaoSession.getNewFriendDao();
//    }

}
