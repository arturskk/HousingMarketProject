package com.housing.market.services;

import com.housing.market.form.MarketDataForm;
import com.housing.market.dto.Region;
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
    @Value("${integration.housingmarket}")
    private String uri;
    @Value("${mail.address}")
    private String mailAddress;

    @Retry(name = "getHousingMarketStats", fallbackMethod = "fallbackMail")
    public void getHousingMarketStats() {
        MarketDataForm marketDataForm = restTemplate.exchange(uri + "/api/real-estates/{regionID}", HttpMethod.GET, null, new ParameterizedTypeReference<MarketDataForm>() {
        }, Region.LUBSK).getBody();
        if (marketDataForm != null) {
            marketDataForm.getData().forEach(market -> market.setRegionId(Region.LUBSK));
            marketService.saveMarketHousing(marketDataForm);
        }
    }

    private void fallbackMail() {
        emailService.sendEmail(mailAddress, "Data download failed 3 times", "Data download failed 3 times");
    }
}
