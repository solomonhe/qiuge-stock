package com.ruoyi.stock.openapi.xueqiu;

import com.qiuge.entity.stock.StockDayAvePriceEntity;
import com.qiuge.stock.openapi.bean.po.CodeDayInfoPo;
import com.qiuge.stock.openapi.bean.po.MaInfoPo;

import java.util.List;

/**
 * @Classname： XueQiuApiService
 * @Description： TODO
 * @Date： 2023/2/24 17:51
 * @Author： by QiuGe
 */
public interface XueQiuApiService {

    /**
     * 获取股票均线信息
     *
     * @param code      股票代码
     * @param timeLevel 均线时间单位
     * @param size
     * @return
     */
    List<MaInfoPo> getMaInfo(String code, String timeLevel, String size);

    /**
     * 获取股票价格信息
     *
     * @param code 股票代码
     * @return
     */
    CodeDayInfoPo getCodeDayInfo(String code);


    /**
     * 获取股票每日成交均价
     *
     * @param code 股票代码
     * @return
     */
    StockDayAvePriceEntity getCodeDayAvgPrice(String code,Integer tradeDay);

}
