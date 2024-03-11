package com.qiuge.stock.utils.code;

/**
 * StockPriceCodeUtil
 *
 * @author Solomon
 * @date 2021/5/14 13:53
 */
public class StockPriceCodeUtil {


    /**
     * 7.99999
     * 股票价格只保留小数点后两位
     *
     * @param codePrice
     * @return 7.99
     */
    public static Integer parseCodePrice(String codePrice) {
        String price = "";
        if (codePrice.contains(".")) {
            String[] split = codePrice.split("\\.");

            if (split[0].length() == 0) {
                price = split[0] + "00";
            } else if (split[1].length() == 1) {
                price = split[0] + split[1] + "0";
            } else {
                price = split[0] + split[1];
            }
        } else {
            price = codePrice + "00";
        }
        return new Integer(price);
    }
}
