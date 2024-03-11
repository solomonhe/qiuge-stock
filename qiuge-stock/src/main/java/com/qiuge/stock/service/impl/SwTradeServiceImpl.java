package com.qiuge.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.SwTradeMapper;
import com.qiuge.stock.domain.SwTrade;
import com.qiuge.stock.service.ISwTradeService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class SwTradeServiceImpl implements ISwTradeService 
{
    @Autowired
    private SwTradeMapper swTradeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SwTrade selectSwTradeById(String id)
    {
        return swTradeMapper.selectSwTradeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param swTrade 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SwTrade> selectSwTradeList(SwTrade swTrade)
    {
        return swTradeMapper.selectSwTradeList(swTrade);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param swTrade 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSwTrade(SwTrade swTrade)
    {
        swTrade.setCreateTime(DateUtils.getNowDate());
        return swTradeMapper.insertSwTrade(swTrade);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param swTrade 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSwTrade(SwTrade swTrade)
    {
        return swTradeMapper.updateSwTrade(swTrade);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSwTradeByIds(String[] ids)
    {
        return swTradeMapper.deleteSwTradeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSwTradeById(String id)
    {
        return swTradeMapper.deleteSwTradeById(id);
    }
}
