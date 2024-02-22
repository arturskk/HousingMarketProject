package com.housing.market.services;

import com.housing.market.dto.Region;
import com.housing.market.dto.StatsDto;
import com.housing.market.domain.Market;
import com.housing.market.form.MarketDataForm;
import com.housing.market.form.QueryParamsForm;
import com.housing.market.repository.MarketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;
    public StatsDto getMarketStats(Region regionId, QueryParamsForm queryParams){
        return StatsDto
                .builder()
                .avgValue(marketRepository.calcAggregatedMarketStats(MarketRepository.search(regionId, queryParams)))
                .build();
    }
    @Transactional
    public void saveMarketHousing(MarketDataForm marketData) {
        marketRepository.deleteAll();
        List<Market> markets = Market.createFromForm(marketData);
        marketRepository.saveAllAndFlush(markets);
    }
}
