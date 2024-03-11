package com.qiuge.stock.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sw_code_ref
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public class SwCodeRef extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 申请行业级别:：1 : 申万一级行业  2 : 申万一级行业  3 : 申万一级行业 */
    @Excel(name = "申请行业级别:：1 : 申万一级行业  2 : 申万一级行业  3 : 申万一级行业")
    private Integer swLevel;

    /** 新浪申万行业名称 */
    @Excel(name = "新浪申万行业名称")
    private String swCodeName;

    /** 新浪申万行业code */
    @Excel(name = "新浪申万行业code")
    private String swCode;

    /** 股票代码 */
    @Excel(name = "股票代码")
    private String code;

    /** 股票名称 */
    @Excel(name = "股票名称")
    private String name;

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
    public void setSwCodeName(String swCodeName) 
    {
        this.swCodeName = swCodeName;
    }

    public String getSwCodeName() 
    {
        return swCodeName;
    }
    public void setSwCode(String swCode) 
    {
        this.swCode = swCode;
    }

    public String getSwCode() 
    {
        return swCode;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("swLevel", getSwLevel())
            .append("swCodeName", getSwCodeName())
            .append("swCode", getSwCode())
            .append("code", getCode())
            .append("name", getName())
            .append("createTime", getCreateTime())
            .toString();
    }
}
