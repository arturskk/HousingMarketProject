package com.housing.market;

import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;
public interface MarketRepositoryCustom {
    BigDecimal calcAggregatedMarketStats(Specification<Market> spec);
}
