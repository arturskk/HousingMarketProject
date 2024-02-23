package com.housing.market.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
@Builder
@Getter
public class StatsDto {
    private BigDecimal avgValue;
}
