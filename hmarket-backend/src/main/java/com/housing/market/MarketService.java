package com.housing.market;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;
    public StatsDto getMarketStats(QueryParamsForm queryParams){
        return StatsDto
                .builder()
                .avgValue(marketRepository.calcAggregatedMarketStats(MarketRepository.search(queryParams)))
                .build();
    }

    public void saveMarketHousing(MarketDataForm marketData) {
        marketRepository.deleteAll();
        List<Market> markets = Market.createFromForm(marketData);
        marketRepository.saveAllAndFlush(markets);
    }
}
