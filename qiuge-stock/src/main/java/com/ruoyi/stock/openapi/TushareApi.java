package com.ruoyi.stock.openapi;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiuge.entity.stock.StockTradeDateEntity;
import com.qiuge.stock.bean.dto.StockDailyPriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 用挖地免的接口
 *
 * @author chenguoxiang
 * @create 2018-10-30 9:31
 **/
//@RefreshScope
@Slf4j
@Component("TushareSpider")
public class TushareApi {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${tushare.token}")
    private String tuToken = "66cdab7a757dcb728f8833f732a928791d67b6f38e1cd8d94bb79a0d";


    final String api = "http://api.tushare.pro";

    /**
     * 格式化成tushare API所需格式
     *
     * @param code
     * @return
     */
    public static String formatCode(String code) {
        //5开头，沪市基金或权证 60开头上证
        if (code.matches("^60.*|^68.*|^5.*|^7.*")) {
            return String.format("%s.SH", code);
        }
        //1开头的，是深市基金 00开头是深圳
        else if (code.matches("^1.*|^00.*|^300...")) {
            return String.format("%s.SZ", code);
        }
        return null;
    }

    /**
     * post 方式提交
     *
     * @param params
     * @return
     */
    JSONArray post(JSONObject params) {
        try {
            HttpHeaders headers = new HttpHeaders();
            //定义请求参数类型，这里用json所以是MediaType.APPLICATION_JSON
            headers.setContentType(MediaType.APPLICATION_JSON);
            params.put("token", tuToken);
            HttpEntity<String> formEntity = new HttpEntity<String>(params.toString(), headers);
            String result = restTemplate.postForObject(api, formEntity, String.class);
            JSONObject datas = JSON.parseObject(result);
            JSONArray items = datas.getJSONObject("data").getJSONArray("items");
            return items;
        } catch (Exception e) {
            log.error("tush 请求服务错误 ：{} , 请求参数：{}", e, params);
        }
        return new JSONArray();
    }


    /**
     * 返回已上市的A股代码
     *
     * @return TS代码, 股票代码, 股票名称, 所在地域, 所属行业, 股票全称, 市场类型 （主板/中小板/创业板）,上市状态： L上市 D退市 P暂停上市,上市日期
     */
    public JSONArray getStockCodeList() {
        JSONObject json = new JSONObject();
        //接口名称
        json.put("api_name", "stock_basic");
        //只取上市的
        json.put("params", JSON.parse("{'list_status':'L'}"));
        json.put("fields", "ts_code,symbol,name,area,industry,fullname,market,list_status,list_date");
        return post(json);
    }


    /**
     * 同花顺概念和行业指数
     *
     * @return
     */
    public JSONArray thsIndex() {
        JSONObject json = new JSONObject();
        //接口名称
        json.put("api_name", "ths_index");
        //只取上市的
        json.put("params", JSON.parse("{'exchange':'a'}"));
        json.put("fields", "ts_code,name,count,exchange,list_date,type");
        return post(json);
    }


    /**
     * status 传true 获取近十天数据
     * status 传false 获取全部数据
     * 同花顺概念和行业指数
     *
     * @return
     */
    public JSONArray thsDaily(String tsCode, Boolean status) {
        JSONObject json = new JSONObject();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("ts_code", tsCode);

        Date date = new Date();

        String endDate = "";
        String startDate = "";
        if (status) {
            endDate = DateUtil.format(date, DatePattern.PURE_DATE_PATTERN);
            date.setDate(date.getDate() - 10);
            startDate = DateUtil.format(date, DatePattern.PURE_DATE_PATTERN);
        }


        map.put("trade_date", "");
        map.put("start_date", startDate);
        map.put("end_date", endDate);
        map.put("limit", "");
        map.put("offset", "");

        //接口名称
        json.put("api_name", "ths_daily");
        //只取上市的
        json.put("params", JSON.parse(JSONObject.toJSONString(map)));
        json.put("fields", "ts_code,trade_date,close,open,high,low,pre_close,avg_price,change,pct_change,vol," +
                "turnover_rate,total_mv,float_mv,pe_ttm,pb_mrq");
        return post(json);
    }


    /**
     * 同花顺概念和行业指数成分
     *
     * @param tsCode
     * @return
     */
    public JSONArray thsMember(String tsCode) {
        JSONObject json = new JSONObject();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("ts_code", tsCode);
        map.put("limit", "");
        map.put("offset", "");

        //接口名称
        json.put("api_name", "ths_member");
        //只取上市的
        json.put("params", JSON.parse(JSONObject.toJSONString(map)));
        json.put("fields", "ts_code, code, name, weight, in_date, out_date, is_new");
        return post(json);
    }

