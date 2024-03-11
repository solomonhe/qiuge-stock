package com.qiuge.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.StockBiddingHistoryMapper;
import com.qiuge.stock.domain.StockBiddingHistory;
import com.qiuge.stock.service.IStockBiddingHistoryService;

/**
 * 竞价历史Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class StockBiddingHistoryServiceImpl implements IStockBiddingHistoryService 
{
    @Autowired
    private StockBiddingHistoryMapper stockBiddingHistoryMapper;

    /**
     * 查询竞价历史
     * 
     * @param id 竞价历史主键
     * @return 竞价历史
     */
    @Override
    public StockBiddingHistory selectStockBiddingHistoryById(String id)
    {
        return stockBiddingHistoryMapper.selectStockBiddingHistoryById(id);
    }

    /**
     * 查询竞价历史列表
     * 
     * @param stockBiddingHistory 竞价历史
     * @return 竞价历史
     */
    @Override
    public List<StockBiddingHistory> selectStockBiddingHistoryList(StockBiddingHistory stockBiddingHistory)
    {
        return stockBiddingHistoryMapper.selectStockBiddingHistoryList(stockBiddingHistory);
    }

    /**
     * 新增竞价历史
     * 
     * @param stockBiddingHistory 竞价历史
     * @return 结果
     */
    @Override
    public int insertStockBiddingHistory(StockBiddingHistory stockBiddingHistory)
    {
        stockBiddingHistory.setCreateTime(DateUtils.getNowDate());
        return stockBiddingHistoryMapper.insertStockBiddingHistory(stockBiddingHistory);
    }

    /**
     * 修改竞价历史
     * 
     * @param stockBiddingHistory 竞价历史
     * @return 结果
     */
    @Override
    public int updateStockBiddingHistory(StockBiddingHistory stockBiddingHistory)
    {
        return stockBiddingHistoryMapper.updateStockBiddingHistory(stockBiddingHistory);
    }

    /**
     * 批量删除竞价历史
     * 
     * @param ids 需要删除的竞价历史主键
     * @return 结果
     */
    @Override
    public int deleteStockBiddingHistoryByIds(String[] ids)
    {
        return stockBiddingHistoryMapper.deleteStockBiddingHistoryByIds(ids);
    }

    /**
     * 删除竞价历史信息
     * 
     * @param id 竞价历史主键
     * @return 结果
     */
    @Override
    public int deleteStockBiddingHistoryById(String id)
    {
        return stockBiddingHistoryMapper.deleteStockBiddingHistoryById(id);
    }
}
