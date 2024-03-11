package com.qiuge.stock.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 竞价历史对象 stock_bidding_history
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public class StockBiddingHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String code;

    /** 成交额 */
    @Excel(name = "成交额")
    private BigDecimal amount;

    /** 成交额中文 */
    @Excel(name = "成交额中文")
    private String amountNum;

    /** 成交量 */
    @Excel(name = "成交量")
    private Long volume;

    /** 成交量中文 */
    @Excel(name = "成交量中文")
    private String volumeNum;

    /** 涨幅 */
    @Excel(name = "涨幅")
    private String percent;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dayDate;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
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
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setAmountNum(String amountNum) 
    {
        this.amountNum = amountNum;
    }

    public String getAmountNum() 
    {
        return amountNum;
    }
    public void setVolume(Long volume) 
    {
        this.volume = volume;
    }

    public Long getVolume() 
    {
        return volume;
    }
    public void setVolumeNum(String volumeNum) 
    {
        this.volumeNum = volumeNum;
    }

    public String getVolumeNum() 
    {
        return volumeNum;
    }
    public void setPercent(String percent) 
    {
        this.percent = percent;
    }

    public String getPercent() 
    {
        return percent;
    }
    public void setDayDate(Date dayDate) 
    {
        this.dayDate = dayDate;
    }

    public Date getDayDate() 
    {
        return dayDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("amount", getAmount())
            .append("amountNum", getAmountNum())
            .append("volume", getVolume())
            .append("volumeNum", getVolumeNum())
            .append("percent", getPercent())
            .append("dayDate", getDayDate())
            .append("createTime", getCreateTime())
            .toString();
    }
}
