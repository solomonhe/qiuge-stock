package com.ruoyi.stock.openapi.sina.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qiuge.entity.stock.StockTradeDayAverageEntity;
import com.qiuge.stock.util.Md5Util;
import com.qiuge.stock.util.math.NumberConverter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2023</p>
 * @date: 2023-04-01 15:13
 * @version: 1.0
 **/

@Slf4j
@Data
public class SinaStockPriceDto {
    /**
     * 代码加市场
     */
    private String symbol;

    private Integer code;
    private String name;

    /**
     * 当前价
     */
    private BigDecimal trade;

    /**
     * 涨跌额
     */
    private BigDecimal pricechange;

    /**
     * 涨跌幅
     */
    private BigDecimal changepercent;

    /**
     * 开票价
     */
    private BigDecimal open;

    /**
     * 成交量/手
     */
    private Long volume;

    /**
     * 成交额/元
     */
    private Long amount;


    @JsonIgnore
    public static List<StockTradeDayAverageEntity> convert(List<SinaStockPriceDto> stockPriceDtoList, Long tradeDate) {

        log.info("stockPriceDtoList size :{}", stockPriceDtoList.size());
        List<StockTradeDayAverageEntity> averageEntityList = new ArrayList<>(stockPriceDtoList.size());
        stockPriceDtoList.stream().forEach(sinaStockPriceDto -> {
            StockTradeDayAverageEntity stockTradeDayInfo = new StockTradeDayAverageEntity();
            stockTradeDayInfo.setStockTsCode(sinaStockPriceDto.getSymbol());
            stockTradeDayInfo.setStockName(sinaStockPriceDto.getName());
            stockTradeDayInfo.setStockCode(String.valueOf(sinaStockPriceDto.getCode()));
            stockTradeDayInfo.setTradeDate(tradeDate);
            stockTradeDayInfo.setPriceOpen(sinaStockPriceDto.getOpen());
            stockTradeDayInfo.setPriceChange(sinaStockPriceDto.getPricechange());
            stockTradeDayInfo.setPctChg(sinaStockPriceDto.getChangepercent());
            stockTradeDayInfo.setStockVol(sinaStockPriceDto.getVolume());
            stockTradeDayInfo.setStockVolNum(NumberConverter.convertToUnits(sinaStockPriceDto.getVolume()));
            stockTradeDayInfo.setStockAmount(new BigDecimal(sinaStockPriceDto.getAmount()));
            stockTradeDayInfo.setStockAmountNum(NumberConverter.convertToUnits(sinaStockPriceDto.getAmount()));
            stockTradeDayInfo.setCreateTime(new Date());

            String id = Md5Util.getMD5(stockTradeDayInfo.getStockCode() + tradeDate);
            stockTradeDayInfo.setId(id);
            averageEntityList.add(stockTradeDayInfo);
        });
        return averageEntityList;
    }


}
