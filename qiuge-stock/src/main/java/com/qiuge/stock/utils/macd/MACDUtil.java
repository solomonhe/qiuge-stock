package com.qiuge.stock.utils.macd;

import java.math.BigDecimal;
import java.util.List;

/**
 * MACDUtil
 *
 * @author Solomon
 * @date 2021/12/23
 */

public class MACDUtil {


    public static Boolean jude(List<MACDInfo> macdInfoList) {
        MACDInfo toDayInfo = macdInfoList.get(0);
        MACDInfo yesterdayInfo = macdInfoList.get(1);

        //处于上升阶段

        /*
         * 1: 当天DIF比昨天大
         * 2: 当天EDA比昨天大
         * */

        if (MACDUtil.compareTo(toDayInfo.getDIF(), yesterdayInfo.getDIF()) >= 0
                && MACDUtil.compareTo(toDayInfo.getDEA(), yesterdayInfo.getDEA()) >= 0
        ) {
            return true;
        }

        return false;
    }


    private  static int compareTo(BigDecimal DIF, BigDecimal DEA) {
        return DIF.compareTo(DEA);
    }

}
