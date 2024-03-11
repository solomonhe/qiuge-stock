package com.qiuge.stock.openapi.bean.dto;

import com.qiuge.stock.openapi.bean.CalculateCodeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * RateDto
 *
 * @author Solomon
 * @date 2021/09/18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {
    List<CalculateCodeDto> succeed = new ArrayList<>();
    List<CalculateCodeDto> succeed10 = new ArrayList<>();
    List<CalculateCodeDto> error = new ArrayList<>();
    List<CalculateCodeDto> error10 = new ArrayList<>();
}
