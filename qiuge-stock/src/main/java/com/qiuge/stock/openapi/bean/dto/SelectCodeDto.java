package com.qiuge.stock.openapi.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * SelectCodeDto
 *
 * @author Solomon
 * @date 2021/09/03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelectCodeDto implements Serializable {
    private String code;
    private Date selectDate;
}
