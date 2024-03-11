package com.qiuge.stock.openapi.bean.dto;

import com.alibaba.fastjson2.JSONArray;
import lombok.Data;

/**
 *
 * tushare 股票日线行情Dto
 * StockDailyPriceDto
 *
 * @author Solomon
 * @date 2021/11/01
 */

@Data
public class StockDailyPriceDto {

    private String ts_code; //	股票代码

    private String trade_date;  //		交易日期

    private Float open;  //	开盘价

    private Float high;  //	最高价

    private Float low;  //	最低价

    private Float close;  //	收盘价

    private Float pre_close;  //	昨收价

    private Float change;  //	涨跌额

    private Float pct_chg;  //	涨跌幅

    private Long vol;  //	成交量

    private Long amount;  //	成交额


    public StockDailyPriceDto(JSONArray jsonArray) {
        try {
            this.ts_code = jsonArray.getString(0);
            this.trade_date = jsonArray.getString(1);
            this.open = jsonArray.getFloat(2);
            this.high = jsonArray.getFloat(3);
            this.low = jsonArray.getFloat(4);
            this.close = jsonArray.getFloat(5);
            this.pre_close = jsonArray.getFloat(6);
            this.change = jsonArray.getFloat(7);
            this.pct_chg = jsonArray.getFloat(8);
            this.vol = jsonArray.getLong(9);
            this.amount = jsonArray.getLong(10);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
