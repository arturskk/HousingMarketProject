package com.housing.market.form;

import lombok.Data;
import java.util.List;
@Data
public class MarketDataForm {
    private Integer totalPages;
    private List<MarketForm> data;
}
