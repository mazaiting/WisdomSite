package com.mazaiting.site.module.bean.net;

import com.google.gson.annotations.SerializedName;
import com.mazaiting.easy.base.BaseBean;

/**
 * 考勤Bean
 * Created by mazaiting on 18/4/2.
 */

public class AttendBean {
    /**
     * 当日考勤Bean
     */
    public class DayBean extends BaseBean {
        /**应到人数*/
        private int totalNumber;
        /**实到人数*/
        private int realNumber;
        /**工地名称*/
        @SerializedName("gongDiName")
        private String siteName;

        public int getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(int totalNumber) {
            this.totalNumber = totalNumber;
        }

        public int getRealNumber() {
            return realNumber;
        }

        public void setRealNumber(int realNumber) {
            this.realNumber = realNumber;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        @Override
        public String toString() {
            return "DayBean{" +
                    "ret=" + ret +
                    ", msg='" + msg + '\'' +
                    ", totalNumber=" + totalNumber +
                    ", realNumber=" + realNumber +
                    ", siteName='" + siteName + '\'' +
                    '}';
        }
    }

    /**
     * 当月考勤
     */
    public class MonthBean extends BaseBean {
        /**满勤天数*/
        @SerializedName("totalNumber")
        private int fullNumber;
        /**缺勤天数*/
        @SerializedName("realNumber")
        private int notFullNumber;
        /**工地名称*/
        @SerializedName("gongDiName")
        private String siteName;

        public int getFullNumber() {
            return fullNumber;
        }

        public void setFullNumber(int fullNumber) {
            this.fullNumber = fullNumber;
        }

        public int getNotFullNumber() {
            return notFullNumber;
        }

        public void setNotFullNumber(int notFullNumber) {
            this.notFullNumber = notFullNumber;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        @Override
        public String toString() {
            return "MonthBean{" +
                    "ret=" + ret +
                    ", msg='" + msg + '\'' +
                    ", fullNumber=" + fullNumber +
                    ", notFullNumber=" + notFullNumber +
                    ", siteName='" + siteName + '\'' +
                    '}';
        }
    }

    /**
     * 自定义查询
     */
    public class QueryBean extends BaseBean {
        /**满勤天数*/
        private int totalNumber;
        /**缺勤天数*/
        private int absentNumber;

        public int getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(int totalNumber) {
            this.totalNumber = totalNumber;
        }

        public int getAbsentNumber() {
            return absentNumber;
        }

        public void setAbsentNumber(int absentNumber) {
            this.absentNumber = absentNumber;
        }

        @Override
        public String toString() {
            return "QueryBean{" +
                    "totalNumber=" + totalNumber +
                    ", absentNumber=" + absentNumber +
                    '}';
        }
    }
}
