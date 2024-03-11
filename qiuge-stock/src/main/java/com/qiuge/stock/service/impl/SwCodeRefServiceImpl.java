package com.qiuge.stock.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiuge.stock.mapper.SwCodeRefMapper;
import com.qiuge.stock.domain.SwCodeRef;
import com.qiuge.stock.service.ISwCodeRefService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author qiuge
 * @date 2024-03-11
 */
@Service
public class SwCodeRefServiceImpl implements ISwCodeRefService 
{
    @Autowired
    private SwCodeRefMapper swCodeRefMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SwCodeRef selectSwCodeRefById(String id)
    {
        return swCodeRefMapper.selectSwCodeRefById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param swCodeRef 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SwCodeRef> selectSwCodeRefList(SwCodeRef swCodeRef)
    {
        return swCodeRefMapper.selectSwCodeRefList(swCodeRef);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param swCodeRef 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSwCodeRef(SwCodeRef swCodeRef)
    {
        swCodeRef.setCreateTime(DateUtils.getNowDate());
        return swCodeRefMapper.insertSwCodeRef(swCodeRef);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param swCodeRef 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSwCodeRef(SwCodeRef swCodeRef)
    {
        return swCodeRefMapper.updateSwCodeRef(swCodeRef);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSwCodeRefByIds(String[] ids)
    {
        return swCodeRefMapper.deleteSwCodeRefByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSwCodeRefById(String id)
    {
        return swCodeRefMapper.deleteSwCodeRefById(id);
    }
}
