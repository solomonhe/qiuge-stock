package com.qiuge.stock.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 sw_trade_info
 * 
 * @author qiuge
 * @date 2024-03-11
 */
public class SwTradeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 申万行业code */
    @Excel(name = "申万行业code")
    private String swIndexCode;

    /** 申万行业名称 */
    @Excel(name = "申万行业名称")
    private String swIndexName;

    /** 成交量  2.48亿 "24793" 万为单位 */
    @Excel(name = "成交量  2.48亿  万为单位")
    private Long bargainAmount;

    /** 成交额占比 "0.35" */
    @Excel(name = "成交额占比")
    private Long bargainSumRate;

    /** 收盘价 */
    @Excel(name = "收盘价")
    private String closeIndex;

    /** 股息率 "1.00" */
    @Excel(name = "股息率 ")
    private String dP;

    /** 涨跌幅  "-1.04" */
    @Excel(name = "涨跌幅")
    private String markup;

    /** 均价 "17.68" */
    @Excel(name = "均价")
    private String meanPrice;

    /** 流通市值 "16769335.36" 万为单位 */
    @Excel(name = "流通市值  万为单位")
    private String negotiablesShareSum;

    /** 平均流通市值 "838466.77" 万为单位 */
    @Excel(name = "平均流通市值 万为单位")
    private String negotiablesShareSum2;

    /** 市净"3.23" */
    @Excel(name = "市净")
    private String pB;

    /** 市盈 "33.38 */
    @Excel(name = "市盈")
    private String pE;

    /** 换手率 "1.8960" */
    @Excel(name = "换手率 ")
    private String turnoverRate;

    /** 日期 */
    @Excel(name = "日期")
    private String bargainDate;

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
    public void setSwIndexCode(String swIndexCode) 
    {
        this.swIndexCode = swIndexCode;
    }

    public String getSwIndexCode() 
    {
        return swIndexCode;
    }
    public void setSwIndexName(String swIndexName) 
    {
        this.swIndexName = swIndexName;
    }

    public String getSwIndexName() 
    {
        return swIndexName;
    }
    public void setBargainAmount(Long bargainAmount) 
    {
        this.bargainAmount = bargainAmount;
    }

    public Long getBargainAmount() 
    {
        return bargainAmount;
    }
    public void setBargainSumRate(Long bargainSumRate) 
    {
        this.bargainSumRate = bargainSumRate;
    }

    public Long getBargainSumRate() 
    {
        return bargainSumRate;
    }
    public void setCloseIndex(String closeIndex) 
    {
        this.closeIndex = closeIndex;
    }

    public String getCloseIndex() 
    {
        return closeIndex;
    }
    public void setDP(String dP) 
    {
        this.dP = dP;
    }

    public String getDP() 
    {
        return dP;
    }
    public void setMarkup(String markup) 
    {
        this.markup = markup;
    }

    public String getMarkup() 
    {
        return markup;
    }
    public void setMeanPrice(String meanPrice) 
    {
        this.meanPrice = meanPrice;
    }

    public String getMeanPrice() 
    {
        return meanPrice;
    }
    public void setNegotiablesShareSum(String negotiablesShareSum) 
    {
        this.negotiablesShareSum = negotiablesShareSum;
    }

    public String getNegotiablesShareSum() 
    {
        return negotiablesShareSum;
    }
    public void setNegotiablesShareSum2(String negotiablesShareSum2) 
    {
        this.negotiablesShareSum2 = negotiablesShareSum2;
    }

    public String getNegotiablesShareSum2() 
    {
        return negotiablesShareSum2;
    }
    public void setPB(String pB) 
    {
        this.pB = pB;
    }

    public String getPB() 
    {
        return pB;
    }
    public void setPE(String pE) 
    {
        this.pE = pE;
    }

    public String getPE() 
    {
        return pE;
    }
    public void setTurnoverRate(String turnoverRate) 
    {
        this.turnoverRate = turnoverRate;
    }

    public String getTurnoverRate() 
    {
        return turnoverRate;
    }
    public void setBargainDate(String bargainDate) 
    {
        this.bargainDate = bargainDate;
    }

    public String getBargainDate() 
    {
        return bargainDate;
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
            .append("swIndexCode", getSwIndexCode())
            .append("swIndexName", getSwIndexName())
            .append("bargainAmount", getBargainAmount())
            .append("bargainSumRate", getBargainSumRate())
            .append("closeIndex", getCloseIndex())
            .append("dP", getDP())
            .append("markup", getMarkup())
            .append("meanPrice", getMeanPrice())
            .append("negotiablesShareSum", getNegotiablesShareSum())
            .append("negotiablesShareSum2", getNegotiablesShareSum2())
            .append("pB", getPB())
            .append("pE", getPE())
            .append("turnoverRate", getTurnoverRate())
            .append("bargainDate", getBargainDate())
            .append("dayDate", getDayDate())
            .append("createTime", getCreateTime())
            .toString();
    }
}
