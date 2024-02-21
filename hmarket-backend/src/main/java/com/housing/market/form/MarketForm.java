package com.housing.market.form;

import com.housing.market.dto.Region;
import com.housing.market.dto.Type;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class MarketForm {
    private Region regionId;
    private String id;
    private BigDecimal price;
    private String description;
    private Float area;
    private Integer rooms;
    private Type type;
}
