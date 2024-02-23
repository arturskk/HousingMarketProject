package com.housing.market.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HousingMarketJob {

    private final HousingMarketClient housingMarketClient;

    @Scheduled(cron = "0 0 21 * * ?")
    public void getHousingMarketStats() {
        housingMarketClient.getHousingMarketStats();
    }
}