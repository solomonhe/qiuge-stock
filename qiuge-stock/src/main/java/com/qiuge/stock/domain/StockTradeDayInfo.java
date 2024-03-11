package com.qiuge.stock.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * A股股票交易信息对象 stock_trade_day_info
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public class StockTradeDayInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** stock_ts_code + 交易日期 生成UUID */
    private String id;

    /** 股票代码 */
    @Excel(name = "股票代码")
    private String stockCode;

    /** 股票代码市场 示例：000001.SZ */
    @Excel(name = "股票代码市场 示例：000001.SZ")
    private String stockTsCode;

    /** 股票名称 */
    @Excel(name = "股票名称")
    private String stockName;

    /** 交易日期 */
    @Excel(name = "交易日期")
    private Long tradeDate;

    /** 开盘价 */
    @Excel(name = "开盘价")
    private BigDecimal priceOpen;

    /** 收盘价 */
    @Excel(name = "收盘价")
    private BigDecimal priceClose;

    /** 均价 */
    @Excel(name = "均价")
    private BigDecimal priceAverage;

    /** 最高价 */
    @Excel(name = "最高价")
    private BigDecimal priceHigh;

    /** 最低价 */
    @Excel(name = "最低价")
    private BigDecimal priceLow;

    /** 昨收价 */
    @Excel(name = "昨收价")
    private BigDecimal preClose;

    /** 涨跌额 */
    @Excel(name = "涨跌额")
    private BigDecimal priceChange;

    /** 涨跌幅 */
    @Excel(name = "涨跌幅")
    private BigDecimal pctChg;

    /** 成交量 */
    @Excel(name = "成交量")
    private Long stockVol;

    /** 成交额 单位千 */
    @Excel(name = "成交额 单位千")
    private Long stockAmount;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setStockCode(String stockCode) 
    {
        this.stockCode = stockCode;
    }

    public String getStockCode() 
    {
        return stockCode;
    }
    public void setStockTsCode(String stockTsCode) 
    {
        this.stockTsCode = stockTsCode;
    }

    public String getStockTsCode() 
    {
        return stockTsCode;
    }
    public void setStockName(String stockName) 
    {
        this.stockName = stockName;
    }

    public String getStockName() 
    {
        return stockName;
    }
    public void setTradeDate(Long tradeDate) 
    {
        this.tradeDate = tradeDate;
    }

    public Long getTradeDate() 
    {
        return tradeDate;
    }
    public void setPriceOpen(BigDecimal priceOpen) 
    {
        this.priceOpen = priceOpen;
    }

    public BigDecimal getPriceOpen() 
    {
        return priceOpen;
    }
    public void setPriceClose(BigDecimal priceClose) 
    {
        this.priceClose = priceClose;
    }

    public BigDecimal getPriceClose() 
    {
        return priceClose;
    }
    public void setPriceAverage(BigDecimal priceAverage) 
    {
        this.priceAverage = priceAverage;
    }

    public BigDecimal getPriceAverage() 
    {
        return priceAverage;
    }
    public void setPriceHigh(BigDecimal priceHigh) 
    {
        this.priceHigh = priceHigh;
    }

    public BigDecimal getPriceHigh() 
    {
        return priceHigh;
    }
    public void setPriceLow(BigDecimal priceLow) 
    {
        this.priceLow = priceLow;
    }

    public BigDecimal getPriceLow() 
    {
        return priceLow;
    }
    public void setPreClose(BigDecimal preClose) 
    {
        this.preClose = preClose;
    }

    public BigDecimal getPreClose() 
    {
        return preClose;
    }
    public void setPriceChange(BigDecimal priceChange) 
    {
        this.priceChange = priceChange;
    }

    public BigDecimal getPriceChange() 
    {
        return priceChange;
    }
    public void setPctChg(BigDecimal pctChg) 
    {
        this.pctChg = pctChg;
    }

    public BigDecimal getPctChg() 
    {
        return pctChg;
    }
    public void setStockVol(Long stockVol) 
    {
        this.stockVol = stockVol;
    }

    public Long getStockVol() 
    {
        return stockVol;
    }
    public void setStockAmount(Long stockAmount) 
    {
        this.stockAmount = stockAmount;
    }

    public Long getStockAmount() 
    {
        return stockAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stockCode", getStockCode())
            .append("stockTsCode", getStockTsCode())
            .append("stockName", getStockName())
            .append("tradeDate", getTradeDate())
            .append("priceOpen", getPriceOpen())
            .append("priceClose", getPriceClose())
            .append("priceAverage", getPriceAverage())
            .append("priceHigh", getPriceHigh())
            .append("priceLow", getPriceLow())
            .append("preClose", getPreClose())
            .append("priceChange", getPriceChange())
            .append("pctChg", getPctChg())
            .append("stockVol", getStockVol())
            .append("stockAmount", getStockAmount())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
