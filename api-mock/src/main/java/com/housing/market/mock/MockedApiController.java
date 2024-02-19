package com.housing.market.mock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MockedApiController {
    @GetMapping(path = "/real-estates/{regionID}", produces = "application/json")
    public MarketDataForm getMockedHousing(@PathVariable String regionID) {
        MarketForm marketForm = MarketForm.builder()
                .rooms(1)
                .price(BigDecimal.valueOf(200000))
                .description("A space for you and your universe")
                .area(35f)
                .id("4caec08d-3cb7-46e0-9883-691eae200584")
                .type(Type.FLAT).build();

        MarketForm marketForm2 = MarketForm.builder()
                .rooms(2)
                .price(BigDecimal.valueOf(300000))
                .description("Your new place on earth")
                .area(44.5f)
                .id("4caec08d-3cb7-46e0-9883-691eae200584")
                .type(Type.SEMI_DETACHED_HOUSE).build();

        MarketForm marketForm3 = MarketForm.builder()
                .rooms(3)
                .price(BigDecimal.valueOf(400000))
                .description("Your new place on earth")
                .area(150f)
                .id("4caec08d-3cb7-46e0-9883-691eae200584")
                .type(Type.FLAT).build();

        MarketForm marketForm4 = MarketForm.builder()
                .rooms(4)
                .price(BigDecimal.valueOf(700000))
                .description("The greenest area in Poland for you and your family")
                .area(190f)
                .id("4caec08d-3cb7-46e0-9883-691eae200584")
                .type(Type.DETACHED_HOUSE)
                .build();


        return MarketDataForm.builder()
                .data(List.of(marketForm, marketForm2, marketForm3, marketForm4))
                .build();
    }
}
