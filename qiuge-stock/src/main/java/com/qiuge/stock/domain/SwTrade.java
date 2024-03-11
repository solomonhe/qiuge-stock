package com.qiuge.stock.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sw_trade
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public class SwTrade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 申请行业级别:：1 : 申万一级行业  2 : 申万一级行业  3 : 申万一级行业  */
    @Excel(name = "申请行业级别:：1 : 申万一级行业  2 : 申万一级行业  3 : 申万一级行业 ")
    private Integer swLevel;

    /** 申万行业名称 */
    @Excel(name = "申万行业名称")
    private String swName;

    /** 申万行业code */
    @Excel(name = "申万行业code")
    private String swCode;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setSwLevel(Integer swLevel) 
    {
        this.swLevel = swLevel;
    }

    public Integer getSwLevel() 
    {
        return swLevel;
    }
    public void setSwName(String swName) 
    {
        this.swName = swName;
    }

    public String getSwName() 
    {
        return swName;
    }
    public void setSwCode(String swCode) 
    {
        this.swCode = swCode;
    }

    public String getSwCode() 
    {
        return swCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("swLevel", getSwLevel())
            .append("swName", getSwName())
            .append("swCode", getSwCode())
            .append("createTime", getCreateTime())
            .toString();
    }
}
