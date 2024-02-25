package com.ruoyi.stock.openapi.tushare;

import com.alibaba.fastjson.JSONArray;
import com.qiuge.entity.stock.StockEntity;

import java.util.List;


public interface TushareApiService  {

    /**
     * 获取A股全部股票列表
     */
    List<StockEntity> refreshStockTask();


    /**
     * @param stockTsCode 300522.SZ 股票代码
     * @param tradDate  交易日期 20230324
     * @return
     */
    JSONArray getStockCodeTradInfoByStockTsCodeAndTradDate(String stockTsCode,Integer tradDate);
}
