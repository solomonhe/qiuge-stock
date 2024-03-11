package com.qiuge.stock.openapi.bean.macd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * MACD 均线类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MACDInfo {
    private BigDecimal MACD;
    private BigDecimal DIF;
    private BigDecimal DEA;
}
