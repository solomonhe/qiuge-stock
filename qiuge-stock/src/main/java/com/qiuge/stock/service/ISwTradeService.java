package com.qiuge.stock.service;

import java.util.List;
import com.qiuge.stock.domain.SwTrade;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface ISwTradeService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SwTrade selectSwTradeById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param swTrade 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SwTrade> selectSwTradeList(SwTrade swTrade);

    /**
     * 新增【请填写功能名称】
     * 
     * @param swTrade 【请填写功能名称】
     * @return 结果
     */
    public int insertSwTrade(SwTrade swTrade);

    /**
     * 修改【请填写功能名称】
     * 
     * @param swTrade 【请填写功能名称】
     * @return 结果
     */
    public int updateSwTrade(SwTrade swTrade);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSwTradeByIds(String[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSwTradeById(String id);
}
