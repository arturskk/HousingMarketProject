package com.housing.market;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class HousingMarketClient {

    private final RestTemplate restTemplate;
    private final MarketService marketService;
    private final EmailService emailService;
    @Value("${integration.housingMarket}")
    private static String URI;
    @Value("${mail.address}")
    private String mailAddress;

    @Retry(name = "getHousingMarketStats", fallbackMethod = "fallbackMail")
    public void getHousingMarketStats() {
        MarketDataForm marketDataForm = restTemplate.exchange(URI + "/api/real-estates/{regionID}", HttpMethod.GET, null, new ParameterizedTypeReference<MarketDataForm>() {
        }, Region.LUBSK).getBody();
        if (marketDataForm != null) {
            marketDataForm.getData().forEach(market -> market.setRegionId(Region.LUBSK));
            marketService.saveMarketHousing(marketDataForm);
        }
    }

    private void fallbackMail(Long regionID, RuntimeException re) {
        emailService.sendEmail(mailAddress, "Data download failed 3 times", "Data download failed 3 times for regionID: " + regionID);
    }
}
