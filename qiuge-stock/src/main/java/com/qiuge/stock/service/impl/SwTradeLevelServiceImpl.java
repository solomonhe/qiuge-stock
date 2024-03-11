package com.qiuge.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.SwTradeLevelMapper;
import com.qiuge.stock.domain.SwTradeLevel;
import com.qiuge.stock.service.ISwTradeLevelService;

/**
 * 申万行业等级关系Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class SwTradeLevelServiceImpl implements ISwTradeLevelService 
{
    @Autowired
    private SwTradeLevelMapper swTradeLevelMapper;

    /**
     * 查询申万行业等级关系
     * 
     * @param id 申万行业等级关系主键
     * @return 申万行业等级关系
     */
    @Override
    public SwTradeLevel selectSwTradeLevelById(String id)
    {
        return swTradeLevelMapper.selectSwTradeLevelById(id);
    }

    /**
     * 查询申万行业等级关系列表
     * 
     * @param swTradeLevel 申万行业等级关系
     * @return 申万行业等级关系
     */
    @Override
    public List<SwTradeLevel> selectSwTradeLevelList(SwTradeLevel swTradeLevel)
    {
        return swTradeLevelMapper.selectSwTradeLevelList(swTradeLevel);
    }

    /**
     * 新增申万行业等级关系
     * 
     * @param swTradeLevel 申万行业等级关系
     * @return 结果
     */
    @Override
    public int insertSwTradeLevel(SwTradeLevel swTradeLevel)
    {
        swTradeLevel.setCreateTime(DateUtils.getNowDate());
        return swTradeLevelMapper.insertSwTradeLevel(swTradeLevel);
    }

    /**
     * 修改申万行业等级关系
     * 
     * @param swTradeLevel 申万行业等级关系
     * @return 结果
     */
    @Override
    public int updateSwTradeLevel(SwTradeLevel swTradeLevel)
    {
        return swTradeLevelMapper.updateSwTradeLevel(swTradeLevel);
    }

    /**
     * 批量删除申万行业等级关系
     * 
     * @param ids 需要删除的申万行业等级关系主键
     * @return 结果
     */
    @Override
    public int deleteSwTradeLevelByIds(String[] ids)
    {
        return swTradeLevelMapper.deleteSwTradeLevelByIds(ids);
    }

    /**
     * 删除申万行业等级关系信息
     * 
     * @param id 申万行业等级关系主键
     * @return 结果
     */
    @Override
    public int deleteSwTradeLevelById(String id)
    {
        return swTradeLevelMapper.deleteSwTradeLevelById(id);
    }
}
