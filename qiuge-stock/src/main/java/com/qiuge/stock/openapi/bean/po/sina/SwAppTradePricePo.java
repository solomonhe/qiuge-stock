package com.qiuge.stock.openapi.bean.po.sina;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SwAppTradePo
 *
 * @author Solomon
 * @date 2021/09/17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SwAppTradePricePo {
    /**
     * 当天日期
     */
    @JSONField(name="date")
    private Date toDate;   //"2022-01-05",
    /**
     * 未知
     */
    private String mf;      // "184696560.797",

    /**
     * 当天收盘价
     */
    private BigDecimal p;       //7171.228",

    /**
     * 未知
     */
    private String pt;     //6.79"


    public SwAppTradePricePo(JSONArray jsonArray) {
        this.toDate = DateUtil.parseDate(jsonArray.get(0).toString());
        this.mf = jsonArray.get(1).toString();
        this.p = new BigDecimal(jsonArray.get(2).toString());
        this.pt = jsonArray.get(3).toString();
    }
}
