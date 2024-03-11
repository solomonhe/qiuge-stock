package com.qiuge.stock.service;

import java.util.List;
import com.qiuge.stock.domain.StockTradeDayAverage;

/**
 * A股股票每日均价成交Service接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface IStockTradeDayAverageService 
{
    /**
     * 查询A股股票每日均价成交
     * 
     * @param id A股股票每日均价成交主键
     * @return A股股票每日均价成交
     */
    public StockTradeDayAverage selectStockTradeDayAverageById(String id);

    /**
     * 查询A股股票每日均价成交列表
     * 
     * @param stockTradeDayAverage A股股票每日均价成交
     * @return A股股票每日均价成交集合
     */
    public List<StockTradeDayAverage> selectStockTradeDayAverageList(StockTradeDayAverage stockTradeDayAverage);

    /**
     * 新增A股股票每日均价成交
     * 
     * @param stockTradeDayAverage A股股票每日均价成交
     * @return 结果
     */
    public int insertStockTradeDayAverage(StockTradeDayAverage stockTradeDayAverage);

    /**
     * 修改A股股票每日均价成交
     * 
     * @param stockTradeDayAverage A股股票每日均价成交
     * @return 结果
     */
    public int updateStockTradeDayAverage(StockTradeDayAverage stockTradeDayAverage);

    /**
     * 批量删除A股股票每日均价成交
     * 
     * @param ids 需要删除的A股股票每日均价成交主键集合
     * @return 结果
     */
    public int deleteStockTradeDayAverageByIds(String[] ids);

    /**
     * 删除A股股票每日均价成交信息
     * 
     * @param id A股股票每日均价成交主键
     * @return 结果
     */
    public int deleteStockTradeDayAverageById(String id);
}
