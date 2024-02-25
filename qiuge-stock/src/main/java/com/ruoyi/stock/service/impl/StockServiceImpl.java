package com.ruoyi.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stock.mapper.StockMapper;
import com.ruoyi.stock.domain.Stock;
import com.ruoyi.stock.service.IStockService;

/**
 * 股票列表Service业务层处理
 * 
 * @author solomon
 * @date 2024-02-24
 */
@Service
public class StockServiceImpl implements IStockService 
{
    @Autowired
    private StockMapper stockMapper;

    /**
     * 查询股票列表
     * 
     * @param id 股票列表主键
     * @return 股票列表
     */
    @Override
    public Stock selectStockById(String id)
    {
        return stockMapper.selectStockById(id);
    }

    /**
     * 查询股票列表列表
     * 
     * @param stock 股票列表
     * @return 股票列表
     */
    @Override
    public List<Stock> selectStockList(Stock stock)
    {
        return stockMapper.selectStockList(stock);
    }

    /**
     * 新增股票列表
     * 
     * @param stock 股票列表
     * @return 结果
     */
    @Override
    public int insertStock(Stock stock)
    {
        stock.setCreateTime(DateUtils.getNowDate());
        return stockMapper.insertStock(stock);
    }

    /**
     * 修改股票列表
     * 
     * @param stock 股票列表
     * @return 结果
     */
    @Override
    public int updateStock(Stock stock)
    {
        stock.setUpdateTime(DateUtils.getNowDate());
        return stockMapper.updateStock(stock);
    }

    /**
     * 批量删除股票列表
     * 
     * @param ids 需要删除的股票列表主键
     * @return 结果
     */
    @Override
    public int deleteStockByIds(String[] ids)
    {
        return stockMapper.deleteStockByIds(ids);
    }

    /**
     * 删除股票列表信息
     * 
     * @param id 股票列表主键
     * @return 结果
     */
    @Override
    public int deleteStockById(String id)
    {
        return stockMapper.deleteStockById(id);
    }
}
