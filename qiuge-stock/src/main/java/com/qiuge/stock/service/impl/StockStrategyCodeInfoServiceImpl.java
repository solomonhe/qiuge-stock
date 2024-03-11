package com.qiuge.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.StockStrategyCodeInfoMapper;
import com.qiuge.stock.domain.StockStrategyCodeInfo;
import com.qiuge.stock.service.IStockStrategyCodeInfoService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class StockStrategyCodeInfoServiceImpl implements IStockStrategyCodeInfoService 
{
    @Autowired
    private StockStrategyCodeInfoMapper stockStrategyCodeInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public StockStrategyCodeInfo selectStockStrategyCodeInfoById(String id)
    {
        return stockStrategyCodeInfoMapper.selectStockStrategyCodeInfoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param stockStrategyCodeInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<StockStrategyCodeInfo> selectStockStrategyCodeInfoList(StockStrategyCodeInfo stockStrategyCodeInfo)
    {
        return stockStrategyCodeInfoMapper.selectStockStrategyCodeInfoList(stockStrategyCodeInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param stockStrategyCodeInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertStockStrategyCodeInfo(StockStrategyCodeInfo stockStrategyCodeInfo)
    {
        stockStrategyCodeInfo.setCreateTime(DateUtils.getNowDate());
        return stockStrategyCodeInfoMapper.insertStockStrategyCodeInfo(stockStrategyCodeInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param stockStrategyCodeInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateStockStrategyCodeInfo(StockStrategyCodeInfo stockStrategyCodeInfo)
    {
        return stockStrategyCodeInfoMapper.updateStockStrategyCodeInfo(stockStrategyCodeInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteStockStrategyCodeInfoByIds(String[] ids)
    {
        return stockStrategyCodeInfoMapper.deleteStockStrategyCodeInfoByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteStockStrategyCodeInfoById(String id)
    {
        return stockStrategyCodeInfoMapper.deleteStockStrategyCodeInfoById(id);
    }
}
