package com.qiuge.stock.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * A股股票每日均价成交对象 stock_trade_day_average
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public class StockTradeDayAverage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 股票代码 + 交易日期 生成UUID */
    private String id;

    /** 股票代码 */
    @Excel(name = "股票代码")
    private String stockCode;

    /** 股票代码.市场 */
    @Excel(name = "股票代码.市场")
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

    /** 涨跌额 */
    @Excel(name = "涨跌额")
    private BigDecimal priceChange;

    /** 涨跌幅 */
    @Excel(name = "涨跌幅")
    private BigDecimal pctChg;

    /** 成交量 */
    @Excel(name = "成交量")
    private Long stockVol;

    /** 成交量中文 */
    @Excel(name = "成交量中文")
    private String stockVolNum;

    /** 成交额  */
    @Excel(name = "成交额 ")
    private Long stockAmount;

    /** 成交额中文 */
    @Excel(name = "成交额中文")
    private String stockAmountNum;

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
    public void setStockVolNum(String stockVolNum) 
    {
        this.stockVolNum = stockVolNum;
    }

    public String getStockVolNum() 
    {
        return stockVolNum;
    }
    public void setStockAmount(Long stockAmount) 
    {
        this.stockAmount = stockAmount;
    }

    public Long getStockAmount() 
    {
        return stockAmount;
    }
    public void setStockAmountNum(String stockAmountNum) 
    {
        this.stockAmountNum = stockAmountNum;
    }

    public String getStockAmountNum() 
    {
        return stockAmountNum;
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
            .append("priceChange", getPriceChange())
            .append("pctChg", getPctChg())
            .append("stockVol", getStockVol())
            .append("stockVolNum", getStockVolNum())
            .append("stockAmount", getStockAmount())
            .append("stockAmountNum", getStockAmountNum())
            .append("createTime", getCreateTime())
            .toString();
    }
}
