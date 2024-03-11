package com.qiuge.stock.openapi.bean.stock;

import lombok.Data;

/**
 * @description:
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2023</p>
 * @date: 2023-02-25 21:34
 * @version: 1.0
 **/

@Data
public class TradeCodeDto {

    private String exchange;


    private Integer cal_date;

    private Integer is_open;

    private Integer pretrade_date;


}
