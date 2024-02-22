package com.housing.market;

import com.housing.market.dto.Region;
import com.housing.market.dto.Type;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class MarketTestForm {

    protected Region regionId;
    protected String id;
    protected BigDecimal price;
    protected String description;
    protected Float area;
    protected Integer rooms;
    protected Type type;
}
