package com.qiuge.stock.openapi.bean.macd;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * MacdInfoVo
 *
 * @author Solomon
 * @date 2021/12/07
 */
@Data
public class MacdInfoListVo {

   private BigDecimal codePrice ;
   /**
    * 选中日期
    */
   private Date toDate;
}
