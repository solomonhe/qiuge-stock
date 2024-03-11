package com.qiuge.stock.openapi.bean.po;

import lombok.Data;

import java.io.Serializable;

/**
 * CodeDayInfoPo
 *
 * @author Solomon
 * @date 2021/5/13 13:50
 */
@Data
public class CodeDayInfoPo implements Serializable {
    /**
     * 股票代码 带SZ SH
     */
    private String symbol;

    /**
     * 股票代码
     */
    private String code;

    /**
     * 股票名称
     */
    private String name;

    /**
     * 股票归属  SZ SH
     */
    private String exchange;

    /**
     * 当天最高价
     */
    private String high;

    /**
     * 当天开盘价
     */
    private String open;


    /**
     * 涨停
     */
    private String limit_up;

    /**
     * 跌停
     */
    private String limit_down;

    /**
     * 52周最高
     */
    private String high52w;

    /**
     * 52周最低
     */
    private String low52w;


    /**
     * 总股本
     */
    private String total_shares;


    /**
     * 流通股
     */
    private String float_shares;


    /**
     * 振幅
     */
    private String amplitude;


    /**
     * 当前价
     */
    private String current;


    /**
     * 当天最低价
     */
    private String low;


    /**
     * 昨收
     */
    private String last_close;


    /**
     * 成交额
     */
    private String amount;

    /**
     * 成交量
     */
    private String volume;

    /**
     * 量比
     */
    private String volume_ratio;

    /**
     * 换手
     */
    private String turnover_rate;


    /**
     * 市盈率(动)
     */
    private String pe_forecast;

    /**
     * 市盈率(TTM)
     */
    private String pe_ttm;

    /**
     * 市盈率(静)
     */
    private String pe_lyr;


    /**
     * 总市值
     */
    private String market_capital;

    /**
     * 流通值
     */
    private String float_market_capital;


    /**
     * 市净率
     */
    private String profit;


    /**
     * 每股收益
     */
    private String eps;
    
    /**
     * 每股净资产
     */
    private String navps;


    /**
     * 质押率
     */
    private String pledge_ratio;


    /**
     * 股息(TTM)
     */
    private String dividend;

    /**
     * 股息率(TTM)
     */
    private String dividend_yield;
    /**
     * 当前涨幅
     */
    private String percent;


}
