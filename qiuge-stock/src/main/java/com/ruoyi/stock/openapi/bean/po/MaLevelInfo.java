package com.ruoyi.stock.openapi.bean.po;

import lombok.*;

/**
 *
 * MaLevelInfo
 *
 * @author Solomon
 * @date 2021/5/14 11:40
 */
@Data
public class MaLevelInfo extends MaInfoPo {
    private String MA5;
    private String MA10;
    private String MA20;
    private String MA30;
    private String MA60;
    private String MA120;
    private String MA250;

}
