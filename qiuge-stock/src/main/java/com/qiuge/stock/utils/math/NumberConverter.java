package com.qiuge.stock.utils.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberConverter {

    public static String convertToUnits(long number) {
        if (number >= 100000000) {
            return convertToCny(number,100000000,"亿");
        } else if (number >= 10000000) {
            return convertToCny(number,10000000,"千万");
        } else if (number >= 1000000) {
            return convertToCny(number,1000000,"百万");
        } else if (number >= 10000) {
            return convertToCny(number,10000,"万");
        } else {
            return String.valueOf(number); // 如果值小于1000，则直接返回原始数值
        }
    }

    private static String formatInUnits(long number, String unit) {
        return String.format("%d%s", number, unit);
    }


    /**
     * 将long类型的数值转换为亿单位数值。
     * @param number 要转换的数值
     * @return 转换后的亿单位数值
     */
    private static String convertToCny(long number,long num,String unit) {
        return new BigDecimal(number).divide(new BigDecimal(num),2, RoundingMode.DOWN) + unit;
    }


    public static void main(String[] args) {
        long number = 123456789;
        String convertedValue = convertToUnits(number);
        System.out.println(convertedValue); // 输出转换后的值
    }
}