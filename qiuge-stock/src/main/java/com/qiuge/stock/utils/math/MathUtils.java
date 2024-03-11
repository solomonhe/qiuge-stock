package com.qiuge.stock.utils.math;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

/**
 * MathUtils
 *
 * @author Solomon
 * @date 2021/5/14 21:55
 */
public class MathUtils {


    /**
     * 两数误差百分比
     *
     * @param num1
     * @param num2
     * @param percentage 百分比
     * @return
     */
    public static boolean percentageDifference(Double num1, Double num2, int percentage) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);

        double result = num1 / num2 * 100;
        return result > 100 - percentage && result < 100 + percentage;
    }


    /**
     * 计算平均值
     *
     * @param mas
     * @return
     */
    public static String getMaSum(List<Double> mas) {
        Double i = 0.0d;
        for (Double ma : mas) {
            i = i + ma;
        }
        return String.valueOf(i / mas.size());
    }


    /**
     * 两数误差百分比
     *
     * @param openPrice
     * @param closePrice
     * @return
     */
    public static String percentageDifference(String openPrice, String closePrice) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);

        Double open = Double.valueOf(openPrice);
        Double close = Double.valueOf(closePrice);
        double result = close / open * 100 - 100;
        return numberFormat.format(result);
    }


    /**
     * 股票交易量/交易额 换算中文 亿
     *
     * @param strNum
     * @return
     */
    public static String calculateNum(String strNum) {
        Double num = 0d;

        try {
            num = Double.valueOf(strNum);
        } catch (Exception e) {

        }

        if (num > 100000000) {
            Double n = (double) num / 100000000;
            return subTwo(n) + "亿";
        } else if (num > 10000000) {
            double n = (double) num / 10000000;
            return subTwo(n) + "千万";
        } else if (num > 1000000) {
            double n = (double) num / 1000000;
            return subTwo(n) + "百万";
        } else if (num > 10000) {
            double n = (double) num / 10000;
            return subTwo(n) + "万";
        } else {
            return num + "";
        }
    }

    private static double subTwo(double num) {
        BigDecimal b = new BigDecimal(num);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 两数相除不能整除 余数+1
     * @param divisor  除数
     * @param dividend 被除数
     * @return
     */
    public static long times(long divisor, long dividend) {
        if (0 == dividend || 0 == divisor)
            return 0;
        long x = divisor % dividend;
        return x == 0 ? divisor / dividend : (divisor / dividend) + 1;
    }

}
