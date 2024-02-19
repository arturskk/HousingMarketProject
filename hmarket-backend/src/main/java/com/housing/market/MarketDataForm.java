package com.housing.market;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;
@Data
public class MarketDataForm {
    private Integer totalPages;
    private List<MarketForm> data;
}
