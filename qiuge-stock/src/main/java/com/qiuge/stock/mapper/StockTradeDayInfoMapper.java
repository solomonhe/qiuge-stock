package com.qiuge.stock.mapper;

import com.qiuge.stock.domain.StockTradeDayInfo;

import java.util.List;

/**
 * A股股票交易信息Mapper接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface StockTradeDayInfoMapper 
{
    /**
     * 查询A股股票交易信息
     * 
     * @param id A股股票交易信息主键
     * @return A股股票交易信息
     */
    public StockTradeDayInfo selectStockTradeDayInfoById(String id);

    /**
     * 查询A股股票交易信息列表
     * 
     * @param stockTradeDayInfo A股股票交易信息
     * @return A股股票交易信息集合
     */
    public List<StockTradeDayInfo> selectStockTradeDayInfoList(StockTradeDayInfo stockTradeDayInfo);

    /**
     * 新增A股股票交易信息
     * 
     * @param stockTradeDayInfo A股股票交易信息
     * @return 结果
     */
    public int insertStockTradeDayInfo(StockTradeDayInfo stockTradeDayInfo);

    /**
     * 修改A股股票交易信息
     * 
     * @param stockTradeDayInfo A股股票交易信息
     * @return 结果
     */
    public int updateStockTradeDayInfo(StockTradeDayInfo stockTradeDayInfo);

    /**
     * 删除A股股票交易信息
     * 
     * @param id A股股票交易信息主键
     * @return 结果
     */
    public int deleteStockTradeDayInfoById(String id);

    /**
     * 批量删除A股股票交易信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStockTradeDayInfoByIds(String[] ids);
}
