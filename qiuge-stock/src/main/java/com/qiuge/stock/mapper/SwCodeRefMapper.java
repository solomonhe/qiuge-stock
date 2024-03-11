package com.qiuge.stock.mapper;

import java.util.List;
import com.qiuge.stock.domain.SwCodeRef;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface SwCodeRefMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SwCodeRef selectSwCodeRefById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param swCodeRef 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SwCodeRef> selectSwCodeRefList(SwCodeRef swCodeRef);

    /**
     * 新增【请填写功能名称】
     * 
     * @param swCodeRef 【请填写功能名称】
     * @return 结果
     */
    public int insertSwCodeRef(SwCodeRef swCodeRef);

    /**
     * 修改【请填写功能名称】
     * 
     * @param swCodeRef 【请填写功能名称】
     * @return 结果
     */
    public int updateSwCodeRef(SwCodeRef swCodeRef);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSwCodeRefById(String id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSwCodeRefByIds(String[] ids);
}
