package com.qiuge.stock.openapi.sina;

import com.alibaba.fastjson2.JSONArray;
import com.qiuge.stock.openapi.sina.dto.SinaStockPriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.qiuge.stock.openapi.sina.SinaUrlConstant.STOCK_REAL_TIME;

/**
 * @description:
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2023</p>
 * @date: 2023-04-01 14:38
 * @version: 1.0
 **/

@Slf4j
@Service
public class SinaServiceImpl implements SinaService {

    @Resource
    private RestTemplate restTemplate;
    
    @Override
    public List<SinaStockPriceDto> getStockPrice(Integer stockTotal) {
        log.info("股票size ：{}",stockTotal);

        List<SinaStockPriceDto> stockPriceList = new ArrayList<>();
        //得出当前总页数
        int totalPage = stockTotal / 80 + 1;

        for (int i = 1; i < totalPage; i++) {
            log.info("请求页码：{}",i);
            try {
                Integer sleep = 1000;
                log.info("线程暂停：{}s",sleep);
                Thread.sleep(1000);
                log.info("线程暂停完成");
                String url = String.format(STOCK_REAL_TIME, i);
                log.info("请求新浪股票实时行情 URL:{}",url);
                ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
                String body = forEntity.getBody();
                List<SinaStockPriceDto> sinaStockPriceDtoList = JSONArray.parseArray(body, SinaStockPriceDto.class);
                stockPriceList.addAll(sinaStockPriceDtoList);
            } catch (Exception e) {
               log.error("新浪获取实时股票行情出错：{}",e);
            }
        }
        return stockPriceList;
    }
}
