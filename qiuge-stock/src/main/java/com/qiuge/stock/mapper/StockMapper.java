package com.qiuge.stock.mapper;

import java.util.List;

import com.qiuge.stock.domain.Stock;

/**
 * 股票列表Mapper接口
 * 
 * @author solomon
 * @date 2024-03-11
 */
public interface StockMapper 
{
    /**
     * 查询股票列表
     * 
     * @param id 股票列表主键
     * @return 股票列表
     */
    public Stock selectStockById(String id);

    /**
     * 查询股票列表列表
     * 
     * @param stock 股票列表
     * @return 股票列表集合
     */
    public List<Stock> selectStockList(Stock stock);

    /**
     * 新增股票列表
     * 
     * @param stock 股票列表
     * @return 结果
     */
    public int insertStock(Stock stock);

    /**
     * 修改股票列表
     * 
     * @param stock 股票列表
     * @return 结果
     */
    public int updateStock(Stock stock);

    /**
     * 删除股票列表
     * 
     * @param id 股票列表主键
     * @return 结果
     */
    public int deleteStockById(String id);

    /**
     * 批量删除股票列表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStockByIds(String[] ids);
}
