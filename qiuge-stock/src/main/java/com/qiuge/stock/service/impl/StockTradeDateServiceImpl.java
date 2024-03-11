package com.qiuge.stock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.StockTradeDateMapper;
import com.qiuge.stock.domain.StockTradeDate;
import com.qiuge.stock.service.IStockTradeDateService;

/**
 * 上交所/深交所交易日期Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class StockTradeDateServiceImpl implements IStockTradeDateService 
{
    @Autowired
    private StockTradeDateMapper stockTradeDateMapper;

    /**
     * 查询上交所/深交所交易日期
     * 
     * @param id 上交所/深交所交易日期主键
     * @return 上交所/深交所交易日期
     */
    @Override
    public StockTradeDate selectStockTradeDateById(String id)
    {
        return stockTradeDateMapper.selectStockTradeDateById(id);
    }

    /**
     * 查询上交所/深交所交易日期列表
     * 
     * @param stockTradeDate 上交所/深交所交易日期
     * @return 上交所/深交所交易日期
     */
    @Override
    public List<StockTradeDate> selectStockTradeDateList(StockTradeDate stockTradeDate)
    {
        return stockTradeDateMapper.selectStockTradeDateList(stockTradeDate);
    }

    /**
     * 新增上交所/深交所交易日期
     * 
     * @param stockTradeDate 上交所/深交所交易日期
     * @return 结果
     */
    @Override
    public int insertStockTradeDate(StockTradeDate stockTradeDate)
    {
        return stockTradeDateMapper.insertStockTradeDate(stockTradeDate);
    }

    /**
     * 修改上交所/深交所交易日期
     * 
     * @param stockTradeDate 上交所/深交所交易日期
     * @return 结果
     */
    @Override
    public int updateStockTradeDate(StockTradeDate stockTradeDate)
    {
        return stockTradeDateMapper.updateStockTradeDate(stockTradeDate);
    }

    /**
     * 批量删除上交所/深交所交易日期
     * 
     * @param ids 需要删除的上交所/深交所交易日期主键
     * @return 结果
     */
    @Override
    public int deleteStockTradeDateByIds(String[] ids)
    {
        return stockTradeDateMapper.deleteStockTradeDateByIds(ids);
    }

    /**
     * 删除上交所/深交所交易日期信息
     * 
     * @param id 上交所/深交所交易日期主键
     * @return 结果
     */
    @Override
    public int deleteStockTradeDateById(String id)
    {
        return stockTradeDateMapper.deleteStockTradeDateById(id);
    }
}
