package com.housing.market.controller;

import com.housing.market.dto.StatsDto;
import com.housing.market.services.MarketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class HousingMarketControllerTest extends IntegrationTestBase {
    @MockBean
    private MarketService marketService;
    @Autowired
    private HousingMarketController housingMarketController;

    @Test
     void getHousingMarketStats() throws Exception {

        when(marketService.getMarketStats(any(), any())).thenReturn(StatsDto.builder().avgValue(BigDecimal.valueOf(1000L)).build());

        mvc.perform(get("/api/real-estates-stats/{regionId}", "LUBL")
                        .param("size", "L")
                        .param("rooms", "3")
                        .param("types", "detached_house,flat")
                        .param("dateSince", "20210501")
                        .param("dateUntil", "20210910"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.avgValue", notNullValue()));
    }
}
