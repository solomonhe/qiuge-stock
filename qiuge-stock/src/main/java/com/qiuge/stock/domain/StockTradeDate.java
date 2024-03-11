package com.qiuge.stock.domain;

import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 上交所/深交所交易日期对象 stock_trade_date
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public class StockTradeDate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 股票code */
    private String id;

    /** 交易所 A: A股股票 */
    @Excel(name = "交易所 A: A股股票")
    private String stockType;

    /** 日历日期 */
    @Excel(name = "日历日期")
    private Integer calDate;

    /** 是否交易 0休市 1交易 */
    @Excel(name = "是否交易 0休市 1交易")
    private Integer isOpen;

    /** 上一个交易日 */
    @Excel(name = "上一个交易日")
    private Integer pretradeDate;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setStockType(String stockType) 
    {
        this.stockType = stockType;
    }

    public String getStockType() 
    {
        return stockType;
    }
    public void setCalDate(Integer calDate) 
    {
        this.calDate = calDate;
    }

    public Integer getCalDate() 
    {
        return calDate;
    }
    public void setIsOpen(Integer isOpen) 
    {
        this.isOpen = isOpen;
    }

    public Integer getIsOpen() 
    {
        return isOpen;
    }
    public void setPretradeDate(Integer pretradeDate) 
    {
        this.pretradeDate = pretradeDate;
    }

    public Integer getPretradeDate() 
    {
        return pretradeDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stockType", getStockType())
            .append("calDate", getCalDate())
            .append("isOpen", getIsOpen())
            .append("pretradeDate", getPretradeDate())
            .toString();
    }

    public StockTradeDate(JSONArray jsonArray) {
        this.stockType = jsonArray.get(0).toString();
        this.calDate = Integer.valueOf(jsonArray.get(1).toString());
        this.isOpen = Integer.valueOf(jsonArray.get(2).toString());;
        this.pretradeDate =  Integer.valueOf(jsonArray.get(3).toString());;
    }
}
