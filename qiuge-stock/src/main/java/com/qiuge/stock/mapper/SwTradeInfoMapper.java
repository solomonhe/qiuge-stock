package com.qiuge.stock.mapper;

import java.util.List;
import com.qiuge.stock.domain.SwTradeInfo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface SwTradeInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SwTradeInfo selectSwTradeInfoById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param swTradeInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SwTradeInfo> selectSwTradeInfoList(SwTradeInfo swTradeInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param swTradeInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertSwTradeInfo(SwTradeInfo swTradeInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param swTradeInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateSwTradeInfo(SwTradeInfo swTradeInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSwTradeInfoById(String id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSwTradeInfoByIds(String[] ids);
}
