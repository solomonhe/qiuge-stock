package com.qiuge.stock.domain;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qiuge.stock.utils.Md5Util;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 股票列表对象 stock
 *
 * @author solomon
 * @date 2024-03-11
 */
@Slf4j
public class Stock extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 股票代码 + 交易所代码 生成UUID
     */
    private String id;

    /**
     * 股票代码
     */
    @Excel(name = "股票代码")
    private String stockCode;

    /**
     * 股票代码市场 示例：000001.SZ
     */
    @Excel(name = "股票代码市场 示例：000001.SZ")
    private String stockTsCode;

    /**
     * 股票名称
     */
    @Excel(name = "股票名称")
    private String stockName;

    /**
     * 地域
     */
    @Excel(name = "地域")
    private String area;

    /**
     * 所属行业
     */
    @Excel(name = "所属行业")
    private String industry;

    /**
     * 股票全称
     */
    @Excel(name = "股票全称")
    private String stockFullName;

    /**
     * 英文全称
     */
    @Excel(name = "英文全称")
    private String enName;

    /**
     * 拼音缩写
     */
    @Excel(name = "拼音缩写")
    private String cnspell;

    /**
     * 市场类型
     */
    @Excel(name = "市场类型")
    private String market;

    /**
     * 交易所代码
     */
    @Excel(name = "交易所代码")
    private String exchange;

    /**
     * 交易货币
     */
    @Excel(name = "交易货币")
    private String currType;

    /**
     * 上市状态 L上市 D退市 P暂停上市
     */
    @Excel(name = "上市状态 L上市 D退市 P暂停上市")
    private String opiStatus;

    /**
     * 上市日期
     */
    @Excel(name = "上市日期")
    private Long listDate;

    /**
     * 退市日期
     */
    @Excel(name = "退市日期")
    private Long delistDate;

    /**
     * 是否沪深港通标的，N否 H沪股通 S深股通
     */
    @Excel(name = "是否沪深港通标的，N否 H沪股通 S深股通")
    private String isHs;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockTsCode(String stockTsCode) {
        this.stockTsCode = stockTsCode;
    }

    public String getStockTsCode() {
        return stockTsCode;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockName() {
        return stockName;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }

    public void setStockFullName(String stockFullName) {
        this.stockFullName = stockFullName;
    }

    public String getStockFullName() {
        return stockFullName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getEnName() {
        return enName;
    }

    public void setCnspell(String cnspell) {
        this.cnspell = cnspell;
    }

    public String getCnspell() {
        return cnspell;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMarket() {
        return market;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }

    public void setCurrType(String currType) {
        this.currType = currType;
    }

    public String getCurrType() {
        return currType;
    }

    public void setOpiStatus(String opiStatus) {
        this.opiStatus = opiStatus;
    }

    public String getOpiStatus() {
        return opiStatus;
    }

    public void setListDate(Long listDate) {
        this.listDate = listDate;
    }

    public Long getListDate() {
        return listDate;
    }

    public void setDelistDate(Long delistDate) {
        this.delistDate = delistDate;
    }

    public Long getDelistDate() {
        return delistDate;
    }

    public void setIsHs(String isHs) {
        this.isHs = isHs;
    }

    public String getIsHs() {
        return isHs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("stockCode", getStockCode())
                .append("stockTsCode", getStockTsCode())
                .append("stockName", getStockName())
                .append("area", getArea())
                .append("industry", getIndustry())
                .append("stockFullName", getStockFullName())
                .append("enName", getEnName())
                .append("cnspell", getCnspell())
                .append("market", getMarket())
                .append("exchange", getExchange())
                .append("currType", getCurrType())
                .append("opiStatus", getOpiStatus())
                .append("listDate", getListDate())
                .append("delistDate", getDelistDate())
                .append("isHs", getIsHs())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .toString();
    }

    @JsonIgnore
    public static List<Stock> convert(JSONArray jsonArray) {
        List<Stock> stockEntityList = new ArrayList<>(jsonArray.size());
        jsonArray.stream().forEach(array -> {
            List list = (List) array;
            Stock stockEntity = new Stock();
            log.info("股票信息 :{}", JSONObject.toJSONString(list));
            //封装股票数据
            stockEntity.setStockTsCode(list.get(0).toString());
            stockEntity.setStockCode(list.get(1).toString());
            stockEntity.setStockName(list.get(2).toString());
            stockEntity.setArea(String.valueOf(list.get(3)));
            stockEntity.setIndustry(String.valueOf(list.get(4)));
            stockEntity.setStockFullName(list.get(5).toString());
            stockEntity.setEnName(list.get(6).toString());
            stockEntity.setCnspell(list.get(7).toString());
            stockEntity.setMarket(list.get(8).toString());
            stockEntity.setExchange(list.get(9).toString());
            stockEntity.setCurrType(list.get(10).toString());
            stockEntity.setOpiStatus(list.get(11).toString());
            stockEntity.setListDate(Long.valueOf(list.get(12).toString()));
            stockEntity.setIsHs(String.valueOf(list.get(14)));

            String id = Md5Util.getMD5(stockEntity.getStockTsCode());
            stockEntity.setId(id);
            stockEntity.setCreateTime(new Date());
            stockEntityList.add(stockEntity);

        });
        return stockEntityList;
    }
}
