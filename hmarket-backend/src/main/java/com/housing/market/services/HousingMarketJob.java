package com.housing.market.services;

import com.housing.market.services.HousingMarketClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class HousingMarketJob {

    private final HousingMarketClient housingMarketClient;

    @Scheduled(cron = "0 * * * * *")
    public void getHousingMarketStats() {
        housingMarketClient.getHousingMarketStats();
    }
}
