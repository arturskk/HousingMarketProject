package com.housing.market.housing;

import com.housing.market.config.IntegrationTestConfig;
import com.housing.market.dto.Region;
import com.housing.market.dto.Size;
import com.housing.market.dto.StatsDto;
import com.housing.market.form.QueryParamsForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

@DataJpaTest
@Import(IntegrationTestConfig.class)
class MarketServiceTest {

    @Autowired
    MarketService marketService;

    @Test
    void marketSearchTest() {
        LocalDate localDate = LocalDate.now();
        LocalDate yesterdayDate = localDate.minusDays(7);
        LocalDate weeksinceToday = localDate.plusDays(7);

        QueryParamsForm queryParamsForm = QueryParamsForm.builder()
                .rooms(3).dateUntil(weeksinceToday)
                .dateSince(yesterdayDate)
                .size(Size.L)
                .types("detached_house")
                .build();
        StatsDto statsDto = marketService.getMarketStats(Region.LUBL, queryParamsForm);
        Assertions.assertNotNull(statsDto.getAvgValue());
    }
}
