package com.qiuge.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.SwTradeInfoMapper;
import com.qiuge.stock.domain.SwTradeInfo;
import com.qiuge.stock.service.ISwTradeInfoService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class SwTradeInfoServiceImpl implements ISwTradeInfoService 
{
    @Autowired
    private SwTradeInfoMapper swTradeInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SwTradeInfo selectSwTradeInfoById(String id)
    {
        return swTradeInfoMapper.selectSwTradeInfoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param swTradeInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SwTradeInfo> selectSwTradeInfoList(SwTradeInfo swTradeInfo)
    {
        return swTradeInfoMapper.selectSwTradeInfoList(swTradeInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param swTradeInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSwTradeInfo(SwTradeInfo swTradeInfo)
    {
        swTradeInfo.setCreateTime(DateUtils.getNowDate());
        return swTradeInfoMapper.insertSwTradeInfo(swTradeInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param swTradeInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSwTradeInfo(SwTradeInfo swTradeInfo)
    {
        return swTradeInfoMapper.updateSwTradeInfo(swTradeInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSwTradeInfoByIds(String[] ids)
    {
        return swTradeInfoMapper.deleteSwTradeInfoByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSwTradeInfoById(String id)
    {
        return swTradeInfoMapper.deleteSwTradeInfoById(id);
    }
}
