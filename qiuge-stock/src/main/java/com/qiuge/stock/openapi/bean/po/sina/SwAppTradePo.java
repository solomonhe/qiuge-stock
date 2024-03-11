package com.qiuge.stock.openapi.bean.po.sina;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class SwAppTradePo {
    private String id;    //   sw1_370000private String   ,
    private String vi_id;    //   hy0370000private String   ,
    private String category_cn;    //   医药生物private String   ,
    private String percent;    // 3.4831302313743,
    private String increase;    // 19.9953,
    private String lead_cname;    //   海泰新光private String   ,
    private String lead_shares;    //   sh688677private String   ,
    private String indiff;    // 16.92,
    private String dropercent;    // -7.0215,
    private String led_cname;    //   金花股份private String   ,
    private String led_shares;    //   sh600080private String   ,
    private String time;    //   2021-09-17 15:00:00private String   ,
    private String r0_in;    //   11522055168.0000private String   ,
    private String r0_out;    //   8161591808.0000private String   ,
    private String r1_in;    //   27093145600.0000private String   ,
    private String r1_out;    //   25394765824.0000private String   ,
    private String r2_in;    //   37323198464.0000private String   ,
    private String r2_out;    //   39109009408.0000private String   ,
    private String r3_in;    //   27934529536.0000private String   ,
    private String r3_out;    //   31207559168.0000private String   ,
    private String ddjl;    //   2.26private String   ,
    private String ddjl3;    //   -1.08private String   ,
    private String ddjl5;    //   -2.97private String   ,
    private String ddjl10;    //   -7.13private String   ,
    private String ddjl20;    //   -20.75private String   ,
    private String r0_net;    // 5058843136,
    private String rp_net;    // 5058843136,
    private String rp_in;    // 38615200768,
    private String rp_out;    // 33556357632
}
