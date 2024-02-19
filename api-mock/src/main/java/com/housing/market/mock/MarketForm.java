package com.housing.market.mock;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MarketForm {
    private Region regionId;
    private String id;
    private BigDecimal price;
    private String description;
    private Float area;
    private Integer rooms;
    private Type type;
}
