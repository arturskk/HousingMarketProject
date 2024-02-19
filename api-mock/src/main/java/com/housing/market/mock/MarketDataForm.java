package com.housing.market.mock;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MarketDataForm {
    private Integer totalPages;
    private List<MarketForm> data;
}