    /**
     * 获取上海公司基础信息
     *
     * @return
     */
    public JSONArray getStockShCompany() {
        JSONObject json = new JSONObject();
        //接口名称
        json.put("api_name", "stock_company");
        json.put("params", JSON.parse("{'exchange':'SSE'}"));
        json.put("fields", "ts_code,chairman,manager,secretary,reg_capital,setup_date,province,city,introduction," +
                "website,email,office,employees,main_business,business_scope");
        return post(json);
    }

    /**
     * 获取深圳公司基础信息
     *
     * @return
     */
    public JSONArray getStockSZCompany() {
        JSONObject json = new JSONObject();
        //接口名称
        json.put("api_name", "stock_company");
        json.put("params", JSON.parse("{'exchange':'SZSE'}"));
        json.put("fields", "ts_code,chairman,manager,secretary,reg_capital,setup_date,province,city,introduction," +
                "website,email,office,employees,main_business,business_scope");
        return post(json);
    }

    /**
     * 得到前10大持有人
     *
     * @param code
     * @return
     */
    public JSONArray getStockTopHolders(String code) {
        JSONObject json = new JSONObject();
        //接口名称
        json.put("api_name", "top10_holders");
        json.put("params", JSON.parse(String.format("{'ts_code':'%s'}", code)));
        json.put("fields", "ts_code,ann_date,end_date,holder_name,hold_amount,hold_ratio");
        return post(json);
    }

    /**
     * 股东人数
     *
     * @param code       代码
     * @param start_date 开始日期
     * @param end_date   结束日期
     * @return
     */
    public JSONArray getStockHolderNumber(String code, String start_date, String end_date) {
        JSONObject json = new JSONObject();
        JSONObject params = new JSONObject();
        params.put("ts_code", code);
        params.put("start_date", start_date);
        params.put("end_date", end_date);
        //接口名称
        json.put("api_name", "stk_holdernumber");
        json.put("params", params);
        return post(json);
    }

    /**
     * 股票日线行情
     *
     * @param code       代码
     * @param start_date 开始日期
     * @param end_date   结束日期
     * @return
     */
    public JSONArray getStockDailyPrice(String code, String start_date, String end_date) {
        JSONObject json = new JSONObject();
        JSONObject params = new JSONObject();
        params.put("ts_code", TushareApi.formatCode(code));
        params.put("start_date", start_date);
        params.put("end_date", end_date);
        //接口名称
        json.put("api_name", "daily");
        json.put("params", params);
        return post(json);
    }


    /**
     * 股票日线行情
     *
     * @param code      代码
     * @param tradeDate 指定日期行情
     * @return
     */
    public StockDailyPriceDto getStockDailyPrice(String code, String tradeDate) {
        JSONObject json = new JSONObject();
        JSONObject params = new JSONObject();
        params.put("ts_code", TushareApi.formatCode(code));
        params.put("ts_code", tradeDate);
        //接口名称
        json.put("api_name", "daily");
        json.put("params", params);
        JSONArray jsonArray = post(json);

        if (!CollectionUtils.isEmpty(jsonArray)) {
            return new StockDailyPriceDto(jsonArray.getJSONArray(0));
        }

        return null;
    }

    /**
     * 每日指标基本面
     *
     * @param code       代码
     * @param start_date 开始日期
     * @param end_date   结束日期
     * @return
     */
    public JSONArray getStockDailyBasic(String code, String start_date, String end_date) {
        JSONObject json = new JSONObject();
        JSONObject params = new JSONObject();
        params.put("ts_code", code);
        params.put("start_date", start_date);
        params.put("end_date", end_date);
        //接口名称
        json.put("api_name", "daily_basic");
        json.put("params", params);
        return post(json);
    }

    /**
     * https://tushare.pro/document/2?doc_id=128
     *
     * @param date
     * @return
     */
    public JSONArray index_dailybasic(String date) {
        JSONObject json = new JSONObject();
        JSONObject params = new JSONObject();
        params.put("trade_date", date);
        //接口名称
        json.put("api_name", "index_dailybasic");
        json.put("params", params);
        json.put("fields", "ts_code,trade_date,turnover_rate,turnover_rate_f,pe,pe_ttm,pb");
        return post(json);
    }


    /**
     * @return 获取最近一个交易日期 （如果当天不是交易日，则获取上一个交易日）
     */
    public StockTradeDateEntity getTradeDate() {
        JSONObject json = new JSONObject();
        //接口名称
        json.put("api_name", "trade_cal");

        //接口参数

        JSONObject params = new JSONObject();
        params.put("cal_date", DatePattern.PURE_DATE_FORMAT.format(new Date()));


        json.put("params", params);
        //响应参数
        List<String> fields = new ArrayList<>();
        fields.add("exchange");
        fields.add("cal_date");
        fields.add("is_open");
        fields.add("pretrade_date");
        json.put("fields", fields);
        JSONArray jsonArray = post(json);
        if (CollectionUtils.isEmpty(jsonArray)) {
            return null;
        }
        return new StockTradeDateEntity(jsonArray.getJSONArray(0));
    }

}
