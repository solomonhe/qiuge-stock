package com.qiuge.stock.openapi.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CalculateCodeDto
 *
 * @author Solomon
 * @date 2021/6/7 11:52
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculateCodeDto {
    private String code;

    private String name;

    private Double ratio;

    private String selectDate;

    private String industry;
}
