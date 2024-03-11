package com.qiuge.stock.service;

import java.util.List;
import com.qiuge.stock.domain.StockStrategyCodeInfo;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface IStockStrategyCodeInfoService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public StockStrategyCodeInfo selectStockStrategyCodeInfoById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param stockStrategyCodeInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<StockStrategyCodeInfo> selectStockStrategyCodeInfoList(StockStrategyCodeInfo stockStrategyCodeInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param stockStrategyCodeInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertStockStrategyCodeInfo(StockStrategyCodeInfo stockStrategyCodeInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param stockStrategyCodeInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateStockStrategyCodeInfo(StockStrategyCodeInfo stockStrategyCodeInfo);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteStockStrategyCodeInfoByIds(String[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteStockStrategyCodeInfoById(String id);
}
