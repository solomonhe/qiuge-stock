package com.ruoyi.stock.openapi.sina;

import com.qiuge.stock.openapi.sina.dto.SinaStockPriceDto;

import java.util.List;

public interface SinaService {

    /**
     * 查询A股当前行情数据
     * @param stockTotal 股票总数
     * @return
     */
    List<SinaStockPriceDto> getStockPrice(Integer stockTotal);

}
