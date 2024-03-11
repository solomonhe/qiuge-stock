package com.qiuge.stock.openapi.xueqiu;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.qiuge.stock.openapi.bean.po.CodeDayInfoPo;
import com.qiuge.stock.openapi.bean.po.MaInfoPo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenguoxiang
 * @create 2019-11-13 11:21
 **/
@Slf4j
@Service("xueQiuApiService")
public class XueQiuApiServiceImpl implements XueQiuApiService {
    @Value("${xueqiu.token}:5c0d6fd4480ec8210fcef5ba952e8488f9ac0f6f")
    private String token;
    @Value("${xueqiu.cookie}")
    private String xueQiuCookie;

    private Map<String, String> cookie;



    @PostConstruct
    private void init() {
        this.cookie = new ConcurrentHashMap<>();
        this.cookie.put("xq_a_token", token);
    }

    @Override
    public synchronized List<MaInfoPo> getMaInfo(String code, String timeLevel, String size) {

        if (StringUtils.isBlank(code)) {
            return new ArrayList<>();
        }
        String urlPath = String.format(XueQiuUrlConstant.maInfoUrl, this.formatCode(code), System.currentTimeMillis()
                , timeLevel, "-" + size);
        try {
            JSONObject jsonObject = this.sendGet(urlPath);

            JSONObject json = (JSONObject) jsonObject.get("data");
            List<String> list = JSONArray.parseArray(json.get("item").toString(), String.class);

            List<MaInfoPo> maInfoPos = new ArrayList<>(list.size());

            for (String str : list) {
                MaInfoPo maInfoPo = new MaInfoPo(JSONArray.parseArray(str, String.class));
                maInfoPos.add(maInfoPo);
            }
            return maInfoPos;
        } catch (Exception e) {
            log.error("雪球获取均线MA 错误URL:{},错误股票CODE : {}", urlPath, code);
            log.error("雪球获取均线MA 错误", e);
        }
        return new ArrayList<>();
    }


    @Override
    public synchronized CodeDayInfoPo getCodeDayInfo(String code) {
        String urlPath = String.format(XueQiuUrlConstant.codeDayInfoUrl, this.formatCode(code));
        try {
            JSONObject jsonObject = this.sendGet(urlPath);
            JSONObject json = (JSONObject) jsonObject.get("data");
            Object quote = json.get("quote");
            CodeDayInfoPo codeDayInfoPo = JSONObject.parseObject(JSONObject.toJSONString(quote), CodeDayInfoPo.class);
            return codeDayInfoPo;
        } catch (Exception e) {
            log.error("雪球获取当天股票详情信息错误URL:{},错误信息:{}", urlPath, e.getMessage());
        }
        return null;
    }



//    @Override
//    public StockDayAvePrice getCodeDayAvgPrice(String code,Integer tradeDay) {
//        String urlPath = String.format(XueQiuUrlConstant.stockAvgPrice, this.formatCode(code));
//        try {
//            JSONObject jsonObject = this.sendGet(urlPath);
//            JSONObject json = (JSONObject) jsonObject.get("data");
//            Object quote = json.get("quote");
//            JSONObject quoteJson = JSONObject.parseObject(JSONObject.toJSONString(quote));
//
//
//            StockDayAvePrice entity = new StockDayAvePrice();
//            entity.setCode(quoteJson.get("code").toString());
//            entity.setName(quoteJson.get("name").toString());
//            entity.setVolume(Long.valueOf(quoteJson.get("volume").toString()));
//            entity.setAmount(new BigDecimal(quoteJson.get("amount").toString()));
//            entity.setOpenPrice(new BigDecimal(quoteJson.get("open").toString()));
//            entity.setEndPrice(new BigDecimal(quoteJson.get("current").toString()));
//            entity.setAvgPrice(new BigDecimal(quoteJson.get("avg_price").toString()));
//            entity.setDayDate(tradeDay);
//            entity.setContext(json.toJSONString());
//            entity.setCreateTime(new Date());
//            return entity;
//        } catch (Exception e) {
//            log.error("雪球获取当天股票均价信息URL:{},错误信息:{}", urlPath, e.getMessage());
//        }
//        return null;
//    }


    private JSONObject sendGet(String urlPath) throws Exception {
        URL url = new URL(urlPath);
        URLConnection conn = null;

        conn = url.openConnection();
        conn.setRequestProperty("Cookie", xueQiuCookie);
        conn.setDoInput(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        if (StringUtils.isBlank(sb))
            return null;
        return JSONObject.parseObject(sb.toString());
    }


    /**
     * 转换雪球股票代码CODE特有格式
     *
     * @param code
     * @return
     */
    private String formatCode(String code) {
        //5开头，沪市基金或权证 60开头上证
        if (code.matches("^6.*|^5.*|^7.*")) {
            return String.format("SH%s", code);
        }
        //1开头的，是深市基金 00开头是深圳
        else if (code.matches("^1.*|^00.*|^3.*")) {
            return String.format("SZ%s", code);
        } else if (code.matches("^8.*|^4.*")) {
            return String.format("BJ%s", code);
        }
        return null;
    }

}
