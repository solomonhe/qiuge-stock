package com.qiuge.stock.service;

import java.util.List;
import com.qiuge.stock.domain.StockTradeDate;

/**
 * 上交所/深交所交易日期Service接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface IStockTradeDateService 
{
    /**
     * 查询上交所/深交所交易日期
     * 
     * @param id 上交所/深交所交易日期主键
     * @return 上交所/深交所交易日期
     */
    public StockTradeDate selectStockTradeDateById(String id);

    /**
     * 查询上交所/深交所交易日期列表
     * 
     * @param stockTradeDate 上交所/深交所交易日期
     * @return 上交所/深交所交易日期集合
     */
    public List<StockTradeDate> selectStockTradeDateList(StockTradeDate stockTradeDate);

    /**
     * 新增上交所/深交所交易日期
     * 
     * @param stockTradeDate 上交所/深交所交易日期
     * @return 结果
     */
    public int insertStockTradeDate(StockTradeDate stockTradeDate);

    /**
     * 修改上交所/深交所交易日期
     * 
     * @param stockTradeDate 上交所/深交所交易日期
     * @return 结果
     */
    public int updateStockTradeDate(StockTradeDate stockTradeDate);

    /**
     * 批量删除上交所/深交所交易日期
     * 
     * @param ids 需要删除的上交所/深交所交易日期主键集合
     * @return 结果
     */
    public int deleteStockTradeDateByIds(String[] ids);

    /**
     * 删除上交所/深交所交易日期信息
     * 
     * @param id 上交所/深交所交易日期主键
     * @return 结果
     */
    public int deleteStockTradeDateById(String id);
}
