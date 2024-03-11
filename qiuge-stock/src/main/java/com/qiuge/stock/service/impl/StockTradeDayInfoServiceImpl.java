package com.qiuge.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.StockTradeDayInfoMapper;
import com.qiuge.stock.domain.StockTradeDayInfo;
import com.qiuge.stock.service.IStockTradeDayInfoService;

/**
 * A股股票交易信息Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class StockTradeDayInfoServiceImpl implements IStockTradeDayInfoService 
{
    @Autowired
    private StockTradeDayInfoMapper stockTradeDayInfoMapper;

    /**
     * 查询A股股票交易信息
     * 
     * @param id A股股票交易信息主键
     * @return A股股票交易信息
     */
    @Override
    public StockTradeDayInfo selectStockTradeDayInfoById(String id)
    {
        return stockTradeDayInfoMapper.selectStockTradeDayInfoById(id);
    }

    /**
     * 查询A股股票交易信息列表
     * 
     * @param stockTradeDayInfo A股股票交易信息
     * @return A股股票交易信息
     */
    @Override
    public List<StockTradeDayInfo> selectStockTradeDayInfoList(StockTradeDayInfo stockTradeDayInfo)
    {
        return stockTradeDayInfoMapper.selectStockTradeDayInfoList(stockTradeDayInfo);
    }

    /**
     * 新增A股股票交易信息
     * 
     * @param stockTradeDayInfo A股股票交易信息
     * @return 结果
     */
    @Override
    public int insertStockTradeDayInfo(StockTradeDayInfo stockTradeDayInfo)
    {
        stockTradeDayInfo.setCreateTime(DateUtils.getNowDate());
        return stockTradeDayInfoMapper.insertStockTradeDayInfo(stockTradeDayInfo);
    }

    /**
     * 修改A股股票交易信息
     * 
     * @param stockTradeDayInfo A股股票交易信息
     * @return 结果
     */
    @Override
    public int updateStockTradeDayInfo(StockTradeDayInfo stockTradeDayInfo)
    {
        stockTradeDayInfo.setUpdateTime(DateUtils.getNowDate());
        return stockTradeDayInfoMapper.updateStockTradeDayInfo(stockTradeDayInfo);
    }

    /**
     * 批量删除A股股票交易信息
     * 
     * @param ids 需要删除的A股股票交易信息主键
     * @return 结果
     */
    @Override
    public int deleteStockTradeDayInfoByIds(String[] ids)
    {
        return stockTradeDayInfoMapper.deleteStockTradeDayInfoByIds(ids);
    }

    /**
     * 删除A股股票交易信息信息
     * 
     * @param id A股股票交易信息主键
     * @return 结果
     */
    @Override
    public int deleteStockTradeDayInfoById(String id)
    {
        return stockTradeDayInfoMapper.deleteStockTradeDayInfoById(id);
    }
}
