package com.ruoyi.stock.openapi.tushare;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2023</p>
 * @date: 2023-03-22 23:27
 * @version: 1.0
 **/
@Slf4j
@Component
public class TushareBaseApi {

    @Resource
    private RestTemplate restTemplate;

    @Value("${tushare.token}")
    private String tuToken = "66cdab7a757dcb728f8833f732a928791d67b6f38e1cd8d94bb79a0d";


    private final String api = "http://api.tushare.pro";

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
    public JSONArray post(JSONObject params) {
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

}
