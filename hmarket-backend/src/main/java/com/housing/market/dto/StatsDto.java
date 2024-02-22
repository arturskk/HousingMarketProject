package com.housing.market.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Builder
@Getter
public class StatsDto {
    private BigDecimal avgValue;
}
