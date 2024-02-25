package com.ruoyi.stock.openapi.bean.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * MaInfoPo
 *
 * @author Solomon
 * @date 2021/5/12 19:11
 */
@Data
public class MaInfoPo {

    /**
     * 时间戳去掉后两位置
     */
    private Date timestamp;
    /**
     * 交易手数
     */
    private String volume;
    /**
     * 开盘价
     */
    private String open;
    /**
     * 最盘价
     */
    private String high;
    /**
     * 最低价
     */
    private String low;
    /**
     * 收盘价
     */
    private String close;
    /**
     * 涨跌额
     */
    private String chg;
    /**
     * 涨跌幅度
     */
    private String percent;
    /**
     * 换手率
     */
    private String turnoverrate;
    /**
     * 交易额度万
     */
    private String amount;


    public MaInfoPo(List<String> list){
        long timestamp = Long.parseLong(list.get(0).substring(0, list.get(0).length() - 3));
        Date date = new Date(timestamp * 1000);
        this.timestamp = date;
        this.volume = list.get(1);
        this.open = list.get(2);
        this.high = list.get(3);
        this.low = list.get(4);
        this.close = list.get(5);
        this.chg = list.get(6);
        this.percent = list.get(7);
        this.turnoverrate = list.get(8);
        this.amount = list.get(9);
    }

    public MaInfoPo() {
       
    }
}
