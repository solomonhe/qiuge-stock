package com.ruoyi.stock.openapi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

/**
 * 新浪财经
 * SinaUtil
 *
 * @author Solomon
 * @date 2021/09/08
 */
@Service
@Slf4j
public class SinaUtil {

    /**
     * 新浪数据左导航栏接口,包括概念热门行业 申万行业
     * 申万行业
     */
    private final static String SW_TRADE_URL = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodes";

    /**
     * 获取申万行业下面所属股票
     * 第一条是模板
     * 第二条 插入请求多少页，具体请求那个行业
     * <p>
     * 模板  http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?page=2&num=80&sort=symbol&asc=1&node=sw3_730202&symbol=&_s_r_a=page
     */
    private final static String SW_TRADE_CODE_URL = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?page=%s&num=80&sort=symbol&asc=1&node=%s&symbol=&_s_r_a=page";


    /**
     * plate = sw1 申万一级行业
     * plate = sw2 申万二级行业
     * plate = sw3 申万三级行业
     * <p>
     * 新浪app端行业数据
     * <p>
     * 模板  https://quotes.sina.cn/hq/api/openapi.php/StockV2Service.getPlateList?page=1&num=20&dpc=1&source=app&plate=sw1
     */
    private final static String SW_APP_TRADE_URL = "https://quotes.sina.cn/hq/api/openapi.php/StockV2Service.getPlateList?page=%s&num=80&dpc=1&source=app&plate=%s";


    /**
     * 新浪app端行业+股票 日行情 数据
     * <p>
     * 模板  https://quotes.sina.cn/moneyflow/api/openapi.php/Lv2_Service.getCateKHistory?period=day&vtype=isymbol&len=3000&asc=0&cate=%s
     */
    private final static String SW_APP_TRADE_PRICE_URL = "https://quotes.sina.cn/moneyflow/api/openapi.php/Lv2_Service.getCateKHistory?period=day&vtype=isymbol&len=3000&asc=0&cate=%s";


    /**
     * 新浪app端行业+股票 分钟行情 数据
     * <p>
     * 模板  https://quotes.sina.cn/moneyflow/api/openapi.php/Lv2_Service.getCateKHistory?period=day&vtype=isymbol&len=3000&asc=0&cate=%s
     */
    private final static String SW_APP_TRADE_PRICE_MINUTE_URL = "https://quotes.sina.cn/cn/api/openapi.php/CN_MinlineService.getMinlineData?symbol=%s&first_opentime=true";


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 新浪数据左导航栏接口,包括概念热门行业 申万行业
     *
     * @return
     */
    public synchronized JSONArray getSwTrade() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(SW_TRADE_URL, String.class);
        String body = forEntity.getBody();
        return JSONArray.parseArray(body);
    }

    /**
     * 获取申万行业相关股票
     *
     * @return
     */
    public synchronized JSONArray getSwTradeCode(String swCode, Integer page) {

        String url = String.format(SW_TRADE_CODE_URL, page, swCode);
        ResponseEntity<String> forEntity = null;
        JSONArray jsonArray = new JSONArray();
        try {
            this.wait(3000);
            forEntity = restTemplate.getForEntity(url, String.class);
            String body = forEntity.getBody();
            jsonArray = JSONArray.parseArray(body);
        } catch (UnknownHttpStatusCodeException e) {
            try {
                log.info("获取申万行业相关股票被封IP");
                this.wait(60000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        } catch (Exception e) {

            log.info("获取申万行业相关股票URL：{}, 错误 ：{}", url, e);
        }

        if (jsonArray.size() < 0) {
            return JSONArray.parseArray(JSONObject.toJSONString(jsonArray.get(0)));
        }
        return jsonArray;
    }

    public JSONArray getSwAppTrade(String nameType, Integer page) {
        String url = String.format(SW_APP_TRADE_URL, page, nameType);
        try {
            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            String body = forEntity.getBody();
            Object result = JSONObject.parseObject(body).get("result");
            String data1 = JSONObject.parseObject(JSONObject.toJSONString(result)).get("data").toString();
            String data2 = JSONObject.parseObject(data1).get("data").toString();
            JSONArray jsonArray = JSONArray.parseArray(data2);
            if (jsonArray.size() < 0) {
                return JSONArray.parseArray(JSONObject.toJSONString(""));
            }
            return jsonArray;
        } catch (Exception e) {
            log.error("getSwAppTrade  新浪获取APP行业下属股票出错 : {}", e);
        }
        return null;
    }


    /**
     * 新浪app端行业+股票 日行情数据
     *
     * @param code
     * @return
     */
    @SneakyThrows
    public JSONArray getSwAppTradePrice(String code) {
        String url = String.format(SW_APP_TRADE_PRICE_URL, code);
        try {
            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            String body = forEntity.getBody();
            Object result = JSONObject.parseObject(body).get("result");
            String data1 = JSONObject.parseObject(JSONObject.toJSONString(result)).get("data").toString();
            String data2 = JSONObject.parseObject(data1).get("data").toString();
            JSONArray jsonArray = JSONArray.parseArray(data2);
            if (jsonArray.size() < 0) {
                return JSONArray.parseArray(JSONObject.toJSONString(""));
            }
            return jsonArray;
        } catch (UnknownHttpStatusCodeException e) {
            log.error("新浪app端行业+股票 日行情数据 HttpStatus出错 : {}", e);
            Thread.sleep(300000);
        } catch (Exception e) {
            log.error("getSwAppTrade  新浪app端行业+股票 日行情数据 : {}", e);
        }
        return new JSONArray();
    }


    /**
     * 新浪app端行业+股票 分钟行情 数据
     *
     * @param code
     * @return
     */
    public JSONArray getSwAppTradeMinutePrice(String code) {
        String url = String.format(SW_APP_TRADE_PRICE_MINUTE_URL, code);
        try {
            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            String body = forEntity.getBody();
            Object result = JSONObject.parseObject(body).get("result");
            String data1 = JSONObject.parseObject(JSONObject.toJSONString(result)).get("data").toString();
            JSONArray jsonArray = JSONArray.parseArray(data1);
            if (jsonArray.size() < 0) {
                return JSONArray.parseArray(JSONObject.toJSONString(""));
            }
            return jsonArray;
        } catch (Exception e) {
            log.error("getSwAppTradeMinutePrice  新浪app端行业+股票 分钟行情 数据 : {}", e);
        }
        return null;
    }
}
