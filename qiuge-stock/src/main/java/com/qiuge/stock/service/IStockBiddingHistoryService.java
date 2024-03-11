package com.qiuge.stock.service;

import java.util.List;
import com.qiuge.stock.domain.StockBiddingHistory;

/**
 * 竞价历史Service接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface IStockBiddingHistoryService 
{
    /**
     * 查询竞价历史
     * 
     * @param id 竞价历史主键
     * @return 竞价历史
     */
    public StockBiddingHistory selectStockBiddingHistoryById(String id);

    /**
     * 查询竞价历史列表
     * 
     * @param stockBiddingHistory 竞价历史
     * @return 竞价历史集合
     */
    public List<StockBiddingHistory> selectStockBiddingHistoryList(StockBiddingHistory stockBiddingHistory);

    /**
     * 新增竞价历史
     * 
     * @param stockBiddingHistory 竞价历史
     * @return 结果
     */
    public int insertStockBiddingHistory(StockBiddingHistory stockBiddingHistory);

    /**
     * 修改竞价历史
     * 
     * @param stockBiddingHistory 竞价历史
     * @return 结果
     */
    public int updateStockBiddingHistory(StockBiddingHistory stockBiddingHistory);

    /**
     * 批量删除竞价历史
     * 
     * @param ids 需要删除的竞价历史主键集合
     * @return 结果
     */
    public int deleteStockBiddingHistoryByIds(String[] ids);

    /**
     * 删除竞价历史信息
     * 
     * @param id 竞价历史主键
     * @return 结果
     */
    public int deleteStockBiddingHistoryById(String id);
}
