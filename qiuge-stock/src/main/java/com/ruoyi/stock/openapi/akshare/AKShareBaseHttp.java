package com.ruoyi.stock.openapi.akshare;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.stock.openapi.akshare.bean.TreadDate;
import com.ruoyi.stock.openapi.akshare.constant.InterfaceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description:
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2024</p>
 * @date: 2024-01-14 14:26
 * @version: 1.0
 **/

@Slf4j
@Component
public class AKShareBaseHttp {
    @Value("${akShare.url}")
    private String baseUrl;
    @Autowired
    private RestTemplate restTemplate;

    public List<TreadDate> treadDataA() {
        Object body = this.get(InterfaceEnum.TOOL_TRADE_DATE_HIST_SINA);
        return JSONArray.parseArray(JSONObject.toJSONString(body), TreadDate.class);
    }


    private Object get(InterfaceEnum interfaceEnum) {
        String url = this.getInterfaceUrl(baseUrl, interfaceEnum.getUrl());
        ResponseEntity<List> res = restTemplate.getForEntity(url, List.class);
        if (HttpStatus.OK.value() != res.getStatusCodeValue()) {
            log.error("akShare请求【{}】接口出错,请求URL:{},错误信息:{}", interfaceEnum.getUrlDoc(), url, res.getBody());
        }
        return res.getBody();
    }

    private String getInterfaceUrl(String baseUrl, String interfaceUrl) {
        return baseUrl + interfaceUrl;
    }
}
