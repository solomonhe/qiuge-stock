package com.qiuge.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.StockTradeDayAverageMapper;
import com.qiuge.stock.domain.StockTradeDayAverage;
import com.qiuge.stock.service.IStockTradeDayAverageService;

/**
 * A股股票每日均价成交Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class StockTradeDayAverageServiceImpl implements IStockTradeDayAverageService 
{
    @Autowired
    private StockTradeDayAverageMapper stockTradeDayAverageMapper;

    /**
     * 查询A股股票每日均价成交
     * 
     * @param id A股股票每日均价成交主键
     * @return A股股票每日均价成交
     */
    @Override
    public StockTradeDayAverage selectStockTradeDayAverageById(String id)
    {
        return stockTradeDayAverageMapper.selectStockTradeDayAverageById(id);
    }

    /**
     * 查询A股股票每日均价成交列表
     * 
     * @param stockTradeDayAverage A股股票每日均价成交
     * @return A股股票每日均价成交
     */
    @Override
    public List<StockTradeDayAverage> selectStockTradeDayAverageList(StockTradeDayAverage stockTradeDayAverage)
    {
        return stockTradeDayAverageMapper.selectStockTradeDayAverageList(stockTradeDayAverage);
    }

    /**
     * 新增A股股票每日均价成交
     * 
     * @param stockTradeDayAverage A股股票每日均价成交
     * @return 结果
     */
    @Override
    public int insertStockTradeDayAverage(StockTradeDayAverage stockTradeDayAverage)
    {
        stockTradeDayAverage.setCreateTime(DateUtils.getNowDate());
        return stockTradeDayAverageMapper.insertStockTradeDayAverage(stockTradeDayAverage);
    }

    /**
     * 修改A股股票每日均价成交
     * 
     * @param stockTradeDayAverage A股股票每日均价成交
     * @return 结果
     */
    @Override
    public int updateStockTradeDayAverage(StockTradeDayAverage stockTradeDayAverage)
    {
        return stockTradeDayAverageMapper.updateStockTradeDayAverage(stockTradeDayAverage);
    }

    /**
     * 批量删除A股股票每日均价成交
     * 
     * @param ids 需要删除的A股股票每日均价成交主键
     * @return 结果
     */
    @Override
    public int deleteStockTradeDayAverageByIds(String[] ids)
    {
        return stockTradeDayAverageMapper.deleteStockTradeDayAverageByIds(ids);
    }

    /**
     * 删除A股股票每日均价成交信息
     * 
     * @param id A股股票每日均价成交主键
     * @return 结果
     */
    @Override
    public int deleteStockTradeDayAverageById(String id)
    {
        return stockTradeDayAverageMapper.deleteStockTradeDayAverageById(id);
    }
}
