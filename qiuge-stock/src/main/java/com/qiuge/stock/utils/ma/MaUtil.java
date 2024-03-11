package com.qiuge.stock.utils.ma;

import com.qiuge.stock.openapi.bean.po.MaLevelInfo;
import com.qiuge.stock.utils.math.MathUtils;

import java.util.List;

/**
 * MaUtil
 *
 * @author Solomon
 * @date 2021/5/22 11:14
 */
public class MaUtil {

    /**
     * 均线120分散方法
     * <p>
     * 5 > 10 > 20 > 30 > 60 > 120
     *
     * @param maLevelInfo
     * @return
     */
    public static boolean Ma120(MaLevelInfo maLevelInfo) {
        Double aDouble = new Double(maLevelInfo.getMA5());
        Double aDouble1 = new Double(maLevelInfo.getMA10());
        Double aDouble2 = new Double(maLevelInfo.getMA20());
        Double aDouble3 = new Double(maLevelInfo.getMA30());
        Double aDouble4 = new Double(maLevelInfo.getMA60());
        Double aDouble5 = new Double(maLevelInfo.getMA120());

        if (aDouble < aDouble1)
            return false;
        if (aDouble1 < aDouble2)
            return false;
        if (aDouble2 < aDouble3)
            return false;
        if (aDouble3 < aDouble4)
            return false;
        if (aDouble4 < aDouble5)
            return false;
        return true;
    }


    /**
     * 均线60分散方法
     * <p>
     * 5 > 10 > 20 > 30 >  60
     *
     * @param maLevelInfo
     * @return
     */
    public static boolean Ma60(MaLevelInfo maLevelInfo) {
        Double aDouble = new Double(maLevelInfo.getMA5());
        Double aDouble1 = new Double(maLevelInfo.getMA10());
        Double aDouble2 = new Double(maLevelInfo.getMA20());
        Double aDouble3 = new Double(maLevelInfo.getMA30());
        Double aDouble4 = new Double(maLevelInfo.getMA60());

        if (aDouble < aDouble1)
            return false;
        if (aDouble1 < aDouble2)
            return false;
        if (aDouble2 < aDouble3)
            return false;
        if (aDouble3 < aDouble4)
            return false;
        return true;
    }


    /**
     * 均线30分散方法
     * <p>
     * 5 > 10 > 20 > 30 >  60
     *
     * @param maLevelInfo
     * @return
     */
    public static boolean Ma30(MaLevelInfo maLevelInfo) {
        Double aDouble = new Double(maLevelInfo.getMA5());
        Double aDouble1 = new Double(maLevelInfo.getMA10());
        Double aDouble2 = new Double(maLevelInfo.getMA20());
        Double aDouble3 = new Double(maLevelInfo.getMA30());

        if (aDouble < aDouble1)
            return false;
        if (aDouble1 < aDouble2)
            return false;
        if (aDouble2 < aDouble3)
            return false;

        return true;
    }

    /**
     * 均线30分散方法
     * <p>
     * 5 > 10 > 20 > 30 >  60
     *
     * @param maLevelInfo
     * @return
     */
    public static boolean Ma10(MaLevelInfo maLevelInfo) {
        Double aDouble = new Double(maLevelInfo.getMA5());
        Double aDouble1 = new Double(maLevelInfo.getMA10());
        Double aDouble2 = new Double(maLevelInfo.getMA20());
        Double aDouble3 = new Double(maLevelInfo.getMA30());
        if (aDouble > aDouble3){
            if (aDouble < aDouble1)
                return false;
            if (aDouble < aDouble2)
                return false;
        }
        return true;
    }



    /**
     * 均线30分散方法
     * <p>
     * 5 > 10 > 20 > 30
     *
     * @param maLevelInfos
     * @return
     */
    public static boolean Ma30And5DayUp(List<MaLevelInfo> maLevelInfos) {

        for (int i = 0; i < maLevelInfos.size(); i++) {
            if (i == 4) {
                continue;
            }
            MaLevelInfo maLevelInfo = maLevelInfos.get(i);
            MaLevelInfo maLevelInfo2 = maLevelInfos.get(i + 1);

            Double aDouble = new Double(maLevelInfo.getMA5());
            Double aDouble1 = new Double(maLevelInfo.getMA10());
            Double aDouble2 = new Double(maLevelInfo.getMA20());
            Double aDouble3 = new Double(maLevelInfo.getMA30());

            Double bDouble = new Double(maLevelInfo2.getMA5());
            Double bDouble1 = new Double(maLevelInfo2.getMA10());
            Double bDouble2 = new Double(maLevelInfo2.getMA20());
            Double bDouble3 = new Double(maLevelInfo2.getMA30());

            if (aDouble > bDouble)
                return false;
            if (aDouble1 > bDouble1)
                return false;
            if (aDouble2 > bDouble2)
                return false;
            if (aDouble3 > bDouble3)
                return false;

        }
        return true;

    }


