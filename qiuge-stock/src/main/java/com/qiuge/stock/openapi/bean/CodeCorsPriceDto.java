package com.qiuge.stock.openapi.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeCorsPriceDto {

    private String code;

    private String name;

    private double cors;
}
