package com.qiuge.stock.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 stock_strategy_code_info
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public class StockStrategyCodeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 股票code */
    private String id;

    /** 策略模型 */
    @Excel(name = "策略模型")
    private Long type;

    /** 股票名称 */
    @Excel(name = "股票名称")
    private String name;

    /** 股票名称 */
    @Excel(name = "股票名称")
    private String code;

    /** 市场类型（主板/科创板/创业板） */
    @Excel(name = "市场类型", readConverterExp = "主=板/科创板/创业板")
    private String market;

    /** 行业 */
    @Excel(name = "行业")
    private String industry;

    /** 选中时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "选中时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date selectDate;

    /** 人为选中 0 : 否 1 ： 是 */
    @Excel(name = "人为选中 0 : 否 1 ： 是")
    private Integer selectStatus;

    /** 选中价格 */
    @Excel(name = "选中价格")
    private String codePrice;

    /** 当天价格 */
    @Excel(name = "当天价格")
    private BigDecimal dayPrice;

    /** 二十天后价格 */
    @Excel(name = "二十天后价格")
    private BigDecimal dayTwentyPrice;

    /** 五天后价格 */
    @Excel(name = "五天后价格")
    private BigDecimal dayFivePrice;

    /** 十天后价格 */
    @Excel(name = "十天后价格")
    private BigDecimal dayTenPrice;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setMarket(String market) 
    {
        this.market = market;
    }

    public String getMarket() 
    {
        return market;
    }
    public void setIndustry(String industry) 
    {
        this.industry = industry;
    }

    public String getIndustry() 
    {
        return industry;
    }
    public void setSelectDate(Date selectDate) 
    {
        this.selectDate = selectDate;
    }

    public Date getSelectDate() 
    {
        return selectDate;
    }
    public void setSelectStatus(Integer selectStatus) 
    {
        this.selectStatus = selectStatus;
    }

    public Integer getSelectStatus() 
    {
        return selectStatus;
    }
    public void setCodePrice(String codePrice) 
    {
        this.codePrice = codePrice;
    }

    public String getCodePrice() 
    {
        return codePrice;
    }
    public void setDayPrice(BigDecimal dayPrice) 
    {
        this.dayPrice = dayPrice;
    }

    public BigDecimal getDayPrice() 
    {
        return dayPrice;
    }
    public void setDayTwentyPrice(BigDecimal dayTwentyPrice) 
    {
        this.dayTwentyPrice = dayTwentyPrice;
    }

    public BigDecimal getDayTwentyPrice() 
    {
        return dayTwentyPrice;
    }
    public void setDayFivePrice(BigDecimal dayFivePrice) 
    {
        this.dayFivePrice = dayFivePrice;
    }

    public BigDecimal getDayFivePrice() 
    {
        return dayFivePrice;
    }
    public void setDayTenPrice(BigDecimal dayTenPrice) 
    {
        this.dayTenPrice = dayTenPrice;
    }

    public BigDecimal getDayTenPrice() 
    {
        return dayTenPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("name", getName())
            .append("code", getCode())
            .append("market", getMarket())
            .append("industry", getIndustry())
            .append("selectDate", getSelectDate())
            .append("selectStatus", getSelectStatus())
            .append("codePrice", getCodePrice())
            .append("dayPrice", getDayPrice())
            .append("dayTwentyPrice", getDayTwentyPrice())
            .append("dayFivePrice", getDayFivePrice())
            .append("dayTenPrice", getDayTenPrice())
            .append("createTime", getCreateTime())
            .toString();
    }
}
