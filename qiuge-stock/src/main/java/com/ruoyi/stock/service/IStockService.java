package com.ruoyi.stock.service;

import java.util.List;
import com.ruoyi.stock.domain.Stock;

/**
 * 股票列表Service接口
 * 
 * @author solomon
 * @date 2024-02-24
 */
public interface IStockService 
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
     * 批量删除股票列表
     * 
     * @param ids 需要删除的股票列表主键集合
     * @return 结果
     */
    public int deleteStockByIds(String[] ids);

    /**
     * 删除股票列表信息
     * 
     * @param id 股票列表主键
     * @return 结果
     */
    public int deleteStockById(String id);
}
