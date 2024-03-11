package com.qiuge.stock.service;

import java.util.List;
import com.qiuge.stock.domain.SwTradeLevel;

/**
 * 申万行业等级关系Service接口
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public interface ISwTradeLevelService 
{
    /**
     * 查询申万行业等级关系
     * 
     * @param id 申万行业等级关系主键
     * @return 申万行业等级关系
     */
    public SwTradeLevel selectSwTradeLevelById(String id);

    /**
     * 查询申万行业等级关系列表
     * 
     * @param swTradeLevel 申万行业等级关系
     * @return 申万行业等级关系集合
     */
    public List<SwTradeLevel> selectSwTradeLevelList(SwTradeLevel swTradeLevel);

    /**
     * 新增申万行业等级关系
     * 
     * @param swTradeLevel 申万行业等级关系
     * @return 结果
     */
    public int insertSwTradeLevel(SwTradeLevel swTradeLevel);

    /**
     * 修改申万行业等级关系
     * 
     * @param swTradeLevel 申万行业等级关系
     * @return 结果
     */
    public int updateSwTradeLevel(SwTradeLevel swTradeLevel);

    /**
     * 批量删除申万行业等级关系
     * 
     * @param ids 需要删除的申万行业等级关系主键集合
     * @return 结果
     */
    public int deleteSwTradeLevelByIds(String[] ids);

    /**
     * 删除申万行业等级关系信息
     * 
     * @param id 申万行业等级关系主键
     * @return 结果
     */
    public int deleteSwTradeLevelById(String id);
}
