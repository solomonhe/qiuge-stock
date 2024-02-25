package com.ruoyi.stock.openapi.tushare;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiuge.entity.stock.StockEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 用挖地免的接口
 *
 * @author chenguoxiang
 * @create 2018-10-30 9:31
 **/
//@RefreshScope
@Slf4j
@Service
public class TushareApiServiceImpl extends TushareBaseApi implements TushareApiService {


    @Override
    public List<StockEntity> refreshStockTask() {
        JSONObject json = new JSONObject();
        //接口名称
        json.put("api_name", "stock_basic");
        //只取上市的
        json.put("params", JSON.parse("{'list_status':'L'}"));

        json.put("fields", "ts_code, symbol,name,area,industry, market,list_date,fullname,cnspell,enname,exchange," +
                "curr_type,list_status,delist_date,is_hs");
        JSONArray jsonArray = post(json);
        log.info("TU 请求股票代码列表 size:{}",jsonArray.size());
        List<StockEntity> stockEntityList = StockEntity.convert(jsonArray);
        return stockEntityList;
    }

    @Override
    public JSONArray getStockCodeTradInfoByStockTsCodeAndTradDate(String stockTsCode,Integer tradDate) {

        log.info("TU 请求股票交易信息参数 stockTsCode:{},tradDate:{}",stockTsCode,tradDate);
        JSONObject json = new JSONObject();
        //接口名称
        json.put("api_name", "daily");

        //封装参数
        JSONObject params = new JSONObject();
        if (StringUtils.isNotBlank(stockTsCode)) {
            params.put("ts_code", stockTsCode);
        }
        if (Objects.nonNull(tradDate)) {
            params.put("trade_date",tradDate);
        }
        json.put("params", params);

        json.put("fields", "ts_code,trade_date,open,high,low,close,pre_close,change,pct_chg,vol,amount");
        JSONArray jsonArray = post(json);

        log.info("TU 请求股票交易信息列表 size:{}",jsonArray.size());
        return jsonArray;
    }
}
