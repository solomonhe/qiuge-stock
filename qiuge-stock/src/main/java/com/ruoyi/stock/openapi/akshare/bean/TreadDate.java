package com.ruoyi.stock.openapi.akshare.bean;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @description:  A股交易日期
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2024</p>
 * @date: 2024-01-14 14:29
 * @version: 1.0
 **/
@Data
public class TreadDate {

    @JSONField(defaultValue = "trade_date")
    private Date tradeDate;
}
