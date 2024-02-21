package com.housing.market.repository;

import com.housing.market.domain.Market;
import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;
public interface MarketRepositoryCustom {
    BigDecimal calcAggregatedMarketStats(Specification<Market> spec);
}
