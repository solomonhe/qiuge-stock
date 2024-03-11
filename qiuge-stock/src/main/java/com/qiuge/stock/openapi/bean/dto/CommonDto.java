package com.qiuge.stock.openapi.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Solomon
 * <p>Copyright；Copyright (c) 2023</p>
 * @date: 2023-03-19 16:27
 * @version: 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonDto {
    private String id;
    private String name;
}