    /**
     * 均线60分散方法
     * <p>
     * 5 > 10 > 20 > 30
     *
     * @param maLevelInfos
     * @return
     */
    public static boolean Ma60And5DayUp(List<MaLevelInfo> maLevelInfos) {

        for (int i = 0; i < maLevelInfos.size(); i++) {
            if (i == 4) {
                continue;
            }
            MaLevelInfo maLevelInfo = maLevelInfos.get(i);
            MaLevelInfo maLevelInfo2 = maLevelInfos.get(i + 1);

            Double aDouble = new Double(maLevelInfo.getMA5());
            Double aDouble1 = new Double(maLevelInfo.getMA10());
            Double aDouble2 = new Double(maLevelInfo.getMA20());
            Double aDouble3 = new Double(maLevelInfo.getMA30());
            Double aDouble4 = new Double(maLevelInfo.getMA60());

            Double bDouble = new Double(maLevelInfo2.getMA5());
            Double bDouble1 = new Double(maLevelInfo2.getMA10());
            Double bDouble2 = new Double(maLevelInfo2.getMA20());
            Double bDouble3 = new Double(maLevelInfo2.getMA30());
            Double bDouble4 = new Double(maLevelInfo2.getMA60());

            if (aDouble > bDouble)
                return false;
            if (aDouble1 > bDouble1)
                return false;
            if (aDouble2 > bDouble2)
                return false;
            if (aDouble3 > bDouble3)
                return false;
            if (aDouble4 > bDouble4)
                return false;

        }
        return true;

    }



    /**
     * 均线相差比例不超过2
     * <p>
     * 5 > 10 > 20 > 30
     *
     * @param maLevelInfos
     * @return
     */
    public static boolean Ma30And5DayRete(List<MaLevelInfo> maLevelInfos) {

        for (int i = 0; i < maLevelInfos.size(); i++) {
            MaLevelInfo maLevelInfo = maLevelInfos.get(i);

            Double aDouble = new Double(maLevelInfo.getMA5());
            Double aDouble1 = new Double(maLevelInfo.getMA10());
            Double aDouble2 = new Double(maLevelInfo.getMA20());
            Double aDouble3 = new Double(maLevelInfo.getMA30());

          if(!MathUtils.percentageDifference(aDouble2,aDouble,2)){
              return false;
          }

            if(!MathUtils.percentageDifference(aDouble2,aDouble1,2)){
                return false;
            }

            if(!MathUtils.percentageDifference(aDouble2,aDouble3,2)){
                return false;
            }

        }
        return true;

    }


    /**
     * 均线30分散方法
     * <p>
     * 5 > 10 > 20 > 30 >  60
     *
     * @param maLevelInfo
     * @return
     */
    public static boolean MA5DownMA30(MaLevelInfo maLevelInfo) {
        Double aDouble = new Double(maLevelInfo.getMA5());
        Double aDouble3 = new Double(maLevelInfo.getMA60());
        if (aDouble > aDouble3){
            return false;
        }
        return true;
    }



    /**
     * 均线20天分散方法
     * <p>
     * 5 > 10 > 20
     *
     * @param maLevelInfo
     * @return
     */
    public static boolean codePriceUPMA5AndMA10AndMa20(MaLevelInfo maLevelInfo,Double codePrice) {
        Double aDouble = new Double(maLevelInfo.getMA5());
        Double aDouble1 = new Double(maLevelInfo.getMA10());
        Double aDouble2 = new Double(maLevelInfo.getMA20());
        if (codePrice < aDouble)
            return false;
        if (aDouble < aDouble1)
            return false;
        if (aDouble1 < aDouble2)
            return false;

        return true;
    }
}
