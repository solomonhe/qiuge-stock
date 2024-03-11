package com.qiuge.stock.openapi.tushare;

import com.alibaba.fastjson2.JSONArray;
import com.qiuge.stock.domain.Stock;

import java.util.List;


public interface TushareApiService  {

    /**
     * 获取A股全部股票列表
     */
    List<Stock> refreshStockTask();


    /**
     * @param stockTsCode 300522.SZ 股票代码
     * @param tradDate  交易日期 20230324
     * @return
     */
    JSONArray getStockCodeTradInfoByStockTsCodeAndTradDate(String stockTsCode, Integer tradDate);
}
